package net.minecraft.src;

public class mod_HealthPotion extends BaseMod
{
	public static Item HealthPotionSmall = (new ItemFood(456, 5, false));
	public static Item HealthPotionLarge = (new ItemFood(457, 10, false));
        public String Version()
        {
                return "1.7.3";
        }
        public mod_HealthPotion()
        {
        		
                // <Health Potion Small>
        		HealthPotionSmall.setMaxStackSize(20);
        		HealthPotionSmall.setItemName("Small Health Potion");
        		HealthPotionSmall.iconIndex = ModLoader.addOverride("/gui/items.png", "/HealthPotionSmall.png");
        		ModLoader.AddRecipe(new ItemStack(HealthPotionSmall, 1), new Object[] {
                    "X", "#", Character.valueOf('X'), Block.leaves, Character.valueOf('#'), Block.glass
                });
        		ModLoader.AddRecipe(new ItemStack(HealthPotionSmall, 2), new Object[] {
                    "X", Character.valueOf('X'), HealthPotionLarge
                });
        		ModLoader.AddName(HealthPotionSmall, "Small Health Potion");
        		// </Health Potion Small>
        		
        		
        		// <Health Potion Large>
        		HealthPotionLarge.setMaxStackSize(20);
        		HealthPotionLarge.setItemName("Large Health Potion");
        		HealthPotionLarge.iconIndex = ModLoader.addOverride("/gui/items.png", "/HealthPotionLarge.png");
        		ModLoader.AddRecipe(new ItemStack(HealthPotionLarge, 1), new Object[] {
                    "X", "X", Character.valueOf('X'), HealthPotionSmall
                });
        		ModLoader.AddName(HealthPotionLarge, "Large Health Potion");
        		// <Health Potion Large
        		
        }
}