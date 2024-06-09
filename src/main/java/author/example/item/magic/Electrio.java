package author.example.item.magic;

import java.util.List;

import javax.annotation.Nullable;

import author.example.item.general.TieredItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Electrio extends TieredItem {

	public Electrio() {
		super(2);
	}

	@Override
	@SuppressWarnings("null")
	public InteractionResult useOn(UseOnContext context) {
		BlockPos blockPlacePosition = context.getClickedPos().offset(context.getClickedFace().getNormal());
		if (context.getLevel().isEmptyBlock(blockPlacePosition) && context.getLevel().getBlockState(blockPlacePosition.below()).isSolidRender(context.getLevel(), blockPlacePosition.below())) {
			context.getItemInHand().shrink(1);
			LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, context.getLevel());
			lightning.setPos(blockPlacePosition.getX(), blockPlacePosition.getY(), blockPlacePosition.getZ());
			context.getLevel().addFreshEntity(lightning);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	@SuppressWarnings("null")
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		if (Screen.hasShiftDown()) {
			components.add(Component.literal("Pure concentrated electricity essence.").withStyle(Style.EMPTY.withColor(0xFFFF00)));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
		}
	}
}
