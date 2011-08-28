package net.minecraft.src;

import java.util.Timer;
import java.util.TimerTask;

public class LongArmPotion extends Item {
	

	
	public LongArmPotion(int ItemIDPlus256) {
		super(ItemIDPlus256);
		super.setMaxStackSize(20);

	}
	
	//EntityPlayer player;
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		PlayerControllerSP.setBlockReachDistance(25F);
		Timer timing = new Timer();
		timing.schedule(new shortreach(), 30000);
		itemstack.stackSize--;
        
        return itemstack;
        
    }
	
	
	private class shortreach extends TimerTask{
		public void run(){
		PlayerControllerSP.setBlockReachDistance(4F);
		}
		
	}

}
