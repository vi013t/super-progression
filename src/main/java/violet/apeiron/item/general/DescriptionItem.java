package violet.apeiron.item.general;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DescriptionItem extends Item {

	private final String description;

	public DescriptionItem(Properties properties, String description) {
		super(properties);
		this.description = description;
	}

	@Override
	@SuppressWarnings("null")
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		if (Screen.hasShiftDown()) {
			components.add(Component.literal(description));
		} else {
			components.add(Component.literal("Hold shift for more information").withStyle(ChatFormatting.DARK_GRAY));
		}
	}
}
