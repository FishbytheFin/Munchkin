package com.fishbythefin.munchkin.armor;

import com.fishbythefin.munchkin.armor.models.ModelCourageHelm;
import com.fishbythefin.munchkin.armor.models.ModelPointyHat;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class CourageHelmItem extends ArmorItem {

    public CourageHelmItem(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_) {
        super(p_i48534_1_, p_i48534_2_, p_i48534_3_);
    }

    @Override
    public BipedModel getArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel _default) {
        if (itemStack != ItemStack.EMPTY) {
            if (itemStack.getItem() instanceof ArmorItem) {
                ModelCourageHelm model = new ModelCourageHelm(1.0f);

                model.head.visible = armorSlot == EquipmentSlotType.HEAD;

                model.young = _default.young;
                model.riding = _default.riding;
                model.crouching = _default.crouching;
                model.rightArmPose = _default.rightArmPose;
                model.leftArmPose = _default.leftArmPose;

                return model;
            }
        }
        return null;
    }
}
