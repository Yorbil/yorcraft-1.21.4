package net.yorbil.yorcraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yorbil.yorcraft.block.ModBlocks;
import net.yorbil.yorcraft.Yorcraft;

public class ModItemGroups {

    public static final ItemGroup YORCRAFT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Yorcraft.MOD_ID, "yorcraft_items_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BACON))
                    .displayName(Text.translatable("itemgroup.yorcraft.yorcraft_items_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.BACON);

                        entries.add(ModBlocks.CARROT_CRATE.getRight());

                    }).build());

    public static void registerItemGroups() {
        Yorcraft.LOGGER.info("Registering Item Groups for " + Yorcraft.MOD_ID);
    }
}
