// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial, Material

public class ItemHarvester extends ItemTool
{
	private int weaponDamage;

    protected ItemHarvester(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
        weaponDamage = 4 + enumtoolmaterial.getDamageVsEntity() * 2;
        
    }
    
    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        if(i == Block.leaves.blockID || i == Block.web.blockID)
        {
            itemstack.damageItem(1, entityliving);
        }
        return super.onBlockDestroyed(itemstack, i, j, k, l, entityliving);
    }
    
    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean canHarvestBlock(Block block)
    {
        return true;
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, 
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis,Block.planks, Block.bookShelf, Block.wood, Block.chest,
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField
        });
    }
}
