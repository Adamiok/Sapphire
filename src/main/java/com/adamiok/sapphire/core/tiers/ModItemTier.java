package com.adamiok.sapphire.core.tiers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import java.util.List;

import com.adamiok.sapphire.core.init.ItemInit;

public class ModItemTier
{
    public static final Tag.Named<Block> SAPPHIRE_TAG = BlockTags.createOptional
    		(new ResourceLocation("adamioks_sapphire:blocks/needs_sapphire_tool"));
    
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1000, 15, 0, 18, SAPPHIRE_TAG, () -> Ingredient.of(ItemInit.SAPPHIRE.get())),
            new ResourceLocation("adamioks_sapphire:blocks/needs_sapphire_tool"),
            List.of(Tiers.IRON), List.of());
}