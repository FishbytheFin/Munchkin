package com.fishbythefin.munchkin.blocks;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DungeonBricksBlock extends Block {
    public DungeonBricksBlock() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(-1, 999)
                .sound(SoundType.STONE));
    }
}
