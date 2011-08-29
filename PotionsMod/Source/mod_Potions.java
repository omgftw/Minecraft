package net.minecraft.src;

public class mod_Potions extends BaseMod {
	public String Version() {
		return "1.7.3";
	}
	
	HealthPotion HealthPotionSmall = new HealthPotion(456, 5, false);
	HealthPotion HealthPotionLarge = new HealthPotion(457, 10, false);
	LongArmPotion longArmPotion = new LongArmPotion(458);
	BlinkPotion blinkPotion = new BlinkPotion(459);
	ImmortalityPotion immPotion = new ImmortalityPotion(460);
	
	public mod_Potions(){
		
		//texture overrides
		HealthPotionLarge.iconIndex = ModLoader.addOverride("/gui/items.png", "/HealthPotionLarge.png");
		HealthPotionSmall.iconIndex = ModLoader.addOverride("/gui/items.png", "/HealthPotionSmall.png");
		longArmPotion.iconIndex = ModLoader.addOverride("/gui/items.png", "/LongArmPotion.png");
		blinkPotion.iconIndex = ModLoader.addOverride("/gui/items.png", "/BlinkPotion.png");
		immPotion.iconIndex = ModLoader.addOverride("/gui/items.png", "/ImmortalityPotion.png");
		
		//names
		HealthPotionLarge.setItemName("Large Health Potion");
		HealthPotionSmall.setItemName("Small Health Potion");
		longArmPotion.setItemName("Long Arm Potion");
		blinkPotion.setItemName("Blink Potion");
		immPotion.setItemName("Immortality Potion");
		ModLoader.AddName(HealthPotionLarge, "Large Health Potion");
		ModLoader.AddName(HealthPotionSmall, "Small Health Potion");
		ModLoader.AddName(longArmPotion, "Long Arm Potion");
		ModLoader.AddName(blinkPotion, "Blink Potion");
		ModLoader.AddName(immPotion, "Immortality Potion");
		
		//recipes
		ModLoader.AddRecipe(new ItemStack(HealthPotionSmall, 1), new Object[] {
        "X", "#", Character.valueOf('X'), Item.seeds, Character.valueOf('#'), Block.glass
		});
		ModLoader.AddRecipe(new ItemStack(HealthPotionSmall, 2), new Object[] {
        "X", Character.valueOf('X'), HealthPotionLarge
		});
		ModLoader.AddRecipe(new ItemStack(HealthPotionLarge, 1), new Object[] {
        "X", "X", Character.valueOf('X'), HealthPotionSmall
		});
		ModLoader.AddRecipe(new ItemStack(longArmPotion, 2), new Object[] {
	        "X", "X", "#", Character.valueOf('X'), Block.leaves, Character.valueOf('#'), Block.glass
			});
		ModLoader.AddRecipe(new ItemStack(blinkPotion, 10), new Object[] {
	        "X", "#", Character.valueOf('X'), Block.leaves, Character.valueOf('#'), Block.glass
			});
		ModLoader.AddRecipe(new ItemStack(immPotion, 1), new Object[] {
	        "XXX", "X X", "XXX", Character.valueOf('X'), HealthPotionLarge
			});

	
	
	
	
	//testcode
	}
}
