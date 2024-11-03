package org.wesal.tutorialmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.wesal.tutorialmod.item.ModItems;
import org.wesal.tutorialmod.util.ModTags;

import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player,pos,SoundEvents.ENTITY_GOAT_HORN_BREAK,SoundCategory.BLOCKS);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity item){
            if(isValidItem(item.getStack())){
                item.setStack(new ItemStack(Items.DIAMOND, item.getStack().getCount()));
            }
        } else if (entity instanceof PlayerEntity player) {
            player.setStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 4,20), player);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.tutorialmod.magic_block.tooltip"));
        tooltip.add(Text.translatable("block.tutorialmod.magic_block.tooltip1"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}