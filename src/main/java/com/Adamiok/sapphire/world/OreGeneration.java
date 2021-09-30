package com.Adamiok.sapphire.world;

import com.Adamiok.sapphire.core.init.BlockInit;

import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

    public static void addOres(final BiomeLoadingEvent event) {

        addOre(event, EndOreGenerationFunction.END_ORE_REPLACEABLES,
                BlockInit.SAPPHIRE_ORE.get().defaultBlockState(), 6, 0, 45, 7);
    }


    public static void addOre(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize,
                              int minHeight, int maxHeight, int amount) {
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(rule, state, veinSize))
                        .decorated(FeatureDecorator.RANGE.configured(Features.Decorators.RANGE_4_4))
                        .squared().count(amount));
    }
}