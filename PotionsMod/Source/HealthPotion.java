package net.minecraft.src;

public class HealthPotion extends ItemFood {
	
	public HealthPotion(int ItemIDPlus256, int HealAmt, boolean isWolfFavFood){
		super(ItemIDPlus256, HealAmt, isWolfFavFood);
		super.setMaxStackSize(20);
	}
	
}
