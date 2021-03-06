package com.fishbythefin.munchkin.events;

import com.fishbythefin.munchkin.MunchkinMod;
import com.fishbythefin.munchkin.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = MunchkinMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    private static HashMap<String, Long> napalmStaffCooldowns = new HashMap<String, Long>();

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getTarget() instanceof LivingEntity) {
            PlayerEntity player = event.getPlayer();
            LivingEntity entity = (LivingEntity) event.getTarget();
            if (player.getMainHandItem().getItem().equals(RegistryHandler.KNEECAPHAMMER.get())) {
                entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 1));
            }


            float bonusDamage = 0.0F;
            //Helmets
            if (player.inventory.armor.get(3).getItem().equals(RegistryHandler.POINTY_HAT.get())) {
                bonusDamage += 1.0F;
            } else if (player.inventory.armor.get(3).getItem().equals(RegistryHandler.COURAGE_HELM.get().getItem())) {
                bonusDamage += 3.0F;
            }
            //Chestplates

            //Leggings
            if (player.inventory.armor.get(1).getItem().equals(RegistryHandler.STRENGTH_PANTYHOSE.get())) {
                bonusDamage += 1.0F;
            }

            //Boots
            if (player.inventory.armor.get(0).getItem().equals(RegistryHandler.BUTTKICKBOOTS.get())) {
                bonusDamage += 2.0F;
            }

            //other

            entity.setHealth(Math.max(0.0f, Math.min(20.0f, entity.getHealth() - bonusDamage)));

        }
    }

    @SubscribeEvent
    public static void onMobDamage(LivingHurtEvent event) {
        if (event.getEntity() instanceof LivingEntity){
            if (event.getSource().getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItemStack().getItem().equals(RegistryHandler.NAPALMSTAFF.get())) {


            World world = event.getWorld();
            if (world instanceof ServerWorld) {
                PlayerEntity player = event.getPlayer();
                if (napalmStaffCooldowns.containsKey(player.getName().getString())) {
                    if (napalmStaffCooldowns.get(player.getName().getString()) > System.currentTimeMillis()) {
                        return;
                    }
                }
                napalmStaffCooldowns.put(player.getName().getString(), System.currentTimeMillis() + (3 * 1000));
                ServerWorld serverWorld = (ServerWorld) world;


                Vector3d vector3d = player.getViewVector(1.0F);

                FireballEntity fireball = new FireballEntity(serverWorld, player, vector3d.x, vector3d.y, vector3d.z);
                fireball.moveTo(player.getX(), player.getY() + 0.5D, player.getZ());
                serverWorld.addFreshEntityWithPassengers(fireball);

            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
       PlayerEntity player = event.player;

       if (player.inventory.armor.get(3).getItem().equals(RegistryHandler.COURAGE_HELM.get())) {
           player.addEffect(new EffectInstance(Effects.BLINDNESS, 20, 0));
       }
       if (player.getMainHandItem().getItem().equals(RegistryHandler.HUGEROCK.get()) || player.getOffhandItem().getItem().equals(RegistryHandler.HUGEROCK.get())) {
           player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 0));
       }
       if (player.getMainHandItem().getItem().equals(RegistryHandler.PRETTYBALLOON.get()) || player.getOffhandItem().getItem().equals(RegistryHandler.PRETTYBALLOON.get())) {
           player.addEffect(new EffectInstance(Effects.LEVITATION, 20, 0));
       }
    }

}
