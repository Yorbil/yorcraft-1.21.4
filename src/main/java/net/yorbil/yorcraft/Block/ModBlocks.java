package net.yorbil.yorcraft.Block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.yorbil.yorcraft.Yorcraft;

public class ModBlocks {

    public static final Block CARROT_CRATE = registerBlock("carrot_crate",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Yorcraft.MOD_ID, "carrot_crate")))
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)));

    //register block system
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Yorcraft.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Yorcraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Yorcraft.MOD_ID, name)))));
    }
    public static void registerModBlocks() {
        Yorcraft.LOGGER.info("Refistering Mod Blocks for " + Yorcraft.MOD_ID);

    }
}