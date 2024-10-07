package org.wesal.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import org.wesal.tutorialmod.TutorialMod;

import static org.wesal.tutorialmod.item.ModItemsGroup.*;

public class ModItems {

    //---------------------------FABRIC DOCUMENTATION------------------------//
    //---------------------------FABRIC DOCUMENTATION------------------------//
    //---------------------------FABRIC DOCUMENTATION------------------------//

    // Get the event for modifying entries in the ingredients group.
    // And register an event handler that adds our suspicious amethyst_redstone.json to the ingredients group.
    public static void initilization(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(AMETHYST_REDSTONE);
        });
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(entries1 -> {
            entries1.add(PICKAXE);
            entries1.add(SWORD);
            entries1.add(SHOVEL);
            entries1.add(AXE);
            inizilizationAddictions();
        });
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ARMOR_GROUP_KEY).register(entries3 -> {
            entries3.add(AMETHYST_HELMET);
            entries3.add(AMETHYST_CHESTPLATE);
            entries3.add(AMETHYST_LEGGINGS);
            entries3.add(AMETHYST_BOOTS);
        });
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ARMOR_GROUP_KEY, CUSTOM_ARMOR_GROUP);
    }
    public static void inizilizationAddictions(){
        // Add the suspicious substance to the flammable block registry with a burn time of 30 seconds.
        // Remember, Minecraft deals with logical based-time using ticks.
        // 20 ticks = 1 second.
        FuelRegistry.INSTANCE.add(ModItems.AMETHYST_REDSTONE, 30 * 20);
    }

    //-------------------------Items------------------------------------------//

    public static final FoodComponent SPEED_INCREACE = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,8*20,15),100)
            .build();

    public static final Item AMETHYST_REDSTONE = register(new Item(
            new Item.Settings().maxCount(32).food(SPEED_INCREACE)),
            "amethyst_redstone");


    public static Item register(Item item, String id) {
        // Create the identifier for the amethyst_redstone.json.
//        Identifier itemID = Identifier.of(TutorialMod.MOD_ID, id);
//        // Register the amethyst_redstone.json.
//        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
//        // Return the registered amethyst_redstone.json!
//        return registeredItem;
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID,id),item);
    }

    //--------------------------Tools--------------------------------//
    public static final Item PICKAXE = register(new PickaxeItem(GuiditeMaterial.INSTANCE,new Item.Settings()), "amethyst_pickaxe");
    public static final Item SWORD = register(new SwordItem(GuiditeMaterial.INSTANCE, new Item.Settings()), "amethyst_sword");
    public static final Item SHOVEL = register(new ShovelItem(GuiditeMaterial.INSTANCE, new Item.Settings()), "amethyst_shovel");
    public static final Item AXE = register(new AxeItem(GuiditeMaterial.INSTANCE, new Item.Settings()), "amethyst_axe");

    //--------------------------Armor--------------------------------//
    public static final Item AMETHYST_HELMET = register(
            new ArmorItem(
                    ModArmorMaterials.GUIDITE,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET
                            .getMaxDamage(ModArmorMaterials.AMETHYST_DURABILITY_MULTIPLIER))),
                    "amethyst_helmet");
    public static final Item AMETHYST_CHESTPLATE = register(
            new ArmorItem(
                    ModArmorMaterials.GUIDITE,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE
                                    .getMaxDamage(ModArmorMaterials.AMETHYST_DURABILITY_MULTIPLIER))),
                "amethyst_chestplate");
    public static final Item AMETHYST_LEGGINGS = register(
            new ArmorItem(
                    ModArmorMaterials.GUIDITE,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS
                                    .getMaxDamage(ModArmorMaterials.AMETHYST_DURABILITY_MULTIPLIER))),
                "amethyst_leggings");
    public static final Item AMETHYST_BOOTS = register(
            new ArmorItem(
                    ModArmorMaterials.GUIDITE,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS
                                    .getMaxDamage(ModArmorMaterials.AMETHYST_DURABILITY_MULTIPLIER))),
            "amethyst_boots");

    //---------------------------FABRIC DOCUMENTATION------------------------//
    //---------------------------FABRIC DOCUMENTATION------------------------//
    //---------------------------FABRIC DOCUMENTATION------------------------//



    //---------------------------VIDEO TUTORIAL------------------------//

}