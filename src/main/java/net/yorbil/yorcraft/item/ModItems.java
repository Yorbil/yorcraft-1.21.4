package net.yorbil.yorcraft.item;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new);
    public static final Item BACON = registerItem("bacon", (settings) -> new Item(settings.food(ModFoodComponents.Bacon)));

    public static Item registerItem(String name) {
        return registerItem(name, Item::new);
    }

    public static <T extends Item> T registerItem(String name, ItemFactory<T> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("yorcraft",name));
       return net.minecraft.registry.Registry.register(
                Registries.ITEM,
                key,
                factory.create(new Item.Settings().registryKey(key))
        );
    }
    @FunctionalInterface
    public interface ItemFactory<T extends Item> {
        T create(Item.Settings settings);
    }
    public static void initialize() {
    }
}