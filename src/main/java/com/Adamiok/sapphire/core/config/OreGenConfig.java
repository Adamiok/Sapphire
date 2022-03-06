package com.Adamiok.sapphire.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
	
	//Common ore gen config
	public static ForgeConfigSpec.BooleanValue generateOresOnlyInVanillaEnd;
	
	//Sapphire Config
	public static ForgeConfigSpec.BooleanValue generateSapphire;
	public static ForgeConfigSpec.IntValue sapphireSmallVeinSize;
	public static ForgeConfigSpec.IntValue sapphireLargeVeinSize;
	public static ForgeConfigSpec.IntValue sapphireMinHeight;
	public static ForgeConfigSpec.IntValue sapphireMaxHeight;
	public static ForgeConfigSpec.IntValue sapphireSmallPerChunk;
	public static ForgeConfigSpec.IntValue sapphireLargePerChunk;
	
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
		
		sapphireSmallVeinSize = builder
				.comment("Size of small veins of sapphire. Default = 2")
				.defineInRange("Sapphire small vein size", 2, 1, 50);
		
		sapphireLargeVeinSize = builder
				.comment("Size of large veins of sapphire. Default = 5")
				.defineInRange("Sapphire large vein size", 5, 1, 100);
		
		sapphireMinHeight = builder
				.comment("Sapphire minimum height (the \"y\" cord). Default = 0")
				.defineInRange("Sapphire min height", 0, 0, 254);
		
		sapphireMaxHeight = builder
				.comment("Sapphire maximum height (the \"y\" cord). Default = 55")
				.defineInRange("Sapphire max height", 55, 0, 255);
		
		sapphireSmallPerChunk = builder
				.comment("Small sapphire ores to be placed in 1 chunk. Default = 15")
				.defineInRange("Sapphire ores in a chunk", 24, 0, 500);
		
		sapphireLargePerChunk = builder
				.comment("Large sapphire ores to be placed in 1 chunk. Default = 9")
				.defineInRange("Large sapphire ores in a chunk", 9, 0, 300);
		
		
	}
}
