package org.wesal.tutorialmod.component;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.wesal.tutorialmod.TutorialMod;

import java.util.function.UnaryOperator;

public class ModDataComponents {

    public static final ComponentType<BlockPos> COORDINATES_BLOCK = register("coorginates",
            builder -> builder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(TutorialMod.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }
    public static void registerDataComponentType(){
    }
}
