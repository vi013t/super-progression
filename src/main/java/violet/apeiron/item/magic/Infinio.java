package violet.apeiron.item.magic;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import violet.apeiron.data.Modifier;
import violet.apeiron.item.general.ModifierItem;
import violet.apeiron.item.mining.opal.OpalUtils;

public class Infinio extends ModifierItem {

	public Infinio() {
		super(Modifier.LIMITLESS, "Infinio");
	}

	/**
	 * Called when the player uses the item on a block. For Infinio, this duplicates
	 * the block (if there is room), and consumes one item in the stack.
	 */
	@Override
	public InteractionResult useOn(UseOnContext context) {
		BlockPos blockPlacePosition = context.getClickedPos().offset(context.getClickedFace().getNormal());
		if (context.getLevel().isEmptyBlock(blockPlacePosition) && context.getLevel().getBlockState(blockPlacePosition.below()).isSolidRender(context.getLevel(), blockPlacePosition.below())) {
			context.getLevel().setBlock(blockPlacePosition, context.getLevel().getBlockState(context.getClickedPos()), 3);
			context.getItemInHand().shrink(1);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	/**
	 * Called when the player uses the item on a block. For Infinio, this duplicates
	 * the entity, and consumes one item in the stack.
	 */
	@Override
	@SuppressWarnings("null")
	public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
		LivingEntity duplicate = (LivingEntity) entity.getType().create(playerIn.level());
		duplicate.setPos(entity.getX(), entity.getY(), entity.getZ());
		playerIn.level().addFreshEntity(duplicate);
		stack.shrink(1);
		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		if (Screen.hasShiftDown()) {
			components.add(Component.literal(""));
			components.add(OpalUtils.colorize("Pure concentrated essence of infinity."));
			components.add(Component.literal(""));
			components.add(Component.literal("What do you think happens"));
			components.add(Component.literal("when one touches the void?"));
		}	
	}
}
