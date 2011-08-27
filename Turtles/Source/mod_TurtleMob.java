package net.minecraft.src;

import java.util.*;
import java.util.Map;

public class mod_TurtleMob extends BaseMod {

	public String Version() {
		
		return "1.7.3";
	}
	
	public mod_TurtleMob(){
	ModLoader.RegisterEntityID(EntityTurtle.class, "Turtle", ModLoader.getUniqueEntityId());
	ModLoader.AddSpawn(EntityTurtle.class, 500, EnumCreatureType.creature);
	}
	
	public void AddRenderer(Map map){
		
		map.put(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
		
	}


	
}
