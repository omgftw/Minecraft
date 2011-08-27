package net.minecraft.src;

public class mod_Harvester extends BaseMod
{
		public static Item Harvester = (new ItemHarvester(458, EnumToolMaterial.EMERALD));
        public String Version()
        {
                return "1.7.3";
        }
        public mod_Harvester()
        {
        		
        		// <The Harvester>
        		
        		Harvester.setItemName("The Harvester");
        		Harvester.setMaxDamage(5000);
        		ModLoader.AddName(Harvester, "The Harvester");
        		Harvester.iconIndex = ModLoader.addOverride("/gui/items.png", "/Harvester.png");
        		ModLoader.AddRecipe(new ItemStack(Harvester, 1), new Object[] {
                    "X", "#", "%", Character.valueOf('X'), Item.pickaxeDiamond, Character.valueOf('#'), Item.axeDiamond, Character.valueOf('%'), Item.shovelDiamond
                });
        		
        		// </The Harvester>
        		
        }
}