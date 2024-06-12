package violet.apeiron.item.boss;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class UnicornHorn extends SwordItem {

	public UnicornHorn() {
		super(Tiers.NETHERITE, 3, 1, new Item.Properties());
	}
	
	@Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.add(Component.literal("Tier 2"));
		if (Screen.hasShiftDown()) {
			components.add(Component.literal("An exotic artifact only found on mystical beasts.").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
			components.add(Component.literal("While unicorns once roamed the lands, they are").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
			components.add(Component.literal("now on the brink of extinction, with some saying").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
			components.add(Component.literal("saying there aren't any at all left.").withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
		}
    }
}
