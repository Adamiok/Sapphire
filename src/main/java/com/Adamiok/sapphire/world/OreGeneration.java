package com.Adamiok.sapphire.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.Adamiok.sapphire.Sapphire;
import com.Adamiok.sapphire.core.config.OreGenConfig;
import com.Adamiok.sapphire.core.init.BlockInit;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class OreGeneration {
	
	public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();
	public static final List<PlacedFeature> NETHER_ORES = new ArrayList<>();
    public static final List<PlacedFeature> END_ORES = new ArrayList<>();

    public static final RuleTest END_TEST = new BlockMatchTest(Blocks.END_STONE);

    public static void registerOres() {
    	
    	//Small sapphire
        final ConfiguredFeature<?, ?> smallSapphireOre = FeatureUtils.register("small_sapphire_ore",
                Feature.ORE.configured(new OreConfiguration(
                        List.of(OreConfiguration.target(END_TEST, BlockInit.SAPPHIRE_ORE.get().defaultBlockState())),
                        OreGenConfig.sapphireSmallVeinSize.get())));

        final PlacedFeature placedSmallSapphireOre = PlacementUtils.register("small_sapphire_ore",
                smallSapphireOre.placed(OrePlacements.commonOrePlacement(OreGenConfig.sapphireSmallPerChunk.get(), 
                		HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(OreGenConfig.sapphireMinHeight.get()),
                				VerticalAnchor.aboveBottom(OreGenConfig.sapphireMaxHeight.get())))));
        
        if (OreGenConfig.generateSapphire.get()) {
            END_ORES.add(placedSmallSapphireOre);
        } 
        
        //Large sapphire
        final ConfiguredFeature<?, ?> largeSapphireOre = FeatureUtils.register("large_sapphire_ore", 
        		Feature.ORE.configured(new OreConfiguration(
        				List.of(OreConfiguration.target(END_TEST, BlockInit.SAPPHIRE_ORE.get().defaultBlockState())),
        				OreGenConfig.sapphireLargeVeinSize.get())));
        
        final PlacedFeature placedLargeSapphireOre = PlacementUtils.register("large_sapphire_ore", 
        		largeSapphireOre.placed(OrePlacements.commonOrePlacement(OreGenConfig.sapphireLargePerChunk.get(), 
        				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(OreGenConfig.sapphireMinHeight.get()), 
        						VerticalAnchor.aboveBottom(OreGenConfig.sapphireMaxHeight.get())))));
        
        if (OreGenConfig.generateSapphire.get()) {
        	END_ORES.add(placedLargeSapphireOre);
        }
    }

    @Mod.EventBusSubscriber(modid = Sapphire.MODID, bus = Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            final List<Supplier<PlacedFeature>> features = event.getGeneration()
                    .getFeatures(Decoration.UNDERGROUND_ORES);
            
            if (OreGenConfig.generateOresOnlyInVanillaEnd.get()) {
            	//Ore only in vannila end
            	if("minecraft".equals(event.getName().getNamespace()) && event.getCategory() == BiomeCategory.THEEND) {
            		OreGeneration.END_ORES.forEach(ore -> features.add(() -> ore));
            	}
            }
            else {
            	//Ores in every biome which has the THEEND category.
            	switch (event.getCategory()) {
                case NETHER -> OreGeneration.NETHER_ORES.forEach(ore -> features.add(() -> ore));
                case THEEND -> OreGeneration.END_ORES.forEach(ore -> features.add(() -> ore));
                default -> OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            	}
			}
        }
    }
}