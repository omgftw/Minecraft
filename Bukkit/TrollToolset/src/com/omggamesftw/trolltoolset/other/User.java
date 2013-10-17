package com.omggamesftw.trolltoolset.other;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class User {

	Boolean isPlayer = false;
	Player player;
	ConsoleCommandSender cmdSndr;
	
	public User(CommandSender sndr)
	{
		if (sndr instanceof Player)
		{
			player = (Player)sndr;
			isPlayer = true;
		}
		else
		{
			cmdSndr = (ConsoleCommandSender)sndr;
		}
	}
	
	public void sendMessage(String message)
	{
		if (isPlayer)
		{
			player.sendMessage(message);
		}
		else
		{
			cmdSndr.sendMessage(message);
		}
	}
	
	public Server getServer()
	{
		if (isPlayer)
		{
			return player.getServer();
		}
		else
		{
			return cmdSndr.getServer();
		}
	}
	
	public World getWorld()
	{
		if (isPlayer)
		{
			return player.getWorld();
		}
		else
		{
			return null;
		}
	}
	
	public Boolean hasPermission(String permission)
	{
		if (isPlayer)
		{
			return player.hasPermission(permission);
		}
		else
		{
			return true;
		}
	}
	
	public Boolean isPlayer()
	{
		return isPlayer;
	}
	
	
}
