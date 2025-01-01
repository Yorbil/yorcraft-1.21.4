package net.yorbil.yorcraft;

import net.fabricmc.api.ModInitializer;
import net.yorbil.yorcraft.item.ModItems;

public class Yorcraft implements ModInitializer {

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}
}