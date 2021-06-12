package com.fishbythefin.munchkin.util;

import com.fishbythefin.munchkin.MunchkinMod;
import com.fishbythefin.munchkin.armor.ModArmorMaterial;
import com.fishbythefin.munchkin.blocks.BlockItemBase;
import com.fishbythefin.munchkin.blocks.DungeonBricksBlock;
import com.fishbythefin.munchkin.items.ItemBase;
import com.fishbythefin.munchkin.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MunchkinMod.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MunchkinMod.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items

    public static final RegistryObject<Item> NAPALMSTAFF = ITEMS.register("napalm_staff", ItemBase::new);

    //Tools

    public static final RegistryObject<AxeItem> ORCBGONE = ITEMS.register("orc_b_gone", () ->
            new AxeItem(ModItemTier.ORC, 13.0F, -3.2F, new Item.Properties().tab(MunchkinMod.TAB)));
    public static final RegistryObject<AxeItem> KNEECAPHAMMER = ITEMS.register("kneecap_hammer", () ->
            new AxeItem(ModItemTier.KNEECAPPINGHAMMER, 11.0F, -3.0F, new Item.Properties().tab(MunchkinMod.TAB)));

    //Armor

    public static final RegistryObject<ArmorItem> BUTTKICKBOOTS = ITEMS.register("buttkicking_boots", () ->
            new ArmorItem(ModArmorMaterial.BUTTKICK, EquipmentSlotType.FEET, new Item.Properties().tab(MunchkinMod.TAB)));

    //Blocks
    public static final RegistryObject<Block> DUNGEON_BRICKS_BLOCK = BLOCKS.register("dungeon_bricks", DungeonBricksBlock::new);

    //Block Items
    public static final RegistryObject<Item> DUNGEON_BRICKS_BLOCK_ITEM = ITEMS.register("dungeon_bricks", () -> new BlockItemBase(DUNGEON_BRICKS_BLOCK.get()));

}
