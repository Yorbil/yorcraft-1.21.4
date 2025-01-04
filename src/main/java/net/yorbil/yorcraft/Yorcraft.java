package net.yorbil.yorcraft;

import net.fabricmc.api.ModInitializer;
import net.yorbil.yorcraft.block.ModBlocks;
import net.yorbil.yorcraft.item.ModItemGroups;
import net.yorbil.yorcraft.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Yorcraft implements ModInitializer {

	public static final String MOD_ID = "yorcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing mod "+ MOD_ID);

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}