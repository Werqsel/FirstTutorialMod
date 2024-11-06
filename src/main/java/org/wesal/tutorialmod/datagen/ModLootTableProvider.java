package org.wesal.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import org.wesal.tutorialmod.block.ModBlocks;
import org.wesal.tutorialmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

import static org.wesal.tutorialmod.block.ModBlocks.*;
import static org.wesal.tutorialmod.block.ModBlocks.WHITE_WOOD_PRESSURE_PLATE;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.PINK_GARNET_BLOCK);
        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);

        addDrop(ModBlocks.PINK_GARNET_ORE, oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_ORE,ModItems.RAW_PINK_GARNET,1,5));

        addDrop(WHITE_PLANKS);
        addDrop(WHITE_WOOD_BUTTON);
        addDrop(WHITE_WOOD_DOOR, doorDrops(WHITE_WOOD_DOOR));
        addDrop(WHITE_WOOD_TRAPDOOR);
        addDrop(WHITE_WOOD_FENCE);
        addDrop(WHITE_WOOD_GATE);
        addDrop(WHITE_WOOD_WALL);

        addDrop(WHITE_WOOD_SLAB, slabDrops(WHITE_WOOD_SLAB));

        addDrop(WHITE_WOOD_STAIRS);
        addDrop(WHITE_WOOD_PRESSURE_PLATE);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
