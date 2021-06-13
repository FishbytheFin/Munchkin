package com.fishbythefin.munchkin;

import com.fishbythefin.munchkin.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("munchkin")
public class MunchkinMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "munchkin";

    public MunchkinMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    public static final ItemGroup TAB = new ItemGroup("munchkinTab") {
        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            items.add(new ItemStack(RegistryHandler.ORCBGONE.get()));
            items.add(new ItemStack(RegistryHandler.KNEECAPHAMMER.get()));
            items.add(new ItemStack(RegistryHandler.NAPALMSTAFF.get()));
            items.add(new ItemStack(RegistryHandler.POINTY_HAT.get()));
            items.add(new ItemStack(RegistryHandler.COURAGE_HELM.get()));
            items.add(new ItemStack(RegistryHandler.BUTTKICKBOOTS.get()));
            items.add(new ItemStack(RegistryHandler.DUNGEON_BRICKS_BLOCK_ITEM.get()));
            super.fillItemList(items);
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.ORCBGONE.get());
        }
    };

}
