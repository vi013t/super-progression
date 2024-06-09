package author.example.item.magic;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class Vitalio extends Essence {

	public Vitalio() {
		super(2, "life", Blocks.GRASS_BLOCK, Style.EMPTY.withColor(0x55FF55));
	}

	/**
	 * Called when the player uses the item on an entity. For vitalio, this heals the entity.
	 */
	@Override
	@SuppressWarnings("resource")
	public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
		entity.heal(entity.getMaxHealth());
		stack.shrink(1);

		// Spawn heart particles
		if (player.level().isClientSide) {
			Random random = new Random();
			for (int particleNumber = 0; particleNumber < 5; particleNumber++) {
				Vec3 offset = new Vec3((random.nextDouble() - 0.5D) * 0.5D, (random.nextDouble() - 0.5D) * 0.5D + entity.getBbHeight() / 2, (random.nextDouble() - 0.5D) * 0.5D);
				Vec3 position = entity.position().add(offset);
				player.level().addParticle(ParticleTypes.HEART, position.x(), position.y(), position.z(), 0.0D, 0.0D, 0.0D);
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	@SuppressWarnings("null") // Copied from `BoneMealItem.useOn()`
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
		if (BoneMealItem.applyBonemeal(context.getItemInHand(), level, blockpos, context.getPlayer())) {
			if (!level.isClientSide) {
				context.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
				level.levelEvent(1505, blockpos, 0);
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			BlockState blockstate = level.getBlockState(blockpos);
			boolean flag = blockstate.isFaceSturdy(level, blockpos, context.getClickedFace());
			if (flag && BoneMealItem.growWaterPlant(context.getItemInHand(), level, blockpos1, context.getClickedFace())) {
				if (!level.isClientSide) {
					context.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
					level.levelEvent(1505, blockpos1, 0);
				}

				return InteractionResult.sidedSuccess(level.isClientSide);
			} else {
				return InteractionResult.PASS;
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);

		components.add(
			Component.literal("Modifier: ").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY))
			.append(Component.literal("Healing").withStyle(Style.EMPTY.withColor(0x55FF55)))
		);

		if (Screen.hasShiftDown()) {
			components.add(Component.literal(""));
			components.add(Component.literal("Tools and weapons with ").withStyle(ChatFormatting.GRAY).append(Component.literal("healing ")).append(Component.literal("do not ")));
			components.add(Component.literal("damage entities they hit, but instead, heals them").withStyle(ChatFormatting.GRAY));
			components.add(Component.literal(""));
			components.add(Component.literal("Vitalio, being concentrated life essense, has many"));
			components.add(Component.literal("magical properties, such as growing plants, healing"));
			components.add(Component.literal("creatures, and more."));
		}
	}
}
