package com.adamiok.sapphire;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.adamiok.sapphire.core.init.BlockInit;
import com.adamiok.sapphire.core.init.ItemInit;
import com.adamiok.sapphire.util.ConfigHandler;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Sapphire.MODID)
public class Sapphire {
	
	//Logger and ModId
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID ="adamioks_sapphire";
    
    public Sapphire() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	
    	//Register and load config
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigHandler.COMMON_CONFIG);
        ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("adamioks_sapphire-server.toml"));
    	
    	//Register blocks and items
    	ItemInit.ITEMS.register(bus);
    	BlockInit.BLOCKS.register(bus);
    	
    	LOGGER.debug("The mod" + Sapphire.MODID + "has been loaded succesfully unless errors were present.");
        LOGGER.info("Sapphire is ready to be mined!");
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
    
}