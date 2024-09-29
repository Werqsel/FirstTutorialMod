package org.wesal.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.wesal.tutorialmod.TutorialMod;

public class ModItems {
    public static final FoodComponent SPEED_INCREACE = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,8*20,8),100)
            .build();
    public static final Item AMETHYST_REDSTONE = register(new Item(
            new Item.Settings().maxCount(32).food(SPEED_INCREACE)),
            "amethyst_redstone");

    public static Item register(Item item, String id) {
        // Create the identifier for the amethyst_redstone.json.
        Identifier itemID = Identifier.of(TutorialMod.MOD_ID, id);
        // Register the amethyst_redstone.json.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        // Return the registered amethyst_redstone.json!
        return registeredItem;
    }
    // Get the event for modifying entries in the ingredients group.
    // And register an event handler that adds our suspicious amethyst_redstone.json to the ingredients group.
    public static void initilization(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(AMETHYST_REDSTONE);
            inizilizationAddictions();
        });
    }
    public static void inizilizationAddictions(){
        // Add the suspicious substance to the flammable block registry with a burn time of 30 seconds.
        // Remember, Minecraft deals with logical based-time using ticks.
        // 20 ticks = 1 second.
        FuelRegistry.INSTANCE.add(ModItems.AMETHYST_REDSTONE, 30 * 20);
    }
}