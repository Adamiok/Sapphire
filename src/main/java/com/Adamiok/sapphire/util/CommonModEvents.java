package com.Adamiok.sapphire.util;

import com.Adamiok.sapphire.Sapphire;
import com.Adamiok.sapphire.world.OreGeneration;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Sapphire.MODID, bus = Bus.MOD)
public class CommonModEvents {
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(OreGeneration::registerOres);
	}
}
