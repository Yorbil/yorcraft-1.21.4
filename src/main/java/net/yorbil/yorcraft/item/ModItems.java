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

    // Enregistrement des items complexes.
    public static final Item BACON = registerItem("bacon", (settings) -> new Item(settings.food(ModFoodComponents.Bacon)));

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