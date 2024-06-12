
package violet.apeiron.item.mining.opal.material;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.item.mining.opal.OpalUtils;

public class OpalDust extends Item { 

	public OpalDust() {
		super(new Item.Properties());
	}

	@Override
    public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
    }

	@Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.clear();
		components.add(OpalUtils.colorize("Opal Dust", Style.EMPTY.withBold(true)));
		if (Screen.hasShiftDown()) {
			components.add(Component.literal("Modifier: Fire Reisistance").withStyle(Style.EMPTY.withColor(0xCC77FF)));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withItalic(true).withColor(0x555555)));
		}
    }
} 