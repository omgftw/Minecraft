// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityCow, ModelBase, EntityLiving, 
//            Entity

public class RenderTurtle extends RenderLiving
{

    public RenderTurtle(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void renderTurtle(EntityTurtle entityturtle, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entityturtle, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderTurtle((EntityTurtle)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderTurtle((EntityTurtle)entity, d, d1, d2, f, f1);
    }
}
