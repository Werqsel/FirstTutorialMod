package org.wesal.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import java.util.concurrent.CompletableFuture;
import static org.wesal.tutorialmod.block.ModBlocks.*;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(PINK_GARNET_BLOCK)
                .add(PINK_GARNET_ORE)
                .add(PINK_GARNET_DEEPSLATE_ORE)
                .add(RAW_PINK_GARNET_BLOCK)
                .add(MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(PINK_GARNET_DEEPSLATE_ORE)
                .add(PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(WHITE_WOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(WHITE_WOOD_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(WHITE_WOOD_WALL);
    }
}
