package org.wesal.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.multiplayer.SocialInteractionsScreen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block,Block> CHISEL_MAP = Map.of(
            Blocks.SAND,Blocks.SANDSTONE,
            Blocks.STONE,Blocks.STONE_BRICKS,
            Blocks.END_STONE,Blocks.END_STONE_BRICKS,
            Blocks.COBBLESTONE,Blocks.STONE,
            Blocks.DIRT,Blocks.NETHERITE_BLOCK
    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)){
            if (!world.isClient){
                // Change block
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                // Damage the item
                context.getStack().damage(4,((ServerWorld) world),((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_FALL, SoundCategory.BLOCKS);
            }
        }
        return ActionResult.SUCCESS;
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (SocialInteractionsScreen.hasShiftDown()){
            tooltip.add(Text.translatable("item.tutorialmod.chisel.tooltip"));
        } else {
            tooltip.add(Text.translatable("item.tutorialmod.chisel.tooltip2"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
