package com.Adamiok.sapphire.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class SapphireOre extends OreBlock{

	public SapphireOre(Properties p_55140_) {
		super(p_55140_);
		// TODO Auto-generated constructor stub
	}
	
	public SapphireOre() {
		super(BlockBehaviour.Properties.of(Material.STONE)
				.strength(3f, 9f)
				.destroyTime(10)
				.requiresCorrectToolForDrops());
	}
	
	protected int getExperienceWhenMined(Random random) {
		return (int) Math.floor(Math.random()*(7-3+1)+3);
	}
	
	
	
	
	@Override
	public int getExpDrop(BlockState state, LevelReader reader, BlockPos pos, int fortune, int silktouch) {
		// TODO Auto-generated method stub
		if (silktouch == 0) {
			return getExperienceWhenMined(RANDOM);
		}
		return 0;
	}
	
	
	
}