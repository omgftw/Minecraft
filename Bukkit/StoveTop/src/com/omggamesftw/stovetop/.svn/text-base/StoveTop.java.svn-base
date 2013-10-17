package com.omggamesftw.stovetop;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class StoveTop extends JavaPlugin implements Listener {
	
	public StoveTop() {
	}
	
	@Override
    public void onEnable(){}
	
	@Override
    public void onDisable(){}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){}
	
	public boolean onCommand(CommandSender senderCmd, Command cmd, String label, String[] args)
	{
		if ((cmd.getName().equalsIgnoreCase("stovetop") || cmd.getName().equalsIgnoreCase("st") || cmd.getName().equalsIgnoreCase("cook") ) && senderCmd.hasPermission("stovetop.cook") )
		{
			Player sender = (Player)senderCmd;
			
			List<Entity> entityList = sender.getWorld().getEntities();
			Entity[] entities = entityList.toArray(new Entity[entityList.size()]);
			
			for (int i = 0; i < entities.length; i++)
			{
				if (entities[i].getType() == org.bukkit.entity.EntityType.DROPPED_ITEM)
				{
					Item item = (Item)entities[i];
					Integer typeID = item.getItemStack().getTypeId();
					
					if (typeID == 319 || typeID == 363 || typeID == 365 || typeID == 349)
					{
						typeID = typeID + 1;
						
						Location loc = item.getLocation();
						World world = sender.getWorld();
						//loc.setY(loc.getY() - 1);
						Block block = world.getBlockAt(new Location(world, loc.getX(), loc.getY() - 1, loc.getZ()));
						
						if (block.getTypeId() == 20)
						{
							block = world.getBlockAt(new Location(world, loc.getX(), loc.getY() - 2, loc.getZ()));
							
							if (block.getTypeId() == 10 || block.getTypeId() == 11 || block.getTypeId() == 51)
							{
								entities[i].remove();
								ItemStack newChop = item.getItemStack().clone();
								newChop.setTypeId(typeID);
								sender.getWorld().dropItem(loc, newChop);
							}
						}
					}
				}
			}
			
			return true;
		}
		return false;
	}
}