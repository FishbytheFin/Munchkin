package com.fishbythefin.munchkin.util;

import com.fishbythefin.munchkin.MunchkinMod;
import com.fishbythefin.munchkin.armor.CourageHelmItem;
import com.fishbythefin.munchkin.armor.ModArmorMaterial;
import com.fishbythefin.munchkin.armor.PointyHatItem;
import com.fishbythefin.munchkin.blocks.BlockItemBase;
import com.fishbythefin.munchkin.blocks.DungeonBricksBlock;
import com.fishbythefin.munchkin.items.NapalmStaffBase;
import com.fishbythefin.munchkin.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
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

    public static final RegistryObject<Item> FACE = ITEMS.register("face", NapalmStaffBase::new);
    public static final RegistryObject<Item> NAPALMSTAFF = ITEMS.register("napalm_staff", NapalmStaffBase::new);
    public static final RegistryObject<Item> PRETTYBALLOON = ITEMS.register("pretty_balloon", NapalmStaffBase::new);

    //Tools

    public static final RegistryObject<AxeItem> ORCBGONE = ITEMS.register("orc_b_gone", () ->
            new AxeItem(ModItemTier.ORC, 13.0F, -3.2F, new Item.Properties()));
    public static final RegistryObject<AxeItem> KNEECAPHAMMER = ITEMS.register("kneecap_hammer", () ->
            new AxeItem(ModItemTier.KNEECAPPINGHAMMER, 11.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<PickaxeItem> HUGEROCK = ITEMS.register("huge_rock", () ->
            new PickaxeItem(ModItemTier.HUGEROCK, 15, -3.4F, new Item.Properties()));
    public static final RegistryObject<SwordItem> DAGGER = ITEMS.register("dagger", () ->
            new SwordItem(ModItemTier.DAGGER, 7, -2.2F, new Item.Properties()));

    //Armor

    public static final RegistryObject<ArmorItem> BUTTKICKBOOTS = ITEMS.register("buttkicking_boots", () ->
            new ArmorItem(ModArmorMaterial.BUTTKICK, EquipmentSlotType.FEET, new Item.Properties()));

    public static final RegistryObject<PointyHatItem> POINTY_HAT = ITEMS.register("pointy_hat", () ->
            new PointyHatItem(ModArmorMaterial.POINTY, EquipmentSlotType.HEAD, new Item.Properties()));

    public static final RegistryObject<CourageHelmItem> COURAGE_HELM = ITEMS.register("courage_helm", () ->
            new CourageHelmItem(ModArmorMaterial.COURAGE, EquipmentSlotType.HEAD, new Item.Properties()));
    public static final RegistryObject<ArmorItem> STRENGTH_PANTYHOSE = ITEMS.register("strength_pantyhose", () ->
            new ArmorItem(ModArmorMaterial.PANTYHOSE, EquipmentSlotType.LEGS, new Item.Properties()));

    //Blocks
    public static final RegistryObject<Block> DUNGEON_BRICKS_BLOCK = BLOCKS.register("dungeon_bricks", DungeonBricksBlock::new);

    //Block Items
    public static final RegistryObject<Item> DUNGEON_BRICKS_BLOCK_ITEM = ITEMS.register("dungeon_bricks", () -> new BlockItemBase(DUNGEON_BRICKS_BLOCK.get()));


}
