package com.omggamesftw.seeingeye;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class SeeingEye extends JavaPlugin implements Listener 
{
	
	//Map<String, String> allTools = new HashMap<String, String>();
	Map<String, Boolean> playerVisible = new HashMap<String, Boolean>();
	//Map<String, Integer> watchers = new HashMap<String, Integer>();
	List<Watcher> watchers = new ArrayList<Watcher>();
	List<InventoryManager> invs = new ArrayList<InventoryManager>();
	
	int loopSpeed = 1;
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		new File(getDataFolder() + "").mkdir();
		Player[] players = getServer().getOnlinePlayers();
		
		for (int i = 0; i < players.length; i++)
		{
				playerVisible.put(players[i].getName(), true); 
		}
    }
	
	@Override
    public void onDisable() 
	{
    }
	
	@EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) 
	{
		Player player = event.getPlayer();
		playerVisible.put(player.getName(), true);
		updateVision(player);
    }
	
	@EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) 
	{
		Player player = event.getPlayer();
		String playerName = player.getName();
		playerVisible.remove(playerName);
		
		int index = watcherFindByName(playerName);
		if (index != -1)
		{
			getServer().getScheduler().cancelTask(watchers.get(index).taskID);
			watchers.remove(index);
		}
		index = watcherFindByTarget(playerName);
		if (index != -1)
		{
			stopWatch(getServer().getPlayerExact(watchers.get(index).watcherName));
		}
    }
	
	@EventHandler(ignoreCancelled = true)
	public void onPlayerPickUp(PlayerPickupItemEvent event)
	{
		if (playerVisible.get(event.getPlayer().getName()) == false)
		{
			event.setCancelled(true);
		}
	}
	
	 @EventHandler(ignoreCancelled = true)
	 public void onEntityDamage(EntityDamageEvent event) 
	 {
		 Entity ent = event.getEntity();
		 if (ent instanceof Player)
		 {
			 Player player = (Player) ent;
			 if (playerVisible.get(player.getName()) == false)
			 {
				 event.setCancelled(true);
			 }
		 }
	 }
	 
	 @EventHandler(ignoreCancelled = true)
	    public void onEntityTarget(EntityTargetEvent event) 
	 {
		 Entity ent = event.getTarget();
		 if (ent instanceof Player)
		 {
			 Player player = (Player) ent;
			 if (playerVisible.get(player.getName()) == false)
			 {
				 event.setCancelled(true);
			 }
		 }
	 }
	
	
	public int watcherFindByName(String watcherName)
	{
		for (int i = 0; i < watchers.size(); i++)
		{
			if (watchers.get(i).watcherName == watcherName)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	public int watcherFindByTarget(String targetName)
	{
		for (int i = 0; i < watchers.size(); i++)
		{
			if (watchers.get(i).targetName == targetName)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	public int watcherGetTaskID(String watcherName)
	{
		return watchers.get(watcherFindByName(watcherName)).taskID;
	}
	
	
	public void updateVision(Player player)
	{
		for (Map.Entry<String, Boolean> i : playerVisible.entrySet())
		{
			if (i.getValue() == false)
			{
				player.hidePlayer(player.getServer().getPlayerExact(i.getKey()));
			}
			else
			{
				player.showPlayer(player.getServer().getPlayerExact(i.getKey()));
			}
		}
	}
	
	
	public void makeInvisible (Player player)
	{
		playerVisible.put(player.getName(), false);
		Player[] players = getServer().getOnlinePlayers();
		
		for (int i = 0; i < players.length; i++)
		{
				players[i].hidePlayer(player); 
		}
	}
	
	
	public void makeVisible (Player player)
	{
		playerVisible.put(player.getName(), true);
		Player[] players = getServer().getOnlinePlayers();
		
		for (int i = 0; i < players.length; i++)
		{
				players[i].showPlayer(player); 
		}
	}
	
	
	public void watch(final Player player, final Player target)
	{
		if (watcherFindByName(player.getName()) != -1)
		{
			stopWatch(player);
		}
		
		makeInvisible(player);
		player.hidePlayer(target);
		
		int taskID = getServer().getScheduler().scheduleSyncRepeatingTask(this,new Runnable() {
				public void run()
				{
					player.teleport(target.getLocation());
				}
		}, 0, loopSpeed);
		
		watchers.add(new Watcher(player.getName(), target.getName(), taskID, player.getLocation()));
	}
	
	
	public void stopWatch(Player player)
	{
		String playerName = player.getName();
		int index = watcherFindByName(playerName);
		
		if (index != -1)
		{
			Watcher watcher = watchers.get(index);
			Integer taskID = watcher.taskID;
			Location loc = watcher.loc;
			watchers.remove(watcher);
			getServer().getScheduler().cancelTask(taskID);
			player.teleport(loc);
		}
		
		makeVisible(player);
		updateVision(player);
		
	}
	
	public void forceChat(Player player, String[] args)
	{
		if (args.length <= 1)
		{
			player.sendMessage("ForceChat:\n" +
					"Usage: /forcechat player message\n" +
					"Description: Force a player to send messages or commands.");
		}
		else if (args.length >= 2)
		{
			String targetName = args[0];
			
			String message = args[1];
			for (int i = 2; i < args.length; i++)
			{
				message += " " + args[i];
			}
			
			if (targetName.equalsIgnoreCase("all") || targetName.equalsIgnoreCase("*"))
			{
				Player[] players = player.getServer().getOnlinePlayers();
				for (int i  = 0; i < players.length; i++)
				{
					players[i].chat(message);
				}
			}
			else
			{
				Player target = player.getServer().getPlayer(targetName);
				if (target != null)
				{
					target.chat(message);
				}
				else
				{
					player.sendMessage("Error: Player not found.");
				}
			}
		}
		else
		{
			player.sendMessage("Usage: /forcechat player message");
		}
	}
	
	
	public void openInv(Player player, Player target)
	{
		player.openInventory(target.getInventory());
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		final Player player;
		if (sender instanceof Player)
		{
			player = (Player)sender;
		}
		else
		{
			return false;
		}
		
		if (cmd.getName().equalsIgnoreCase("forcechat") && args.length >= 1 && player.hasPermission("seeingeye.forcechat"))
		{
			forceChat(player, args);
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("watch") && args.length >= 1 && player.hasPermission("seeingeye.watch"))
		{
			String playerName = args[0];
			final Player target = sender.getServer().getPlayer(playerName);
			
			if (target != null)
			{
				watch(player, target);
				player.sendMessage("You are now watching " + target.getDisplayName() + ". Type /stopwatch to stop spectating.");
			}	
			else
			{
				player.sendMessage("Player not found.");
			}
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("stopwatch") && player.hasPermission("seeingeye.watch"))
		{
			stopWatch(player);
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("vanish") && player.hasPermission("seeingeye.vanish"))
		{
			if (playerVisible.get(player.getName()) == true)
			{
				makeInvisible(player);
				player.sendMessage("You are now invisible. Type /vanish again to reappear.");
			}
			else
			{
				makeVisible(player);
				player.sendMessage("You are now visible.");
			}
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("vanishstatus") && player.hasPermission("seeingeye.vanishstatus"))
		{
			for (Map.Entry<String, Boolean> i : playerVisible.entrySet())
			{
				if (i.getValue() == true)
				{
					player.sendMessage(i.getKey().toString() + ": Visible");
				}
				else
				{
					player.sendMessage(i.getKey().toString() + ": Invisible");
				}
			}
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("watchstatus") && player.hasPermission("seeingeye.watchstatus"))
		{
			for (Map.Entry<String, Boolean> i : playerVisible.entrySet())
			{
					player.sendMessage(i.getKey().toString() + " is watching someone.");
			}
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("openinv") && args.length >= 1 && player.hasPermission("seeingeye.openinv"))
		{
			Player target = getServer().getPlayer(args[0]);
			
			if (target != null)
			{
				openInv(player, target);
			}
			else
			{
				player.sendMessage("Player not found.");
			}
			return true;
		}
		
		else if (cmd.getName().equalsIgnoreCase("se") && args.length >= 1)
		{
			if (args[0].equalsIgnoreCase("reload") && player.hasPermission("seeingeye.reload"))
			{
				getPluginLoader().disablePlugin(this);
				getPluginLoader().enablePlugin(this);
			}
			else if (args[0].equalsIgnoreCase("help") && player.hasPermission("seeingeye.help"))
			{
				
				if (args.length >= 2)
				{
					if (args[1].equalsIgnoreCase("watch"))
					{
						player.sendMessage("Usage: /watch playername");
						player.sendMessage("Description: Allows you to spectate on a player.");
					}
					else if (args[1].equalsIgnoreCase("vanish"))
					{
						player.sendMessage("Usage: /vanish");
						player.sendMessage("Description: Makes you invisible to all players.");
					}
					else if (args[1].equalsIgnoreCase("openinv"))
					{
						player.sendMessage("Usage: /openinv playername");
						player.sendMessage("Description: Allows you to open and edit another player's inventory.");
					}
					else if (args[1].equalsIgnoreCase("forcechat"))
					{
						player.sendMessage("Usage: /forcechat playername message");
						player.sendMessage("Description: Forces a player to say the given text or execute the given command.");
					}
					else if (args[1].equalsIgnoreCase("vanishstatus"))
					{
						player.sendMessage("Usage: /vanishstatus");
						player.sendMessage("Description: Shows the visibility status of all players.");
					}
					else if (args[1].equalsIgnoreCase("watchstatus"))
					{
						player.sendMessage("Usage: /watchstatus");
						player.sendMessage("Description: Shows a list of players that are currently spectating someone else.");
					}
				}
				else
				{
					player.sendMessage("Seeing Eye Commands:");
					player.sendMessage("/watch");
					//player.sendMessage("Usage: /watch playername");
					//player.sendMessage("Description: Allows you to spectate on a player.");
					player.sendMessage("/vanish");
					//player.sendMessage("Usage: /vanish");
					//player.sendMessage("Description: Makes you invisible to all players.");
					player.sendMessage("/openinv");
					//player.sendMessage("Usage: /openinv playername");
					//player.sendMessage("Description: Allows you to open and edit another player's inventory.");
					player.sendMessage("/forcechat");
					//player.sendMessage("Usage: /forcechat playername message");
					//player.sendMessage("Description: Forces a player to say the given text or execute the given command.");
					player.sendMessage("/vanishstatus");
					//player.sendMessage("Usage: /vanishstatus");
					//player.sendMessage("Description: Shows the visibility status of all players.");
					player.sendMessage("/watchstatus");
					//player.sendMessage("Usage: /watchstatus");
					//player.sendMessage("Description: Shows a list of players that are currently spectating someone else.");
					player.sendMessage("For more information on a specific command type: /se help commandname");
					player.sendMessage("Example: /se help watch");
				}
			}
			return true;
		}
		
		return true;
	}
}