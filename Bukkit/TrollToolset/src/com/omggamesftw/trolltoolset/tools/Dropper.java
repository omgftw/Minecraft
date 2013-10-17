package com.omggamesftw.trolltoolset.tools;

import org.bukkit.Location;
import java.util.Random;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import com.omggamesftw.trolltoolset.other.User;

public class Dropper {

	private void dropItems(Player player, User sender)
	{
		PlayerInventory inv = player.getInventory();
		Location loc = player.getLocation();
		World world = player.getWorld();
		
		//set a random spot to drop the item:
		Random rng = new Random();
		Integer xCoord = (int)(rng.nextDouble() * 10) + 2;
		Integer zCoord = (int)(rng.nextDouble() * 10) + 2;
		Integer xPlusMinus = (int)(rng.nextDouble() * 2);
		Integer zPlusMinus = (int)(rng.nextDouble() * 2);
		if (xPlusMinus == 0){xPlusMinus--;}
		if (zPlusMinus == 0){zPlusMinus--;}
		xCoord *= xPlusMinus;
		zCoord *= zPlusMinus;
		
		loc.setX(loc.getX() + xCoord);
		loc.setZ(loc.getZ() + zCoord);
		
		if (world.getBlockAt(loc).isEmpty())
		{
			for (int i = 0; i < inv.getSize(); i++)
			{
				if (inv.getItem(i) != null)
				{
					world.dropItem(loc, inv.getItem(i));
					inv.clear(i);
				}
			}
			player.sendMessage("Your items have fallen on the ground nearby.");
		}
		else
		{
			sender.sendMessage("Drop location obstructed for " + player.getDisplayName() + ".\nTheir items have not been dropped.");
		}
	}
	
	public Dropper(User sender, String[] args)
	{
		if (args.length == 1)
		{
			sender.sendMessage("TrollToolset Dropper:\n" +
					"Usage: /tt dropper player\n" +
					"Description: Makes a player drop their entire inventory on the ground.");
		}
		
		else if (args.length >= 2)
		{
			String targetName = args[1];
			
			if (targetName.equalsIgnoreCase("all") || targetName.equalsIgnoreCase("*"))
			{
				Player[] players = sender.getServer().getOnlinePlayers();
				for (int i = 0; i < players.length; i++)
				{
					dropItems(players[i], sender);
				}
				sender.sendMessage("All players have dropped their items.");
			}
			else
			{
				Player target = sender.getServer().getPlayer(targetName);
				if (target != null)
				{
					dropItems(target, sender);
					sender.sendMessage(target.getDisplayName() + " has dropped their items on the ground");
				}
				else
				{
					sender.sendMessage("Error: Player not found.");
				}
			}
		}
	}

}
