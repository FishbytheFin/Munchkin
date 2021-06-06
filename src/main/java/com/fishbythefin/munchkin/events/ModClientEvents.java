package com.fishbythefin.munchkin.events;

import com.fishbythefin.munchkin.MunchkinMod;
import com.fishbythefin.munchkin.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;
import java.util.List;

@Mod.EventBusSubscriber(modid = MunchkinMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    private static HashMap<String, Long> napalmStaffCooldowns = new HashMap<String, Long>();

    @SubscribeEvent
    public static void onMobDamage(AttackEntityEvent event) {
        if (event.getTarget().isAlive()) {
            PlayerEntity player = event.getPlayer();
            if (player.getMainHandItem().getItem().equals(RegistryHandler.KNEECAPHAMMER.get())) {
                LivingEntity entity = (LivingEntity) event.getTarget();
                entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 1));
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
                BlockPos pos = event.getPos();


                Vector3d vector3d = player.getViewVector(1.0F);

                FireballEntity fireball = new FireballEntity(serverWorld, player, vector3d.x, vector3d.y, vector3d.z);
                fireball.moveTo(pos.getX(), pos.getY() + 0.5D, pos.getZ());
                serverWorld.addFreshEntityWithPassengers(fireball);

            }
        }
    }

}
