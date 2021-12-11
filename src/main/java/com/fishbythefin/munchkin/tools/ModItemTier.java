package com.fishbythefin.munchkin.tools;

import com.fishbythefin.munchkin.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    ORC(3, -1, 10.0F, -1.0F, 10, () -> {
        return Ingredient.of(RegistryHandler.ORCBGONE.get());
    }),
    KNEECAPPINGHAMMER(0, -1, 1.0F, -1.0F, 10, () -> {
        return Ingredient.of(RegistryHandler.KNEECAPHAMMER.get());
    }),
    HUGEROCK(0, -1, 1.0F, -1.0F, 10, () -> {
        return Ingredient.of(Tags.Items.STONE);
    }),
    DAGGER(0, -1, 1.0F, -1.0F, 10, () ->
    {
        return Ingredient.of(RegistryHandler.DAGGER.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}
