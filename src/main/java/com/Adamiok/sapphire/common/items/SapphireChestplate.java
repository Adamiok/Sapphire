package com.Adamiok.sapphire.common.items;

import com.Adamiok.sapphire.core.init.ItemInit;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SapphireChestplate extends ArmorItem{

	public SapphireChestplate(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		
		ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
		
		if (head.getItem() != ItemInit.SAPPHIRE_HELMET.get()) {
			player.removeEffect(MobEffects.HEALTH_BOOST);
		}
	}

}
