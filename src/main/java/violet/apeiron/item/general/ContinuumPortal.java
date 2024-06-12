package violet.apeiron.item.general;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.item.mining.opal.OpalUtils;

public class ContinuumPortal extends Item {

	public ContinuumPortal() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		components.add(Component.literal("Reach your hand into ").append(OpalUtils.colorize("the infinite")));
		components.add(Component.literal("by which all matter is connected."));
	}

}
