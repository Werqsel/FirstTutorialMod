package org.wesal.tutorialmod.item.custom;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.RunArgs;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static net.minecraft.sound.SoundCategory.BLOCKS;

public class TeleportWand extends Item {

    public TeleportWand(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Vec3d v3 = context.getBlockPos().toCenterPos();
        World world = context.getWorld();
            if (context.getHand() == Hand.MAIN_HAND) {
                context.getPlayer().setPosition((v3.getX()+context.getSide().getOffsetX()*0.5),
                        (v3.getY()+context.getSide().getOffsetY()*0.5),
                        (v3.getZ()+context.getSide().getOffsetZ()*0.5));
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ANVIL_STEP, BLOCKS);
        }
        return ActionResult.SUCCESS;
        }
}