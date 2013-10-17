package net.minecraft.src;

public class mod_XRayBlock extends BaseMod {

	//public static final StepSound soundGravelFootstep = new StepSound("gravel", 1.0F, 1.0F);
	
	public String Version() {
		return "1.7.3";
	}
	
	public static final Block BlockXRay = new BlockXRay(172, 0).setLightValue(1F).setHardness(0.5F);

	public mod_XRayBlock(){
		
		ModLoader.RegisterBlock(BlockXRay);
		BlockXRay.setBlockName("XRayBlock");
		BlockXRay.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/XRayBlock.png");
		ModLoader.AddName(BlockXRay, "X-Ray Block");
		ModLoader.AddRecipe(new ItemStack(BlockXRay, 1), new Object[] {
           "#", "#", Character.valueOf('#'), Block.glass
        });
		
	}
	
	
}
