package org.wesal.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import org.wesal.tutorialmod.block.ModBlocks;
import org.wesal.tutorialmod.block.custom.WhiteWoodLampBlock;
import org.wesal.tutorialmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        BlockStateModelGenerator.BlockTexturePool whitePlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WHITE_PLANKS);

        whitePlanksPool.stairs(ModBlocks.WHITE_WOOD_STAIRS);
        whitePlanksPool.slab(ModBlocks.WHITE_WOOD_SLAB);
        whitePlanksPool.button(ModBlocks.WHITE_WOOD_BUTTON);
        whitePlanksPool.fence(ModBlocks.WHITE_WOOD_FENCE);
        whitePlanksPool.fenceGate(ModBlocks.WHITE_WOOD_GATE);
        whitePlanksPool.wall(ModBlocks.WHITE_WOOD_WALL);
        whitePlanksPool.pressurePlate(ModBlocks.WHITE_WOOD_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.WHITE_WOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WHITE_WOOD_TRAPDOOR);


        //Better to create JSON file on my own//
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.WHITE_WOOD_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.WHITE_WOOD_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WHITE_WOOD_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(WhiteWoodLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.TELEPORT_WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOWERFOOD, Models.GENERATED);
    }
}
