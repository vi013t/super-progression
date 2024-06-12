package violet.apeiron.item.boss;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.item.mining.opal.OpalUtils;

public class PhoenixFeather extends Item {

	public PhoenixFeather() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		components.add(Component.literal("Modifier: ").append(Component.literal("Resurrection").withColor(0xFF5533)));
		if (Screen.hasShiftDown()) {
			components.add(Component.literal(""));
			components.add(OpalUtils.colorize("A feather from a fallen Phoenix."));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
		}
	}
}
