package com.omggamesftw.trolltoolset;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.omggamesftw.trolltoolset.other.*;

public class TrollToolset extends JavaPlugin implements Listener 
{
	
	//Map<String, String> allTools = new HashMap<String, String>();
	String[] allTools = 
		{
			"Chatter",
			"Damage",
			"Dropper",
			"Explode",
			"Hunger"
		};
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		new File(getDataFolder() + "").mkdir();
    }
	
	@Override
    public void onDisable() 
	{
    }
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) 
	{
    }
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
	
		if((cmd.getName().equalsIgnoreCase("trolltoolset") || cmd.getName().equalsIgnoreCase("tt")) && args.length >= 1)
		{
			
			User user = new User(sender);
			
			if ( args[0].equalsIgnoreCase("help") ) 
			{
				user.sendMessage("TrollToolset Help:\n" +
						"Type: \"/tt toolname\" to get more information about a specific tool.\n" +
						"Available tools:\n");
				
				int availTools = 0;
				
				for (int i = 0; i < allTools.length; i++)
				{
					if (user.hasPermission("trolltoolset." + allTools[i]) || user.hasPermission("trolltoolset.*"))
					{
						user.sendMessage(allTools[i] + "\n");
						availTools++;
					}
				}
				
				if (availTools == 0)
				{
					user.sendMessage("No tools available.");
				}
				
			}
			
			if (args[0].equalsIgnoreCase("toolname"))
			{
				user.sendMessage("Type the name of the tool, not \"toolname\". Example: /tt chatter");
			}
			
			for (int i = 0; i < allTools.length; i++)
			{
				if (args[0].equalsIgnoreCase(allTools[i]) && (user.hasPermission("trolltoolset." + allTools[i]) || user.hasPermission("trolltoolset.*")))
				{
					try{ Class.forName("com.omggamesftw.trolltoolset.tools." + allTools[i]).getConstructor(User.class, String[].class).newInstance(user, args); } catch(Exception x){}
					break;
				}
				else if (args[0].equalsIgnoreCase(allTools[i]) && (!user.hasPermission("trolltoolset." + allTools[i]) && !user.hasPermission("trolltoolset.*")))
				{
					user.sendMessage("You do not have permission to use this tool.");
				}
			}
			/*
			else if (args[0].equalsIgnoreCase("chatter") && (sender.hasPermission("trolltoolset.chatter") || sender.hasPermission("trolltoolset.*")))
			{
				@SuppressWarnings("unused")
				Chatter chatter = new Chatter(user, args);
			}
			
			else if (args[0].equalsIgnoreCase("damage") && (sender.hasPermission("trolltoolset.damage") || sender.hasPermission("trolltoolset.*")))
			{
				@SuppressWarnings("unused")
				Damage damage = new Damage(user, args);
			}
			
			else if (args[0].equalsIgnoreCase("dropper") && (sender.hasPermission("trolltoolset.dropper") || sender.hasPermission("trolltoolset.*")))
			{
				@SuppressWarnings("unused")
				Dropper damage = new Dropper(user, args);
			}
			*/
			
			return true;
		}
		return false;
	}
}