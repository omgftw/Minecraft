package com.omggamesftw.trolltoolset.tools;

import org.bukkit.entity.Player;

import com.omggamesftw.trolltoolset.other.User;

public class Explode {
	
	public Explode(User sender, String[] args)
	{
		
		if (args.length == 1)
		{
			sender.sendMessage("TrollToolset Explode:\n" +
					"Usage: /tt explode player [explosion radius (Optional, Default: 5)]\n" +
					"Description: Causes a player to explode.");
		}
		else if ( args.length >= 2)
		{
			int explodeRad = 5;
			if (args.length >= 3)
			{
				try{explodeRad = (Integer.parseInt(args[2]));}catch(Exception e){}
			}
			
			String targetName = args[1];
			
			if (targetName.equalsIgnoreCase("all"))
			{
				Player[] players = sender.getServer().getOnlinePlayers();
				for (int i = 0; i < players.length; i++)
				{
					players[i].getWorld().createExplosion(players[i].getLocation(), explodeRad);
				}
				sender.sendMessage("All players have exploded.");
			}
			else
			{
				Player target = sender.getServer().getPlayer(targetName);
				if (target != null)
				{
					target.getWorld().createExplosion(target.getLocation(), explodeRad);
					sender.sendMessage(target.getDisplayName() + " has exploded.");
				}
				else 
				{
					sender.sendMessage("Error: Player not found.");
				}
			}
			
			
		}
		else
		{
			sender.sendMessage("Usage: /tt explode player [explosion radius (Optional, Default: 5)]");
		}

		
		
	}	
}