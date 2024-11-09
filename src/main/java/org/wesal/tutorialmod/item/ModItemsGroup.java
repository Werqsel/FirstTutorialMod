package org.wesal.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.wesal.tutorialmod.TutorialMod;
import org.wesal.tutorialmod.block.ModBlocks;

import static org.wesal.tutorialmod.item.ModItems.*;
import static org.wesal.tutorialmod.block.ModBlocks.*;

public class ModItemsGroup {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"pink_garnet_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .entries((displayContext, entries) -> {
                      entries.add(RAW_PINK_GARNET);
                      entries.add(PINK_GARNET);
                    })
                    .build());
    public static final ItemGroup PINK_GARNET_FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"pink_garnet_food"),
            FabricItemGroup.builder().displayName(Text.translatable("pink_garnet_food"))
                    .icon(() -> new ItemStack(ModItems.FLOWERFOOD))
                    .entries((displayContext, entries) -> {
                        entries.add(FLOWERFOOD);
                        entries.add(STARLIGHT_ASHES);
                    })
                    .build());
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"pink_garnet_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
                    .icon(() -> new ItemStack(PINK_GARNET_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(RAW_PINK_GARNET_BLOCK);
                        entries.add(PINK_GARNET_BLOCK);
                        entries.add(PINK_GARNET_ORE);
                        entries.add(PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(MAGIC_BLOCK);
                    })
                    .build());
    public static final ItemGroup WHITE_WOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"white_wood_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tutorialmod.white_wood_group"))
                    .icon(() -> new ItemStack(WHITE_PLANKS))
                    .entries((displayContext, entries) -> {
                        entries.add(WHITE_PLANKS);
                        entries.add(WHITE_WOOD_BUTTON);
                        entries.add(WHITE_WOOD_DOOR);
                        entries.add(WHITE_WOOD_TRAPDOOR);
                        entries.add(WHITE_WOOD_FENCE);
                        entries.add(WHITE_WOOD_GATE);
                        entries.add(WHITE_WOOD_WALL);
                        entries.add(WHITE_WOOD_SLAB);
                        entries.add(WHITE_WOOD_STAIRS);
                        entries.add(WHITE_WOOD_PRESSURE_PLATE);
                        entries.add(WHITE_WOOD_LAMP);
                    })
                    .build());
    public static final ItemGroup PINK_GARNET_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"pink_garnet_tools_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_tools_group"))
                    .icon(() -> new ItemStack(PINK_GARNET_PICKAXE))
                    .entries((displayContext, entries) -> {
                        entries.add(PINK_GARNET_SWORD);
                        entries.add(PINK_GARNET_PICKAXE);
                        entries.add(PINK_GARNET_AXE);
                        entries.add(PINK_GARNET_HOE);
                        entries.add(PINK_GARNET_SHOVEL);
                        entries.add(PINK_GARNET_HAMMER);
                        entries.add(TRAVELER_SWORD);
                    })
                    .build());



    public static void registerItemGrops(){
        TutorialMod.LOGGER.info(TutorialMod.MOD_ID);
    }
}
