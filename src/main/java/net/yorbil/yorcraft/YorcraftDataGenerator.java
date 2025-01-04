package net.yorbil.yorcraft;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.yorbil.yorcraft.datagen.ModBlockTagProvider;
import net.yorbil.yorcraft.datagen.ModItemTagProvider;
import net.yorbil.yorcraft.datagen.ModLootTableProvider;

public class YorcraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		//pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
	}
}
