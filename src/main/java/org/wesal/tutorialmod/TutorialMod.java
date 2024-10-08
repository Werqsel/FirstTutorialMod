package org.wesal.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wesal.tutorialmod.block.ModBlocks;
import org.wesal.tutorialmod.item.*;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors

	@Override
	public void onInitialize() {
		ModItems.initilization();
		GuiditeMaterial.initilization();
		ModArmorMaterials.initilization();
		ModItemsVideoTutorial.registerItem();
		ModBlocks.registerBlocks();
		ModItemsGrops.registerItemGrops();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
	}
}