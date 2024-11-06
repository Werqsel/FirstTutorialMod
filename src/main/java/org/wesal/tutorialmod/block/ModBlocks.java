package org.wesal.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.wesal.tutorialmod.TutorialMod;
import org.wesal.tutorialmod.block.custom.MagicBlock;
import org.wesal.tutorialmod.block.custom.WhiteWoodLampBlock;

import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(3f)));
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .strength(4f)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.BAMBOO_SAPLING
                    )));

    public static final Block WHITE_PLANKS = registerBlock("white_planks", new Block(AbstractBlock.Settings.create()
            .strength(2f)
            .requiresTool()
    ));

    public static final Block WHITE_WOOD_STAIRS = registerBlock("white_wood_stairs",
            new StairsBlock(ModBlocks.WHITE_PLANKS.getDefaultState(),
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
            ));
    public static final Block WHITE_WOOD_SLAB = registerBlock("white_wood_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
            ));

    public static final Block WHITE_WOOD_BUTTON = registerBlock("white_wood_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .noCollision()
            ));
    public static final Block WHITE_WOOD_PRESSURE_PLATE = registerBlock("white_wood_pressure_plate",
            new PressurePlateBlock(BlockSetType.BIRCH,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
            ));
    public static final Block WHITE_WOOD_FENCE = registerBlock("white_wood_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
            ));
    public static final Block WHITE_WOOD_GATE = registerBlock("white_wood_gate",
            new FenceGateBlock(WoodType.BIRCH,AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
            ));
    public static final Block WHITE_WOOD_WALL = registerBlock("white_wood_wall",
            new WallBlock(AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
            ));

    public static final Block WHITE_WOOD_DOOR = registerBlock("white_wood_door",
            new DoorBlock(BlockSetType.BIRCH,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool().nonOpaque()
            ));
    public static final Block WHITE_WOOD_TRAPDOOR = registerBlock("white_wood_trapdoor",
            new TrapdoorBlock(BlockSetType.BIRCH,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool().nonOpaque()
            ));

    public static final Block WHITE_WOOD_LAMP = registerBlock("white_wood_lamp",
            new WhiteWoodLampBlock(AbstractBlock.Settings.create().strength(2f).requiresTool().luminance(state -> state.get(WhiteWoodLampBlock.CLICKED) ? 15 : 0)));
    private static Block registerBlock(String id, Block block){
        registerBlockItem(id,block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID,id), block);
    }

    private static void registerBlockItem(String id, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID,id),
                new BlockItem(block,new Item.Settings()));
    }


    public static void registerBlocks(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
        });
    }
}
