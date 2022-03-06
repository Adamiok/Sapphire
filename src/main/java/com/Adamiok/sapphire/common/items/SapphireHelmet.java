package com.adamiok.sapphire.common.items;

import com.adamiok.sapphire.core.init.ItemInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SapphireHelmet extends ArmorItem{

	public SapphireHelmet(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		
		ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
		ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
		ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
		ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        
		//No fall damage when helmet, leggings and boots worn.
        if (head.getItem() == ItemInit.SAPPHIRE_HELMET.get() && legs.getItem() == ItemInit.SAPPHIRE_LEGGINGS.get() 
        		&& boots.getItem() == ItemInit.SAPPHIRE_BOOTS.get()) {
        	
        	player.fallDistance = 0.0F;
        }
        
        //Health Boost when player has full Sapphire set
        if (head.getItem() == ItemInit.SAPPHIRE_HELMET.get() && chest.getItem() == ItemInit.SAPPHIRE_CHESTPLATE.get() 
        		&& legs.getItem() == ItemInit.SAPPHIRE_LEGGINGS.get() && boots.getItem() == ItemInit.SAPPHIRE_BOOTS.get()) {
        	
        	if (!player.hasEffect(MobEffects.HEALTH_BOOST))
        	player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 100000, 2, false, false, false));
        	
        	}
        
        //Remove effect if player removes armor
        else {
        	player.removeEffect(MobEffects.HEALTH_BOOST);
    			
        }
        
	}
	
}
