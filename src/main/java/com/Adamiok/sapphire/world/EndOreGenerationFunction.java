package com.Adamiok.sapphire.world;

import java.util.List;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags.Blocks;

public class EndOreGenerationFunction extends OreConfiguration{

	public EndOreGenerationFunction(List<TargetBlockState> p_161016_, int p_161017_, float p_161018_) {
		super(p_161016_, p_161017_, p_161018_);
		// TODO Auto-generated constructor stub
	}
	
	public static final RuleTest END_ORE_REPLACEABLES = new TagMatchTest(Blocks.END_STONES);

}
