package org.wesal.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
    private static final Item TELEPORT_WAND = register("tpwand", new TeleportWand(new Item.Settings()));

    public static void registerItem(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(myentries -> {
            myentries.add(PINK_GARNET);
            myentries.add(RAW_PINK_GARNET);
            myentries.add(CHISEL);
            myentries.add(TELEPORT_WAND);
        });
    } ///-----IMPORTANT-----///

    public static Item register(String id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID,id),item);
    }
}
