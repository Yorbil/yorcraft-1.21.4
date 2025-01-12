package net.yorbil.yorcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.yorbil.yorcraft.Yorcraft;
import net.minecraft.item.Items;
import net.yorbil.yorcraft.block.ModBlocks;

public class ModItems {

    // Enregistrement

    // Enregistrement des items simples.
    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new);
    public static final Item WHEAT_FLOUR = registerItem("wheat_flour", Item::new);
    public static final Item DOUGH = registerItem("dough", Item::new);
    public static final Item RAW_BREAD = registerItem("raw_bread", Item::new);
    public static final Item RAW_BUN = registerItem("raw_bun", Item::new);
    public static final Item TOP_BUN = registerItem("top_bun", (settings) -> new Item(settings.food(ModFoodComponents.Top_Bun)));
    public static final Item BOTTOM_BUN = registerItem("bottom_bun", (settings) -> new Item(settings.food(ModFoodComponents.Bottom_Bun)));
    public static final Item BUN = registerItem("bun", (settings) -> new Item(settings.food(ModFoodComponents.Bun).recipeRemainder(ModItems.TOP_BUN)));

    //Burgers
    public static final Item HAMBURGER = registerItem("hamburger", (settings) -> new Item(settings.food(ModFoodComponents.Hamburger)));
    public static final Item DOUBLE_HAMBURGER = registerItem("double_hamburger", (settings) -> new Item(settings.food(ModFoodComponents.Double_Hamburger)));
    public static final Item TRIPLE_HAMBURGER = registerItem("triple_hamburger", (settings) -> new Item(settings.food(ModFoodComponents.Triple_Hamburger)));
    public static final Item BACON_HAMBURGER = registerItem("bacon_hamburger", (settings) -> new Item(settings.food(ModFoodComponents.Bacon_Hamburger)));
    public static final Item DOUBLE_BACON_HAMBURGER = registerItem("double_bacon_hamburger", (settings) -> new Item(settings.food(ModFoodComponents.Double_Bacon_Hamburger)));




    // Enregistrement des items complexes.
    public static final Item RAW_BACON = registerItem("raw_bacon", (settings) -> new Item(settings.food(ModFoodComponents.Raw_Bacon)));
    public static final Item COOKED_BACON = registerItem("cooked_bacon", (settings) -> new Item(settings.food(ModFoodComponents.Cooked_Bacon)));

    public static final Item RAW_GROUND_BEEF = registerItem("raw_ground_beef", (settings) -> new Item(settings.food(ModFoodComponents.Raw_Ground_Beef)));
    public static final Item RAW_BEEF_PATTY = registerItem("raw_beef_patty", (settings) -> new Item(settings.food(ModFoodComponents.Raw_Beef_Patty)));
    public static final Item COOKED_BEEF_PATTY = registerItem("cooked_beef_patty", (settings) -> new Item(settings.food(ModFoodComponents.Cooked_Beef_Patty)));

    public static final Item TOMATO = registerItem("tomato", (settings) -> new Item(settings.food(ModFoodComponents.Tomato)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", settings -> new BlockItem(ModBlocks.TOMATO_CROP, settings.useItemPrefixedTranslationKey()));


    //.recipeRemainder(Items.DIAMOND)

    // Méthode

    // Méthode d'enregistrement des items simples.
    public static Item registerItem(String name) {
        return registerItem(name, Item::new);
    }
    // Méthode d'enregistrement des items complexes.
    public static <T extends Item> T registerItem(String name, ItemFactory<T> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("yorcraft",name));
        return net.minecraft.registry.Registry.register(
                Registries.ITEM,
                key,
                factory.create(new Item.Settings().registryKey(key))
        );
    }
    // Interface fonctionnelle pour la méthode d'enregistrement des items complexes.
    @FunctionalInterface
    public interface ItemFactory<T extends Item> {
        T create(Item.Settings settings);
    }

    // Méthode pour afficher dans les logs que les items du mod sont enregistrés.
    public static void registerModItems() {
        Yorcraft.LOGGER.info("Refistering Mod Items for " + Yorcraft.MOD_ID);
    }
}