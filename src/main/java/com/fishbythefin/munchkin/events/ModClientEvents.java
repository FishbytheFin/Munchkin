package com.fishbythefin.munchkin.events;

import com.fishbythefin.munchkin.MunchkinMod;
import com.fishbythefin.munchkin.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
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
}
