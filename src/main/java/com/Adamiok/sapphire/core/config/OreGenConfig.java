package com.Adamiok.sapphire.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
	
	//Common ore gen config
	public static ForgeConfigSpec.BooleanValue generateOresOnlyInVanillaEnd;
	
	//Sapphire Config
	public static ForgeConfigSpec.BooleanValue generateSapphire;
	public static ForgeConfigSpec.IntValue sapphireVeinSize;
	public static ForgeConfigSpec.IntValue sapphireMinHeight;
	public static ForgeConfigSpec.IntValue sapphireMaxHeight;
	public static ForgeConfigSpec.IntValue sapphirePerChunk;
	
	public static void Init(ForgeConfigSpec.Builder builder) {
		
		//Common ore gen config
		builder.push("All ore generation config");
		generateOresOnlyInVanillaEnd = builder
				.comment("Should ores generate in vanilla end only or in dimensions with the THEEND category. Default = true")
				.define("Ore in vanilla end only", true);
		
		//Sapphire config
		builder.push("Sapphire Config");
		generateSapphire = builder
				.comment("Generate sapphire at all. Default = true")
				.define("Generate sapphire", true);
		
		sapphireVeinSize = builder
				.comment("Sapphire vein size. Default = 5")
				.defineInRange("Sapphire vein size", 5, 1, 50);
		
		sapphireMinHeight = builder
				.comment("Sapphire minimum height (the \"y\" cord). Default = 1")
				.defineInRange("Sapphire min height", 1, 0, 254);
		
		sapphireMaxHeight = builder
				.comment("Sapphire maximum height (the \"y\" cord). Default = 55")
				.defineInRange("Sapphire max height", 55, 0, 254);
		
		sapphirePerChunk = builder
				.comment("Sapphire ores to be placed in 1 chunk. Default = 24")
				.defineInRange("Sapphire ores in a chunk", 24, 1, 200);
	}
}
