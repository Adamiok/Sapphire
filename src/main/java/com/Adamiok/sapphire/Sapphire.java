package com.Adamiok.sapphire;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Adamiok.sapphire.core.init.BlockInit;
import com.Adamiok.sapphire.core.init.ItemInit;
import com.Adamiok.sapphire.world.OreGeneration;

@Mod("adamioks_sapphire")
public class Sapphire {
	
	//Logger and ModId
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID ="adamioks_sapphire";
    
    public Sapphire() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	
    	//Register blocks and items
    	ItemInit.ITEMS.register(bus);
    	BlockInit.BLOCKS.register(bus);
    	
    	//Register ore generation
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::addOres);
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
    
}