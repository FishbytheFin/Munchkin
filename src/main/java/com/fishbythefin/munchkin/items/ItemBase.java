package com.fishbythefin.munchkin.items;

import com.fishbythefin.munchkin.MunchkinMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Properties().tab(MunchkinMod.TAB));
    }
}
