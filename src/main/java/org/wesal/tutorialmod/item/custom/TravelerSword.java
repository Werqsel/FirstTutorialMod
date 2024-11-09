package org.wesal.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


import static net.minecraft.util.math.Direction.*;

public class TravelerSword extends SwordItem {
    public TravelerSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        if (user.getFacing().equals(SOUTH) || user.getFacing().equals(NORTH)) {
//                for (int i = 0; i <= 10; i++) {
//                WindChargeEntity windChargeEntity = new WindChargeEntity(user, world, user.getPos().getX() + i * 0.5, user.getEyePos().getY(), user.getPos().getZ());
//                windChargeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//                world.spawnEntity(windChargeEntity);
//                windChargeEntity = new WindChargeEntity(user, world, user.getPos().getX() - i * 0.5, user.getEyePos().getY(), user.getPos().getZ());
//                windChargeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//                world.spawnEntity(windChargeEntity);
//            }
//        }
//        if (user.getFacing().equals(WEST) || user.getFacing().equals(EAST)) {
//            for (int i = 0; i <= 10; i++) {
//                WindChargeEntity windChargeEntity = new WindChargeEntity(user, world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ() + i * 0.5);
//                windChargeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//                world.spawnEntity(windChargeEntity);
//                windChargeEntity = new WindChargeEntity(user, world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ() - i * 0.5);
//                windChargeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//                world.spawnEntity(windChargeEntity);
//            }
//        }
//        return super.use(world, user, hand);
        for (int i = 0; i<10;i++){
            for (int j = 0; j <10; j++){
                // x^2+y^2 = R^2
                // x^2 = R^2 - y^2
                WindChargeEntity windChargeEntity = new WindChargeEntity(user, world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ());
                windChargeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(windChargeEntity);
            }
        }
        return super.use(world, user, hand);
        }
    }