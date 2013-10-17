package net.minecraft.src;

public class mod_Harvester extends BaseMod
{
		public static Item woodHarvester = (new ItemHarvester(451, EnumToolMaterial.WOOD));
		public static Item stoneHarvester = (new ItemHarvester(452, EnumToolMaterial.STONE));
		public static Item ironHarvester = (new ItemHarvester(453, EnumToolMaterial.IRON));
		public static Item diamondHarvester = (new ItemHarvester(454, EnumToolMaterial.EMERALD));
		public static Item redHarvester = (new ItemHarvester(455, EnumToolMaterial.EMERALD));
		
		//EnumToolMaterial.EMERALD
        public String Version()
        {
                return "1.7.3";
        }
        public mod_Harvester()
        {
        		
        		// <The Harvester>
        		
        		woodHarvester.setItemName("Wood Harvester");
        		stoneHarvester.setItemName("Stone Harvester");
        		ironHarvester.setItemName("Iron Harvester");
        		diamondHarvester.setItemName("Diamond Harvester");
        		redHarvester.setItemName("Ultimate Harvester");
        		
        		woodHarvester.setMaxDamage(177);
        		stoneHarvester.setMaxDamage(393);
        		ironHarvester.setMaxDamage(750);
        		diamondHarvester.setMaxDamage(4683);
        		redHarvester.setMaxDamage(6244);
        		
        		ModLoader.AddName(woodHarvester, "Wood Harvester");
        		ModLoader.AddName(stoneHarvester, "Stone Harvester");
        		ModLoader.AddName(ironHarvester, "Iron Harvester");
        		ModLoader.AddName(diamondHarvester, "Diamond Harvester");
        		ModLoader.AddName(redHarvester, "Ultimate Harvester");
        		
        		woodHarvester.iconIndex = ModLoader.addOverride("/gui/items.png", "/WoodHarvester.png");
        		stoneHarvester.iconIndex = ModLoader.addOverride("/gui/items.png", "/StoneHarvester.png");
        		ironHarvester.iconIndex = ModLoader.addOverride("/gui/items.png", "/IronHarvester.png");
        		diamondHarvester.iconIndex = ModLoader.addOverride("/gui/items.png", "/DiamondHarvester.png");
        		redHarvester.iconIndex = ModLoader.addOverride("/gui/items.png", "/RedHarvester.png");
        		
        		ModLoader.AddRecipe(new ItemStack(woodHarvester, 1), new Object[] {
                    "X", "#", "%", Character.valueOf('X'), Item.pickaxeWood, Character.valueOf('#'), Item.axeWood, Character.valueOf('%'), Item.shovelWood
                });
        		ModLoader.AddRecipe(new ItemStack(stoneHarvester, 1), new Object[] {
                    "X", "#", "%", Character.valueOf('X'), Item.pickaxeStone, Character.valueOf('#'), Item.axeStone, Character.valueOf('%'), Item.shovelStone
                });
        		ModLoader.AddRecipe(new ItemStack(ironHarvester, 1), new Object[] {
                    "X", "#", "%", Character.valueOf('X'), Item.pickaxeSteel, Character.valueOf('#'), Item.axeSteel, Character.valueOf('%'), Item.shovelSteel
                });
        		ModLoader.AddRecipe(new ItemStack(diamondHarvester, 1), new Object[] {
                    "X", "#", "%", Character.valueOf('X'), Item.pickaxeDiamond, Character.valueOf('#'), Item.axeDiamond, Character.valueOf('%'), Item.shovelDiamond
                });
        		ModLoader.AddRecipe(new ItemStack(redHarvester, 1), new Object[] {
                    "RXR", "R#R", "R%R", Character.valueOf('X'), Item.pickaxeDiamond, Character.valueOf('#'), Item.axeDiamond, Character.valueOf('%'), Item.shovelDiamond, Character.valueOf('R'), Item.redstone
                });
        		
        		// </The Harvester>
        		
        }
}