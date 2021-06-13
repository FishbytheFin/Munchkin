package com.fishbythefin.munchkin.armor.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelPointyHat - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelCourageHelm extends BipedModel<LivingEntity> {

    public ModelRenderer helm;
    public ModelRenderer horn1;
    public ModelRenderer horn2;

    public ModelCourageHelm(float modelSize) {
        super(modelSize, 0.0F, 128, 128);

        this.helm = new ModelRenderer(this, 0, 0);
        this.helm.setPos(-4.0F, -8.0F, -4.0F);
        this.helm.texOffs(1, 73).addBox(-0.3F, -0.2F, -0.1F, 8.6F, 6.0F, 8.2F, 0.0F, 0.0F, 0.0F);

        this.horn1 = new ModelRenderer(this, 0, 0);
        this.horn1.setPos(-4.0F, -8.0F, -4.0F);
        this.horn1.texOffs(0, 90).addBox(-0.8F, -1.0F, 3.5F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.horn2 = new ModelRenderer(this, 0, 0);
        this.horn2.setPos(-4.0F, -8.0F, -4.0F);
        this.horn2.texOffs(0, 90).addBox(7.8F, -1.0F, 3.5F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.head.addChild(helm);
        this.head.addChild(horn1);
        this.head.addChild(horn2);

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }


}
