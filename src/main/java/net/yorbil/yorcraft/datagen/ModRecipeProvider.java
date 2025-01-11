package net.yorbil.yorcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.SmokerBlock;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.yorbil.yorcraft.block.ModBlocks;
import net.yorbil.yorcraft.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                //Carrot Crate
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.CARROT, RecipeCategory.FOOD, ModBlocks.CARROT_CRATE.getRight());

                //Dough
                createShapeless(RecipeCategory.FOOD, ModItems.DOUGH, 24)
                        .input(ModItems.WHEAT_FLOUR, 8)
                        .input(Items.WATER_BUCKET)
                        .criterion(hasItem(ModItems.WHEAT_FLOUR), conditionsFromItem(ModItems.WHEAT_FLOUR))
                        .offerTo(exporter);


                //Raw Bread
                createShaped(RecipeCategory.FOOD, ModItems.RAW_BREAD)
                        .input('D', ModItems.DOUGH)
                        .pattern("DDD")
                        .pattern("DDD")
                        .criterion(hasItem(ModItems.DOUGH), conditionsFromItem(ModItems.DOUGH))
                        .offerTo(exporter);
                //Bread
                List<ItemConvertible> BREAD = List.of(ModItems.RAW_BREAD);
                offerSmelting(BREAD, RecipeCategory.FOOD, Items.BREAD, 0.35f, 200, "BREAD_GROUP");

                //Raw Bun
                createShaped(RecipeCategory.FOOD, ModItems.RAW_BUN)
                        .input('D', ModItems.DOUGH)
                        .pattern("DD")
                        .pattern("DD")
                        .criterion(hasItem(ModItems.DOUGH), conditionsFromItem(ModItems.DOUGH))
                        .offerTo(exporter);
                //Bun
                List<ItemConvertible> BUN = List.of(ModItems.RAW_BUN);
                offerSmelting(BUN, RecipeCategory.FOOD, ModItems.BUN, 0.35f, 200, "BUN_GROUP");
                //Top&Bottom Bun
//                createShapeless(RecipeCategory.FOOD,ModItems.TOP_BUN)
//                        .input(ModItems.BUN)
//                        .criterion(hasItem(ModItems.BUN), conditionsFromItem(ModItems.BUN))
//                        .offerTo(exporter);

                offerSingleOutputShapelessRecipe(ModItems.BOTTOM_BUN, ModItems.BUN, "TOP&BOTTOM_BUN");
                offerSingleOutputShapelessRecipe(ModItems.TOP_BUN, ModItems.BOTTOM_BUN, "TOP&BOTTOM_BUN2");
                offerSingleOutputShapelessRecipe(ModItems.BOTTOM_BUN, ModItems.TOP_BUN, "TOP&BOTTOM_BUN3");

                //Raw Ground Beef

                //Raw Beef Patty

                //Cooked Beef Patty
                List<ItemConvertible> COOKED_BEEF_PATTY = List.of(ModItems.RAW_BEEF_PATTY);
                offerSmelting(COOKED_BEEF_PATTY, RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY, 0.35f, 200, "COOKED_BEEF_PATTY");

                offerMultipleOptions(RecipeSerializer.SMOKING, SmokingRecipe::new, COOKED_BEEF_PATTY, RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY, 0.35f, 100, "COOKED_BEEF_PATTY", "_from_smoking");






            }
        };
    }
    @Override
    public String getName() {
        return "";
    }
}
