package com.omggamesftw.gamemodelite;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class GameModeLite extends JavaPlugin implements Listener {
	
	public GameModeLite() {
	}
	
	@Override
    public void onEnable(){}
	
	@Override
    public void onDisable(){}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){}
	
	public boolean onCommand(CommandSender senderCmd, Command cmd, String label, String[] args)
	{
		if ((cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")) && senderCmd.hasPermission("gamemodelite.gamemode") )
		{
			Player sender = (Player)senderCmd;
			if (args.length == 0)
			{
				if (sender.getGameMode() != GameMode.CREATIVE )
				{
					sender.setGameMode(GameMode.CREATIVE);
				}
				else
				{
					sender.setGameMode(GameMode.SURVIVAL);
				}
			}
			else if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") )
				{
					sender.setGameMode(GameMode.SURVIVAL);
				}
				else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") )
				{
					sender.setGameMode(GameMode.CREATIVE);
				}
				else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") )
				{
					sender.setGameMode(GameMode.ADVENTURE);
				}
				else
				{
					sender.sendMessage("Invalid gamemode. Gamemode has not been changed.");
				}
			}
			else
			{
				
			}
			return true;
		}
		return false;
	}
}