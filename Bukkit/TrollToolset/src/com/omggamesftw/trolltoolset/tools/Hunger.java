package com.omggamesftw.trolltoolset.tools;

import org.bukkit.entity.Player;

import com.omggamesftw.trolltoolset.other.User;

public class Hunger 
{	
	
	public Hunger(User sender, String[] args)
	{
		if (args.length == 1)
		{
			sender.sendMessage("TrollToolset hunger:\n" +
					"Usage: /tt hunger player [amount 0-20 (20 being full)(Optional, Default: 0/Starving)]\n" +
					"Description: Makes a player hungry.");
		}
		
		else if (args.length >= 2)
		{
			Integer hungerAmt = 0;
			if (args.length >= 3)
			{
				try{hungerAmt = Integer.parseInt(args[2]);}catch(Exception e){}
			}
			String targetName = args[1];
			
			if (targetName.equalsIgnoreCase("all") || targetName.equalsIgnoreCase("*"))
			{
				Player[] players = sender.getServer().getOnlinePlayers();
				for (int i = 0; i < players.length; i++)
				{
					players[i].setFoodLevel(hungerAmt);
				}
				sender.sendMessage("All players' hunger has been set to " + hungerAmt.toString() + ".");
			}
			else
			{
				Player target = sender.getServer().getPlayer(targetName);
				if (target != null)
				{
					target.setFoodLevel(hungerAmt);
					sender.sendMessage(target.getDisplayName() + "§c's§f hunger has been set to " + hungerAmt.toString() + ".");
				}
				else
				{
					sender.sendMessage("Error: Player not found.");
				}
			}
		}
		
		else{}
	}

}



