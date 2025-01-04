package net.yorbil.yorcraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.yorbil.yorcraft.Yorcraft;

import static net.yorbil.yorcraft.item.ModItems.registerItem;

public class ModBlocks {

//    public static final Pair<Block,BlockItem> CARROT_CRATE = registerBlockWithItem("carrot_crate", Block::new);

    public static final Pair<Block, BlockItem> CARROT_CRATE = registerBlockWithItem("carrot_crate", (settings) -> new Block(
            settings.strength(0.5f)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
    ));

    public static Block registerBlock(String name, AbstractBlock.Settings base) {
        return registerBlock(name, Block::new, base);
    }
    public static Block registerBlock(String name) {
        return registerBlock(name, Block::new);
    }
    public static <T extends Block> T registerBlock(String name, BlockFactory<T> factory) {
        return registerBlock(name, factory, AbstractBlock.Settings.create());
    }
    public static <T extends Block> T registerBlock(String name, BlockFactory<T> factory, AbstractBlock.Settings base) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("yorcraft",name));
        return net.minecraft.registry.Registry.register(
                Registries.BLOCK,
                key,
                factory.create(base.registryKey(key))
        );
    }
    public static Pair<Block, BlockItem> registerBlockWithItem(String name) {
        return registerBlockWithItem(name, AbstractBlock.Settings.create());
    }
    public static Pair<Block, BlockItem> registerBlockWithItem(String name, AbstractBlock.Settings base) {
        return registerBlockWithItem(name, Block::new, base);
    }
    public static <T extends Block> Pair<T, BlockItem> registerBlockWithItem(String name, BlockFactory<T> factory) {
        return registerBlockWithItem(name, factory, AbstractBlock.Settings.create());
    }
    public static <T extends Block> Pair<T, BlockItem> registerBlockWithItem(String name, BlockFactory<T> factory, AbstractBlock.Settings base) {
        return registerBlockWithItem(name, factory, base, (settings, block) -> new BlockItem(block,settings));
    }
    public static <T extends Block, U extends BlockItem> Pair<T, U> registerBlockWithItem(String name, BlockFactory<T> blockFactory, BlockItemFactory<T,U> itemFactory) {
        return registerBlockWithItem(name, blockFactory, AbstractBlock.Settings.create(), itemFactory);
    }
    public static <T extends Block, U extends BlockItem> Pair<T, U> registerBlockWithItem(String name, BlockFactory<T> blockFactory, AbstractBlock.Settings base, BlockItemFactory<T,U> itemFactory) {
        T block = registerBlock(name, blockFactory, base);
        return new Pair<>(
                block,
                registerItem(name, (settings) -> itemFactory.create(settings,block))
        );
    }

    @FunctionalInterface
    public interface BlockFactory<T extends Block> {
        T create(AbstractBlock.Settings settings);
    }

    @FunctionalInterface
    public interface BlockItemFactory<T extends Block, U extends BlockItem> {
        U create(Item.Settings settings, T block);
    }

    public static void registerModBlocks() {
        Yorcraft.LOGGER.info("Refistering Mod Blocks for " + Yorcraft.MOD_ID);

    }
}