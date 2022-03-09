package mod.hitlerhax.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import static java.lang.Double.isNaN;

public class BlockInteractionUtil {
	static final Minecraft mc = Minecraft.getMinecraft();

	public static float[] getFacingRotations(int x, int y, int z, EnumFacing facing) {
		return getRotationsForPosition(x + 0.5 + facing.getDirectionVec().getX() / 2.0,
				y + 0.5 + facing.getDirectionVec().getY() / 2.0, z + 0.5 + facing.getDirectionVec().getZ() / 2.0);
	}

	public static float[] getRotationsForPosition(double x, double y, double z) {
		return getRotationsForPosition(x, y, z, mc.player.posX, mc.player.posY + mc.player.getEyeHeight(),
				mc.player.posZ);
	}

	public static float[] getRotationsForPosition(double x, double y, double z, double sourceX, double sourceY,
			double sourceZ) {
		double deltaX = x - sourceX;
		double deltaY = y - sourceY;
		double deltaZ = z - sourceZ;

		double yawToEntity;

		if (deltaZ < 0 && deltaX < 0) { // quadrant 3
			yawToEntity = 90D + Math.toDegrees(Math.atan(deltaZ / deltaX)); // 90
			// degrees
			// forward
		} else if (deltaZ < 0 && deltaX > 0) { // quadrant 4
			yawToEntity = -90D + Math.toDegrees(Math.atan(deltaZ / deltaX)); // 90
			// degrees
			// back
		} else { // quadrants one or two
			yawToEntity = Math.toDegrees(-Math.atan(deltaX / deltaZ));
		}

		double distanceXZ = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

		double pitchToEntity = -Math.toDegrees(Math.atan(deltaY / distanceXZ));

		yawToEntity = wrapAngleTo180((float) yawToEntity);
		pitchToEntity = wrapAngleTo180((float) pitchToEntity);

		yawToEntity = isNaN(yawToEntity) ? 0 : yawToEntity;
		pitchToEntity = isNaN(pitchToEntity) ? 0 : pitchToEntity;

		return new float[] { (float) yawToEntity, (float) pitchToEntity };
	}

	public static float wrapAngleTo180(float angle) {
		angle %= 360.0F;

		while (angle >= 180.0F) {
			angle -= 360.0F;
		}
		while (angle < -180.0F) {
			angle += 360.0F;
		}

		return angle;
	}

	public static boolean placeBlock(BlockPos pos, int slot, boolean rotate, boolean rotateBack) {
		if (WorldUtil.NONSOLID_BLOCKS.contains(mc.world.getBlockState(pos).getBlock())) {
			int old_slot = -1;
			if (slot != mc.player.inventory.currentItem) {
				old_slot = mc.player.inventory.currentItem;
				mc.player.inventory.currentItem = slot;
			}

			EnumFacing[] facings = EnumFacing.values();

			for (EnumFacing f : facings) {
				Block neighborBlock = mc.world.getBlockState(pos.offset(f)).getBlock();
				Vec3d vec = new Vec3d(pos.getX() + 0.5D + (double) f.getXOffset() * 0.5D,
						pos.getY() + 0.5D + (double) f.getYOffset() * 0.5D,
						pos.getZ() + 0.5D + (double) f.getZOffset() * 0.5D);

				if (!WorldUtil.NONSOLID_BLOCKS.contains(neighborBlock)
						&& mc.player.getPositionEyes(mc.getRenderPartialTicks()).distanceTo(vec) <= 4.25D) {
					float[] rot = new float[] { mc.player.rotationYaw, mc.player.rotationPitch };

					if (rotate) {
						PlayerUtil.lookAtPos(new BlockPos(vec.x, vec.y, vec.z));
					}

					if (WorldUtil.RIGHTCLICKABLE_BLOCKS.contains(neighborBlock)) {
						mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, Action.START_SNEAKING));
					}

					mc.playerController.processRightClickBlock(mc.player, mc.world, pos.offset(f), f.getOpposite(),
							new Vec3d(pos), EnumHand.MAIN_HAND);
					if (WorldUtil.RIGHTCLICKABLE_BLOCKS.contains(neighborBlock)) {
						mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, Action.STOP_SNEAKING));
					}

					if (rotateBack) {
						mc.player.connection.sendPacket(new Rotation(rot[0], rot[1], mc.player.onGround));
					}

					if (old_slot != -1) {
						mc.player.inventory.currentItem = old_slot;
					}

					return true;
				}
			}

		}

		return false;
	}
}
