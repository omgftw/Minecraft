package com.omggamesftw.trolltoolset.tools;

import org.bukkit.entity.Player;

import com.omggamesftw.trolltoolset.other.User;

public class Damage 
{	
	
	public Damage(User sender, String[] args)
	{
		if (args.length == 1)
		{
			sender.sendMessage("TrollToolset Damage:\n" +
					"Usage: /tt damage player [amount (Optional, Default: half a heart)]\n" +
					"Description: Damages a player.");
		}
		
		else if (args.length >= 2)
		{
			Integer dmgAmt = 1;
			if (args.length >= 3)
			{
				try{dmgAmt = Integer.parseInt(args[2]);}catch(Exception e){}
			}
			String targetName = args[1];
			
			if (targetName.equalsIgnoreCase("all") || targetName.equalsIgnoreCase("*"))
			{
				Player[] players = sender.getServer().getOnlinePlayers();
				for (int i = 0; i < players.length; i++)
				{
					players[i].damage(dmgAmt);
				}
				sender.sendMessage("All players have taken " + dmgAmt.toString() + " damage.");
			}
			else
			{
				Player target = sender.getServer().getPlayer(targetName);
				if (target != null)
				{
					target.damage(dmgAmt);
					sender.sendMessage(target.getDisplayName() + " has taken " + dmgAmt.toString() + " damage.");
				}
				else
				{
					sender.sendMessage("Error: Player not found.");
				}
			}
		}
		
		else
		{
			sender.sendMessage("Usage: /tt damage player [amount (Optional, Default: half a heart)]");
		}
	}

}



