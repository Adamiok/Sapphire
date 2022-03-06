package com.adamiok.sapphire.world;

import java.util.List;
import com.adamiok.sapphire.Sapphire;
import com.adamiok.sapphire.core.config.OreGenConfig;
import com.adamiok.sapphire.core.init.BlockInit;

import net.minecraft.core.Holder;
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

    public static final RuleTest END_TEST = new BlockMatchTest(Blocks.END_STONE);
    
    private static Holder<PlacedFeature> placedSmallSapphireOre;
    private static Holder<PlacedFeature> placedLargeSapphireOre;
    
    public static void registerOres() {
    	
    	//Small sapphire
    	final Holder<ConfiguredFeature<OreConfiguration, ?>> smallSapphireOre = FeatureUtils.register("small_sapphire_ore",
    			Feature.SCATTERED_ORE, new OreConfiguration(
    					END_TEST, BlockInit.SAPPHIRE_ORE.get().defaultBlockState(), OreGenConfig.sapphireSmallVeinSize.get(), 1.0F));
    	
        placedSmallSapphireOre = PlacementUtils.register("small_sapphire_ore", 
        		smallSapphireOre, OrePlacements.commonOrePlacement(OreGenConfig.sapphireSmallPerChunk.get(),
        				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(OreGenConfig.sapphireMinHeight.get()), VerticalAnchor.aboveBottom(OreGenConfig.sapphireMaxHeight.get()))));
        
        //Large sapphire
        final Holder<ConfiguredFeature<OreConfiguration, ?>> largeSapphireOre = FeatureUtils.register("large_sapphire_ore", 
        		Feature.SCATTERED_ORE, new OreConfiguration(
        				END_TEST, BlockInit.SAPPHIRE_ORE.get().defaultBlockState(), OreGenConfig.sapphireLargeVeinSize.get(), 1.0F));
        
        placedLargeSapphireOre = PlacementUtils.register("large_sapphire_ore", 
        		largeSapphireOre, OrePlacements.commonOrePlacement(OreGenConfig.sapphireLargePerChunk.get(),
        				HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(OreGenConfig.sapphireMinHeight.get()), VerticalAnchor.aboveBottom(OreGenConfig.sapphireMaxHeight.get()))));
    }

    @Mod.EventBusSubscriber(modid = Sapphire.MODID, bus = Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            final List<Holder<PlacedFeature>> features = event.getGeneration()
                    .getFeatures(Decoration.UNDERGROUND_ORES);
            
            if (OreGenConfig.generateSapphire.get() && OreGenConfig.generateOresOnlyInVanillaEnd.get()) {
            	if("minecraft".equals(event.getName().getNamespace()) && event.getCategory() == BiomeCategory.THEEND) {
            		features.add(placedLargeSapphireOre);
            		features.add(placedSmallSapphireOre);
            	}
            } else if (OreGenConfig.generateSapphire.get()) {
            	features.add(placedLargeSapphireOre);
            	features.add(placedSmallSapphireOre);
            }
        }
    }
}