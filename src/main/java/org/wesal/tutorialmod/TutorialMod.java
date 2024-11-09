package org.wesal.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.wesal.tutorialmod.util.HammerUsageEvent;
import org.joml.sampling.PoissonSampling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wesal.tutorialmod.block.ModBlocks;
import org.wesal.tutorialmod.component.ModDataComponents;
import org.wesal.tutorialmod.item.*;
import org.wesal.tutorialmod.item.ModItemsGroup;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors

	@Override
	public void onInitialize() {
//		GuiditeMaterial.initilization();
//		ModArmorMaterials.initilization();
		ModItems.registerItem();
		ModBlocks.registerBlocks();
		ModItemsGroup.registerItemGrops();
		ModDataComponents.registerDataComponentType();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
	}
}