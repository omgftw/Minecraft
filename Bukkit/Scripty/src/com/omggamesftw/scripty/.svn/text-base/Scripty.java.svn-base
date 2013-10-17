package com.omggamesftw.scripty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Scripty extends JavaPlugin implements Listener {
 
	String scriptFolder = "Scripts";
	
	@Override
    public void onEnable(){
		new File(getDataFolder() + "").mkdir();
		new File(getDataFolder() + File.separator + scriptFolder).mkdir();
    }
	
	@Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome, " + event.getPlayer().getDisplayName() + "!");
    }
	
	public void writeData(String fileName, String data)
	{
		if (new File(getDataFolder() + File.separator + scriptFolder).exists())
		{
			try 
			{
				Writer oos = new FileWriter(getDataFolder() + File.separator + scriptFolder + File.separator + fileName + ".script");
				oos.write(data);
				oos.flush();
				oos.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public String loadData(String fileName)
	{
		if (new File(getDataFolder() + File.separator + scriptFolder + File.separator + fileName + ".script").exists())
		{
			try 
			{
				Scanner oos = new Scanner(new FileInputStream(getDataFolder() + File.separator + scriptFolder + File.separator + fileName + ".script"));
				String fileData = "";
				
				if (oos.hasNextLine())
				{
					fileData += oos.nextLine();
					if (oos.hasNextLine())
					{
						while (oos.hasNextLine())
						{
							fileData += "\n" + oos.nextLine();
						}
					}
				}
				
				
				oos.close();
				return fileData;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "";
			}
		}
		else
		{
			return "";
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	
		
		if((cmd.getName().equalsIgnoreCase("scripty") || cmd.getName().equalsIgnoreCase("s")) && args.length >= 1 && sender instanceof Player)
		{
			if(args[0].equalsIgnoreCase("create"))
			{
				if (args.length >= 2)
				{
					String fileName = args[1];
					String commandVal = "";
					
					if (args.length >= 3)
					{
						commandVal = args[2];
						
						for (int i = 3; i < (args.length); i++)
						{
							commandVal += " " + args[i];
						}
						
						if (!commandVal.startsWith("/") && commandVal != "")
						{
							commandVal = "/" + commandVal;
						}
					}
					
					writeData(fileName, commandVal);
					sender.sendMessage("Script created.");
				}
				else
				{
					sender.sendMessage("Usage: /scripty create script-name optional-initial-command");
				}
				return true;
			}
			
			
			else if(args[0].equalsIgnoreCase("add"))
			{
				if (args.length >= 3)
				{
					String fileName = args[1];
					String commandVal = args[2];
					
					for (int i = 3; i < (args.length); i++)
					{
						commandVal += " " + args[i];
					}
					String commandList = loadData(fileName);
					
					if (commandVal != "")
					{
						if (!commandVal.startsWith("/"))
						{
							commandVal = "/" + commandVal;
						}
						if (commandList.contains("/"))
						{
							commandList += "\n" + commandVal;
						}
						else
						{
							commandList += commandVal;
						}
					}
					writeData(fileName, commandList);
					sender.sendMessage("Command successfully added.");
				}
				else
				{
					sender.sendMessage("Usage: /scripty add script-name command");
				}
				return true;
			}
				
			
			else if(args[0].equalsIgnoreCase("run"))
			{
				
				if (args.length >= 2)
				{
					Player curPlayer = (Player) sender;
					String fileName = args[1];
					String commandList = loadData(fileName);
					
					String[] commandsToRun = commandList.split("\n|\r\n|\r");
					
					for (int i = 0; i < commandsToRun.length; i++)
					{
						curPlayer.chat(commandsToRun[i]);
					}
				}
				else
				{
					sender.sendMessage("Usage: /scripty run script-name");
				}
				return true;
			}
			
			
			else if (args[0].equalsIgnoreCase("view"))
			{
				if (args.length >= 2)
				{
					String fileName = args[1];
					String fileData = loadData(fileName);
					String[] fileContents = fileData.split("\n|\r\n|\r");
					
					for (int i = 0; i < fileContents.length; i++)
					{
						sender.sendMessage("" + (i + 1) + ". " + fileContents[i]);
					}
				}
				else
				{
					sender.sendMessage("Usage: /scripty view scripty-name");
				}
				return true;
			}
			
			else if (args[0].equalsIgnoreCase("editline"))
			{
				if (args.length >= 4)
				{
					String fileName = args[1];
					String lineNumIn = args[2];
					
					try
					{
						int lineNumber = Integer.parseInt(lineNumIn) - 1;
						String newCommand = args[3];
						
						for (int i = 4; i < (args.length); i++)
						{
							newCommand += " " + args[i];
						}
						String fileData = loadData(fileName);
						String[] commandList = fileData.split("\n|\r\n|\r");
						
						if (commandList.length >= (lineNumber + 1) && (lineNumber + 1) > 0)
						{
							if (commandList.length >= 1)
							{
								commandList[lineNumber] = newCommand;
								String dataToWrite = commandList[0];
								
								for (int i = 1; i < commandList.length; i++)
								{
									dataToWrite += "\n" + commandList[i];
								}
								writeData(fileName, dataToWrite);
								sender.sendMessage("Line successfully modified.");
							}
							else
							{
								//test code
								sender.sendMessage("no lines found");
							}
						}
						else
						{
							sender.sendMessage("Please enter a valid line number.");
						}
						
					}
					catch (Exception ex)
					{
						sender.sendMessage("Line number must be a valid number. For a usage example type /scripty editline");
					}
				}
				else
				{
					sender.sendMessage("Usage: /scripty editline scripty-name line-number new-command\n" +
					"To view the contents of a file or find the proper line number, use /scripty view");
				}
				return true;
			}
			
			
			else if(args[0].equalsIgnoreCase("help"))
			{
				sender.sendMessage("Scripty help:\n" +
						"Type any command to see a usage example.\n" +
						"/scripty create\n" +
						"/scripty add\n" +
						"/scripty run\n" +
						"/scripty view\n" +
						"/scripty editline\n" +
						"/scripty delete (TBI)");
				return true;
			}
			//end of scripty if.
		}
		else if (!(sender instanceof Player))
		{
			sender.sendMessage("Scripty cannot currently be used from console.");
			return true;
		}
		return false;
	}
	
}