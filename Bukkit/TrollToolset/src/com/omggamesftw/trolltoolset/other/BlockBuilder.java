package com.omggamesftw.trolltoolset.other;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockBuilder {

	Location loc;
	
	public BlockBuilder(User user, Integer x, Integer y, Integer z)
	{
		loc = new Location(user.getWorld(), x, y, z);
	}
	
	public void build(int amt, char direction, Material mat, User user, Integer startX, Integer startY, Integer startZ)
	{
		Location loc = new Location(user.getWorld(), startX, startY, startZ);
		//Block block = user.getWorld().getBlockAt(loc);
		//block.setType(mat);
		
		if (direction == 'N' || direction == 'n')
		{
			for (int i = 0; i < amt; i++)
			{
				Block block = user.getWorld().getBlockAt(loc);
			}
		}
	}

}
