package com.omggamesftw.gluttony;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Gluttony extends JavaPlugin implements Listener {
	
	public Gluttony() {
	}
	
	@Override
    public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getScheduler().scheduleSyncRepeatingTask(this,new Runnable() {
			public void run()
			{
				Player[] players = getServer().getOnlinePlayers();
				for (int i = 0; i < players.length; i++)
				{
					players[i].setFoodLevel(20);
					players[i].setSaturation(20);
				}
			}
		}, 0, 600);
    }
	
	@Override
    public void onDisable() 
	{
    }
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) 
	{
		Player player = event.getPlayer();
		player.setFoodLevel(20);
		player.setSaturation(20);
    }
}