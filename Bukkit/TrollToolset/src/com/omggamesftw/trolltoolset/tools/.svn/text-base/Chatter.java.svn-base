package com.omggamesftw.trolltoolset.tools;

import org.bukkit.entity.Player;

import com.omggamesftw.trolltoolset.other.User;

public class Chatter {

	public Chatter(User sender, String[] args)
	{
		if (args.length == 1)
		{
			sender.sendMessage("TrollToolset Chatter:\n" +
					"Usage: /tt chatter player message\n" +
					"Description: Force a player to send messages or commands.");
		}
		else if (args.length >= 3)
		{
			String targetName = args[1];
			
			String message = args[2];
			for (int i = 3; i < args.length; i++)
			{
				message += " " + args[i];
			}
			
			if (targetName.equalsIgnoreCase("all") || targetName.equalsIgnoreCase("*"))
			{
				Player[] players = sender.getServer().getOnlinePlayers();
				for (int i  = 0; i < players.length; i++)
				{
					players[i].chat(message);
				}
			}
			else
			{
				Player target = sender.getServer().getPlayer(targetName);
				if (target != null)
				{
					target.chat(message);
				}
				else
				{
					sender.sendMessage("Error: Player not found.");
				}
			}
		}
		else
		{
			sender.sendMessage("Usage: /tt chatter player message");
		}
	}

}
