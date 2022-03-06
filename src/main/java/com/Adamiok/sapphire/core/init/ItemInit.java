package com.adamiok.sapphire.core.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.adamiok.sapphire.Sapphire;
import com.adamiok.sapphire.common.items.SapphireChestplate;
import com.adamiok.sapphire.common.items.SapphireHelmet;
import com.adamiok.sapphire.core.tiers.ModArmorMaterial;
import com.adamiok.sapphire.core.tiers.ModItemTier;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;


public class ItemInit {
	
	//Preparation
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Sapphire.MODID);
	
	  //Items
	  public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> 
	  new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
	
	//Block Items
	public static final RegistryObject<BlockItem> SAPPHIRE_ORE = ITEMS.register("sapphire_ore", 
			() -> new BlockItem(BlockInit.SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).stacksTo(64)));
 
	public static final RegistryObject<BlockItem> SAPPHIRE_BLOCK = ITEMS.register("block_of_sapphire", () ->
	new BlockItem(BlockInit.SAPPHIRE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).stacksTo(64)));
	
	//Tools
	  //Swords
	          // Damage: 1 + baseDamage (0) + addedDamage
	public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> 
	new SwordItem(ModItemTier.SAPPHIRE, 10 , -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	  //Axes
	public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> 
	new AxeItem(ModItemTier.SAPPHIRE, 12, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	
	 //Shovels
	public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () ->
	new ShovelItem(ModItemTier.SAPPHIRE, 8.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	
	 //Pickaxe
	public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () ->
	new PickaxeItem(ModItemTier.SAPPHIRE, 6, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	
	 //Hoe
	public static final RegistryObject<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () ->
	new HoeItem(ModItemTier.SAPPHIRE, 4, -0.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	
	
	//Armor
	  //Helmet
	public static final RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () ->
	new SapphireHelmet(ModArmorMaterial.SAPPHIRE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	 //Chestplate
	public static final RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () ->
	new SapphireChestplate(ModArmorMaterial.SAPPHIRE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	 //Leggings
	public static final RegistryObject<ArmorItem> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () ->
	new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	 //Boots
	public static final RegistryObject<ArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () ->
	new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
}
