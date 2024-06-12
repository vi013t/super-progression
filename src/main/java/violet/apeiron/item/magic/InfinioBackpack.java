package violet.apeiron.item.magic;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class InfinioBackpack extends Item {

	public InfinioBackpack() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		components.add(Component.literal("Infinite mobile storage for items, fluids,"));
		components.add(Component.literal("energy, experience, gases, and more."));
	}
}
