package net.minecraft.src;

public class BlinkPotion extends Item {
	
	protected BlinkPotion(int ItemIDPlus256) {
		super(ItemIDPlus256);
		super.setMaxStackSize(64);
	}

	 public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
		 entityplayer.motionX *= 15;
		 entityplayer.motionZ *= 15;
		 itemstack.stackSize--;

	        return itemstack;   
	    }
}
