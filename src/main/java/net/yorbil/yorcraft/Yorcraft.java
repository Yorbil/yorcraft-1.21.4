package net.yorbil.yorcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.yorbil.yorcraft.Block.ModBlocks;
import net.yorbil.yorcraft.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Yorcraft implements ModInitializer {

	public static final String MOD_ID = "yorcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing mod "+ MOD_ID);

		ModItems.initialize();
		ModBlocks.registerModBlocks();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
				.register((itemGroup) -> itemGroup.add(ModItems.PINK_GARNET));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
				.register((itemGroup) -> itemGroup.add(ModItems.BACON));

	}
}