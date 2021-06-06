package com.fishbythefin.munchkin.events;

import com.fishbythefin.munchkin.MunchkinMod;
import com.fishbythefin.munchkin.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MunchkinMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

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
            PlayerEntity player = event.getPlayer();
            BlockPos pos = event.getPos();
            event.getWorld().explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, true, Explosion.Mode.BREAK);
        }
    }
}
