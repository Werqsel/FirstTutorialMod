package org.wesal.tutorialmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class GuiditeMaterial implements ToolMaterial {
    public static final ToolMaterial INSTANCE = new GuiditeMaterial();

    @Override
    public int getDurability() {
        return 455;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.0F;
    }

    @Override
    public float getAttackDamage() {
        return 2.0F;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.DIRT;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DIRT);
    }
}
