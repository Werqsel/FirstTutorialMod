package org.wesal.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.wesal.tutorialmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.item.Items.*;
import static org.wesal.tutorialmod.item.ModItems.*;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(RAW_PINK_GARNET)
                .add(COAL)
                .add(STICK);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(PINK_GARNET_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(PINK_GARNET_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(PINK_GARNET_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(PINK_GARNET_HOE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(PINK_GARNET_SHOVEL);
    }
}
