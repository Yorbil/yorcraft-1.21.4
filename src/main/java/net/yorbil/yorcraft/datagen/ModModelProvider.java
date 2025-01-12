package net.yorbil.yorcraft.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.yorbil.yorcraft.block.ModBlocks;
import net.yorbil.yorcraft.block.custom.TomatoCropBlock;
import net.yorbil.yorcraft.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(ModBlocks.CARROT_CRATE.getLeft(), TexturedModel.CUBE_BOTTOM_TOP);

        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BACON, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BACON, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHEAT_FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOP_BUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOTTOM_BUN, Models.GENERATED);

        //Burgers
        itemModelGenerator.register(ModItems.HAMBURGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_HAMBURGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_HAMBURGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BACON_HAMBURGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_BACON_HAMBURGER, Models.GENERATED);




        itemModelGenerator.register(ModItems.RAW_GROUND_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BEEF_PATTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BEEF_PATTY, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
    }
}
