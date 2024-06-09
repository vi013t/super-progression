package author.example.item.magic;

import java.util.List;

import javax.annotation.Nullable;

import author.example.item.exploration.opal.OpalUtils;
import author.example.item.general.TieredItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Infinio extends TieredItem {

	public Infinio() {
		super(10, "Infinio");
	}

	/**
	 * Called when the player uses the item on a block. For Infinio, this duplicates
	 * the block (if there is room), and consumes one item in the stack.
	 */
	@Override
	@SuppressWarnings("null")
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
	@SuppressWarnings("null")
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		if (Screen.hasShiftDown()) {
			components.add(OpalUtils.colorize("Pure concentrated essence of infinity."));
			components.add(Component.literal(""));
			components.add(Component.literal("Infinio is the most exotic and powerful"));
			components.add(Component.literal("essence. It's said that infinio has existed"));
			components.add(Component.literal("as long as time itself, and came into existence"));
			components.add(Component.literal("as 'an anomaly formed during the creation of"));
			components.add(Component.literal("the universe'. Infinio has many powerful"));
			components.add(Component.literal("properties, including block duplication, creature"));
			components.add(Component.literal("cloning, and more."));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
		}
	}

}
