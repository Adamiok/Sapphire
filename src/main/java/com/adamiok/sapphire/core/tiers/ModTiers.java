package com.adamiok.sapphire.core.tiers;

import java.util.ArrayList;
import java.util.List;

import com.adamiok.sapphire.Sapphire;
import com.adamiok.sapphire.core.init.ItemInit;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public enum ModTiers implements Tier {
   SAPPHIRE(4, 1986, 15.0F, 3.9F, 30, Ingredient.of(ItemInit.SAPPHIRE.get()));

   private final int level;
   private final int uses;
   private final float speed;
   private final float damage;
   private final int enchantmentValue;
   private final Ingredient repairIngredient;

   private ModTiers(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Ingredient p_43337_) {
      this.level = p_43332_;
      this.uses = p_43333_;
      this.speed = p_43334_;
      this.damage = p_43335_;
      this.enchantmentValue = p_43336_;
      this.repairIngredient = p_43337_;
   }

   public int getUses() {
      return this.uses;
   }

   public float getSpeed() {
      return this.speed;
   }

   public float getAttackDamageBonus() {
      return this.damage;
   }

   public int getLevel() {
      return this.level;
   }

   public int getEnchantmentValue() {
      return this.enchantmentValue;
   }

   public Ingredient getRepairIngredient() {
      return this.repairIngredient;
   }
   
   @EventBusSubscriber(modid = Sapphire.MODID, bus = Bus.FORGE)
   public static class registerTiers {
	   private static List<Object> before = new ArrayList<>();
	   private static List<Object> after = new ArrayList<>();
	   
	   public static void register() {
		   //Before List
		   before.add(Tiers.WOOD);
		   before.add(Tiers.STONE);
		   before.add(Tiers.GOLD);
		   before.add(Tiers.IRON);
		   before.add(Tiers.DIAMOND);
		   
		   //After List
		   after.add(Tiers.NETHERITE);
		   
		   TierSortingRegistry.registerTier(SAPPHIRE, new ResourceLocation("adamioks_sapphire:blocks/needs_sapphire_tool"), before, after);
	   }
   }
}
