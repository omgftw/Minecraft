package net.minecraft.src;

import java.util.Timer;
import java.util.TimerTask;

public class ImmortalityPotion extends Item {

	EntityPlayer player;
	
	protected ImmortalityPotion(int ItemIDPlus256) {
		super(ItemIDPlus256);
		super.setMaxStackSize(1);
	}
	
	
	
	 public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
		 player = entityplayer;
		 player.health = 10000;
		 
		Timer timing = new Timer();
		timing.schedule(new MortalTime(), 60000);
		itemstack.stackSize--;

	        return itemstack;
	        
	    }
	 
	 private class MortalTime extends TimerTask{

		@Override
		public void run() {
			player.health = 20;
		}
		 
	 }

}
