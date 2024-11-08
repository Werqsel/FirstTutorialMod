package org.wesal.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.wesal.tutorialmod.TutorialMod;
import org.wesal.tutorialmod.item.custom.ChiselItem;
import org.wesal.tutorialmod.item.custom.TeleportWand;

public class ModItems {

    public static final Item PINK_GARNET = register("pink_garnet",new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = register("raw_pink_garnet",new Item(new Item.Settings()));
    public static final Item CHISEL = register("chisel",new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item TELEPORT_WAND = register("tpwand", new TeleportWand(new Item.Settings()));
    public static final Item FLOWERFOOD = register("flower", new Item(new Item.Settings().food(ModFoodComponents.COUILFLOWER)));
    public static final Item STARLIGHT_ASHES = register("starlight_ashes", new Item(new Item.Settings()));
//    public static final Item LIGHTNING_DRINK = register("lightning_drink", new Item(new Item.Settings().food(ModFoodComponents.LIGHTNING_DRINK)));
public static final Item PINK_GARNET_SWORD = register("pink_garnet_sword",
        new SwordItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f))));
    public static final Item PINK_GARNET_PICKAXE = register("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1, -2.8f))));
    public static final Item PINK_GARNET_SHOVEL = register("pink_garnet_shovel",
            new ShovelItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1.5f, -3.0f))));
    public static final Item PINK_GARNET_AXE = register("pink_garnet_axe",
            new AxeItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 6, -3.2f))));
    public static final Item PINK_GARNET_HOE = register("pink_garnet_hoe",
            new HoeItem(ModToolMaterials.PINK_GARNET, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 0, -3f))));

    public static void registerItem(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(myentries -> {
            myentries.add(PINK_GARNET);
            myentries.add(RAW_PINK_GARNET);
            myentries.add(CHISEL);
            myentries.add(TELEPORT_WAND);
            myentries.add(FLOWERFOOD);
        });
    } ///-----IMPORTANT-----///

    public static Item register(String id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID,id),item);
    }
}
