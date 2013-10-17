package com.omggamesftw.playerperks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerPerks extends JavaPlugin implements Listener {
	
	List<String> nightvision = new ArrayList<String>();
	List<String> speed = new ArrayList<String>();
	
	
	public PlayerPerks() {}
	
	private void toggleNightVision(Player player)
	{
		String playerName = player.getName();
		if (nightvision.contains(playerName))
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 0, 0), true);
			nightvision.remove(playerName);
			player.sendMessage("Nightvision has been turned off.");
		}
		else
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 12000, 1), true);
			nightvision.add(playerName);
			player.sendMessage("Nightvision has been turned on.");
		}
	}
	
	private void toggleSpeed(Player player)
	{
		String playerName = player.getName();
		if (speed.contains(playerName))
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true);
			speed.remove(playerName);
			player.sendMessage("Speed has been turned off.");
		}
		else
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 12000, 3), true);
			speed.add(playerName);
			player.sendMessage("Speed has been turned on.");
		}
	}
	
	private void loadNightVision()
	{
		if (new File(getDataFolder() + File.separator + "nightvisionplayers").exists())
		{
			try 
			{
				Scanner reader = new Scanner(new FileInputStream(getDataFolder() + File.separator + "nightvisionplayers"));
				
				while (reader.hasNextLine())
				{
					nightvision.add(reader.nextLine());
				}
				reader.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void loadSpeed()
	{
		if (new File(getDataFolder() + File.separator + "speedplayers").exists())
		{
			try 
			{
				Scanner reader = new Scanner(new FileInputStream(getDataFolder() + File.separator + "speedplayers"));
				
				while (reader.hasNextLine())
				{
					speed.add(reader.nextLine());
				}
				reader.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void saveNightVision()
	{
		if (new File(getDataFolder() + "").exists())
		{
			try 
			{
				if (nightvision.size() >= 1)
				{
					Writer output = new FileWriter(getDataFolder() + File.separator + "nightvisionplayers");
					output.write(nightvision.get(0));
					for (int i = 1; i < nightvision.size(); i++)
					{
						output.write("\n" + nightvision.get(i));
						output.flush();
					}
					output.close();
				}
				else
				{
					File nv = new File(getDataFolder() + File.separator + "nightvisionplayers");
					 if (nv.exists())
					 {
						 nv.delete();
					 }
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void saveSpeed()
	{
		if (new File(getDataFolder() + "").exists())
		{
			try 
			{
				if (speed.size() >= 1)
				{
					Writer output = new FileWriter(getDataFolder() + File.separator + "speedplayers");
					output.write(speed.get(0));
					for (int i = 1; i < speed.size(); i++)
					{
						output.write("\n" + speed.get(i));
						output.flush();
					}
					output.close();
				}
				else
				{
					File s= new File(getDataFolder() + File.separator + "speedplayers");
					 if (s.exists())
					 {
						 s.delete();
					 }
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
    public void onEnable()
	{
		new File(getDataFolder() + "").mkdir();
		loadNightVision();
		loadSpeed();
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getScheduler().scheduleSyncRepeatingTask(this,new Runnable() {
			public void run()
			{
				for (int i = 0; i < nightvision.size(); i++)
				{
					Player player = getServer().getPlayer(nightvision.get(i));
					if (player != null)
					{
						player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 12000, 1), true);
					}
				}
				for (int i = 0; i < speed.size(); i++)
				{
					Player player = getServer().getPlayer(speed.get(i));
					if (player != null)
					{
						player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 12000, 3), true);
					}
				}
			}
		}, 0, 1200);
	}
	
	@Override
    public void onDisable()
	{
		saveNightVision();
		saveSpeed();
	}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) 
	{
		Player player = event.getPlayer();
		if (nightvision.contains(player.getName()))
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 12000, 1), true);
		}
		if (speed.contains(player.getName()))
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 12000, 3), true);
		}
    }
	
	public boolean onCommand(CommandSender senderCmd, Command cmd, String label, String[] args)
	{
		if (senderCmd instanceof Player)
		{
			Player player = (Player)senderCmd;
			
			if ((cmd.getName().equalsIgnoreCase("nightvision") || cmd.getName().equalsIgnoreCase("nv")) && player.hasPermission("playerperks.nightvision"))
			{
				toggleNightVision(player);
				return true;
			}
			else if (!player.hasPermission("playerperks.nightvision"))
			{
				player.sendMessage("§4You do not have access to that command.");
			}
			
			if ((cmd.getName().equalsIgnoreCase("speed")) && player.hasPermission("playerperks.speed"))
			{
				toggleSpeed(player);
				return true;
			}
			else if (!player.hasPermission("playerperks.speed"))
			{
				player.sendMessage("§4You do not have access to that command.");
			}
		}
		return true;
		
	}
}