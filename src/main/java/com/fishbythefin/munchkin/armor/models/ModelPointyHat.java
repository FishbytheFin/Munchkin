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
public class ModelPointyHat extends BipedModel<LivingEntity> {

    public ModelRenderer hat1;
    public ModelRenderer hat2;
    public ModelRenderer hat3;
    public ModelRenderer hat4;
    public ModelRenderer hat5;
    public ModelRenderer hat6;

    public ModelPointyHat(float modelSize) {
        super(modelSize, 0.0F, 128, 128);

        this.hat3 = new ModelRenderer(this, 0, 0);
        this.hat3.setPos(-4.0F, -8.0F, -4.0F);
        this.hat3.texOffs(64, 0).addBox(1.0F, -2.0F, 1.0F, 6.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.hat4 = new ModelRenderer(this, 0, 0);
        this.hat4.setPos(-4.0F, -8.0F, -4.0F);
        this.hat4.texOffs(64, 0).addBox(2.0F, -3.0F, 2.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.hat5 = new ModelRenderer(this, 0, 0);
        this.hat5.setPos(-4.0F, -8.0F, -4.0F);
        this.hat5.texOffs(64, 0).addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.hat6 = new ModelRenderer(this, 0, 0);
        this.hat6.setPos(-4.0F, -8.0F, -4.0F);
        this.hat6.texOffs(64, 0).addBox(3.0F, -3.0F, 8.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.hat2 = new ModelRenderer(this, 0, 0);
        this.hat2.setPos(-4.0F, -8.0F, -4.0F);
        this.hat2.texOffs(64, 0).addBox(0.0F, -1.0F, 0.0F, 8.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.hat1 = new ModelRenderer(this, 0, 0);
        this.hat1.setPos(-4.0F, -8.0F, -4.0F);
        this.hat1.texOffs(64, 0).addBox(-1.0F, 0.0F, -1.0F, 10.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);


        this.head.addChild(hat3);
        this.head.addChild(hat4);
        this.head.addChild(hat5);
        this.head.addChild(hat6);
        this.head.addChild(hat2);
        this.head.addChild(hat1);


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
