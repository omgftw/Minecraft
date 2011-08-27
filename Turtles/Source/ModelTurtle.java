// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelQuadruped, ModelRenderer

public class ModelTurtle extends ModelBase
{

    public ModelTurtle()
    {
    	
    	New_Shape1 = new ModelRenderer(0, 0);
		New_Shape1.addBox(2F, 0F, 0F, 1, 1, 1, 0F);
		New_Shape1.setRotationPoint(0F, 23F, 0F);
		
		New_Shape1.rotateAngleX = 0F;
		New_Shape1.rotateAngleY = 0F;
		New_Shape1.rotateAngleZ = 0F;
		New_Shape1.mirror = false;
		
		New_Shape2 = new ModelRenderer(0, 0);
		New_Shape2.addBox(-2F, 0F, 0F, 1, 1, 1, 0F);
		New_Shape2.setRotationPoint(0F, 23F, 0F);
		
		New_Shape2.rotateAngleX = 0F;
		New_Shape2.rotateAngleY = 0F;
		New_Shape2.rotateAngleZ = 0F;
		New_Shape2.mirror = false;
		
		New_Shape3 = new ModelRenderer(0, 0);
		New_Shape3.addBox(2F, 0F, 0F, 1, 1, 1, 0F);
		New_Shape3.setRotationPoint(0F, 23F, 5F);
		
		New_Shape3.rotateAngleX = 0F;
		New_Shape3.rotateAngleY = 0F;
		New_Shape3.rotateAngleZ = 0F;
		New_Shape3.mirror = false;
		
		New_Shape4 = new ModelRenderer(0, 0);
		New_Shape4.addBox(-2F, 0F, 0F, 1, 1, 1, 0F);
		New_Shape4.setRotationPoint(0F, 23F, 5F);
		
		New_Shape4.rotateAngleX = 0F;
		New_Shape4.rotateAngleY = 0F;
		New_Shape4.rotateAngleZ = 0F;
		New_Shape4.mirror = false;
		
		New_Shape5 = new ModelRenderer(0, 0);
		New_Shape5.addBox(-2F, 0F, 0F, 5, 3, 6, 0F);
		New_Shape5.setRotationPoint(0F, 20F, 0F);
		
		New_Shape5.rotateAngleX = 2.790295E-16F;
		New_Shape5.rotateAngleY = 0F;
		New_Shape5.rotateAngleZ = 0F;
		New_Shape5.mirror = false;
		
		New_Shape6 = new ModelRenderer(0, 0);
		New_Shape6.addBox(0F, 0F, 0F, 1, 1, 1, 0F);
		New_Shape6.setRotationPoint(0F, 22F, -1F);
		
		New_Shape6.rotateAngleX = 0F;
		New_Shape6.rotateAngleY = 0F;
		New_Shape6.rotateAngleZ = 0F;
		New_Shape6.mirror = false;
		
		
	}

	public void render(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		New_Shape1.render(f5);
		New_Shape2.render(f5);
		New_Shape3.render(f5);
		New_Shape4.render(f5);
		New_Shape5.render(f5);
		New_Shape6.render(f5);
		
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

	//fields
	public ModelRenderer New_Shape1;
	public ModelRenderer New_Shape2;
	public ModelRenderer New_Shape3;
	public ModelRenderer New_Shape4;
	public ModelRenderer New_Shape5;
	public ModelRenderer New_Shape6;
	
}
