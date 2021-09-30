package com.Adamiok.sapphire.core.init;

import com.Adamiok.sapphire.Sapphire;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	//Preparations
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Sapphire.MOD_ID);
  
  //Blocks
  public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", ()-> new Block
		  (BlockBehaviour.Properties.of(Material.STONE).strength(3f, 9f).destroyTime(10).requiresCorrectToolForDrops()));
  
  public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("block_of_sapphire", ()-> new Block
		  (BlockBehaviour.Properties.of(Material.STONE).strength(4F, 10F).destroyTime(15).requiresCorrectToolForDrops()));

  
}