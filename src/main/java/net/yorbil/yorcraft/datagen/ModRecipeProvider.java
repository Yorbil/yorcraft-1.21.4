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

                //Burgers
                //HAMBURGER
                createShapeless(RecipeCategory.FOOD, ModItems.HAMBURGER)
                        .input(ModItems.TOP_BUN)
                        .input(ModItems.COOKED_BEEF_PATTY)
                        .input(ModItems.BOTTOM_BUN)
                        .criterion(hasItem(ModItems.BUN), conditionsFromItem(ModItems.BUN)).offerTo(exporter);
                //DOUBLE_HAMBURGER
                createShapeless(RecipeCategory.FOOD, ModItems.DOUBLE_HAMBURGER)
                        .input(ModItems.HAMBURGER)
                        .input(ModItems.COOKED_BEEF_PATTY)
                        .criterion(hasItem(ModItems.HAMBURGER), conditionsFromItem(ModItems.HAMBURGER)).offerTo(exporter);
                //TRIPLE_HAMBURGER
                createShapeless(RecipeCategory.FOOD, ModItems.TRIPLE_HAMBURGER)
                        .input(ModItems.HAMBURGER)
                        .input(ModItems.COOKED_BEEF_PATTY, 2)
                        .criterion(hasItem(ModItems.HAMBURGER), conditionsFromItem(ModItems.HAMBURGER)).offerTo(exporter);
                //BACON_HAMBURGER
                createShapeless(RecipeCategory.FOOD, ModItems.BACON_HAMBURGER)
                        .input(ModItems.HAMBURGER)
                        .input(ModItems.COOKED_BACON)
                        .criterion(hasItem(ModItems.HAMBURGER), conditionsFromItem(ModItems.HAMBURGER)).offerTo(exporter);
                //DOUBLE_BACON_HAMBURGER
                createShapeless(RecipeCategory.FOOD, ModItems.DOUBLE_BACON_HAMBURGER)
                        .input(ModItems.HAMBURGER)
                        .input(ModItems.COOKED_BACON)
                        .input(ModItems.COOKED_BEEF_PATTY)
                        .criterion(hasItem(ModItems.HAMBURGER), conditionsFromItem(ModItems.HAMBURGER)).offerTo(exporter);



                //RECIPE VANILLA
                //SADDLE
                createShaped(RecipeCategory.COMBAT, Items.SADDLE)
                        .input('C', Items.LEATHER)
                        .input('L', Items.LEAD)
                        .input('I', Items.IRON_INGOT)
                        .pattern("CCC")
                        .pattern("L L")
                        .pattern("I I")
                        .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER)).offerTo(exporter);
                //Horse Armor
//                createShaped(RecipeCategory.COMBAT, Items.LEATHER_HORSE_ARMOR)
//                      .input('W', Items.RED_WOOL)
//                        .pattern(" WL")
//                        .pattern("LLL")
//                        .pattern("L L")
//                        .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER)).offerTo(exporter);
//                createShaped(RecipeCategory.COMBAT, Items.IRON_HORSE_ARMOR)
//                        .input('I', Items.IRON_INGOT)
//                        .input('W', Items.BLACK_WOOL)
//                        .pattern(" WI")
//                        .pattern("III")
//                        .pattern("I I")
//                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.GOLDEN_HORSE_ARMOR)
                        .input('G', Items.GOLD_INGOT)
                        .input('W', Items.RED_WOOL)
                        .pattern(" WG")
                        .pattern("GGG")
                        .pattern("G G")
                        .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.DIAMOND_HORSE_ARMOR)
                        .input('D', Items.DIAMOND)
                        .input('W', Items.YELLOW_WOOL)
                        .pattern(" WD")
                        .pattern("DDD")
                        .pattern("D D")
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).offerTo(exporter);

            }
        };
    }
    @Override
    public String getName() {
        return "";
    }
}
