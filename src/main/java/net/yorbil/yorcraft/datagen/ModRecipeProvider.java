package net.yorbil.yorcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.yorbil.yorcraft.block.ModBlocks;
import net.yorbil.yorcraft.item.ModItems;

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
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.CARROT, RecipeCategory.FOOD, ModBlocks.CARROT_CRATE.getRight());
                //offerShapelessRecipe(ModItems.DOUGH, , String.valueOf(RecipeCategory.FOOD), 1);
                createShapeless(RecipeCategory.FOOD, ModItems.DOUGH)
                        .input(ModItems.WHEAT_FLOUR, 2)
                        .input(Items.POTION)
                        .criterion(hasItem(ModItems.WHEAT_FLOUR), conditionsFromItem(ModItems.WHEAT_FLOUR))
                        .offerTo(exporter);

            }
        };
    }
    @Override
    public String getName() {
        return "";
    }
}
