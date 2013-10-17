package com.omggamesftw.seeingeye;

import org.bukkit.inventory.ItemStack;

public class InventoryManager {

	public String viewer;
	public String opener;
	public ItemStack viewerOrigItems;
	
	public InventoryManager(String viewer, String opener, ItemStack viewerOrigItems)
	{
		this.viewer = viewer;
		this.opener = opener;
		this.viewerOrigItems = viewerOrigItems;
	}

}
