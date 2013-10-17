package com.omggamesftw.seeingeye;

import org.bukkit.Location;

public class Watcher {

	public String watcherName;
	public String targetName;
	public int taskID;
	public Location loc;
	
	public Watcher(String watcherName, String targetName, int taskID, Location loc)
	{
		this.watcherName = watcherName;
		this.targetName = targetName;
		this.taskID = taskID;
		this.loc = loc;
	}
}
