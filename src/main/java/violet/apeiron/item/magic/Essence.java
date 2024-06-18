package violet.apeiron.item.magic;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import violet.apeiron.item.general.TieredItemOld;

public class Essence extends TieredItemOld {

	private final String name;
	private final Block placeableBlock;
	private final Style style;

	public Essence(int tier, String name, Block placeableBlock, Style style) {
		super(tier);
		this.name = name;
		this.placeableBlock = placeableBlock;
		this.style = style;
	}

	@Override
	@SuppressWarnings("null")
	public InteractionResult useOn(UseOnContext context) {
		BlockPos blockPlacePosition = context.getClickedPos().offset(context.getClickedFace().getNormal());
		if (context.getLevel().isEmptyBlock(blockPlacePosition) && context.getLevel().getBlockState(blockPlacePosition.below()).isSolidRender(context.getLevel(), blockPlacePosition.below())) {
			context.getLevel().setBlock(blockPlacePosition, this.placeableBlock.defaultBlockState(), 3);
			context.getItemInHand().shrink(1);
			context.getPlayer().playSound(SoundEvents.GRASS_PLACE);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.add(Component.literal("Tier " + this.tier));
		if (Screen.hasShiftDown()) {
			components.add(Component.literal("Pure concentrated " + this.name + " essence.").withStyle(this.style));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
		}
	}
}
