package violet.apeiron.item.exploration;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MinersHelmet extends Item {

	public MinersHelmet() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		components.add(Component.literal("A lost helmet for lighting a miners way.").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
	}

}
