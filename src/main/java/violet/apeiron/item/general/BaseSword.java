package violet.apeiron.item.general;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.data.ApeironAttachments;

public class BaseSword extends Item {

	public BaseSword() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		for (var modifierEntry : stack.getData(ApeironAttachments.MODIFIER).modifierEntries()) {
			components.add(Component.literal(modifierEntry.getKey().getName() + " " + modifierEntry.getValue()).withColor(modifierEntry.getKey().getColor()));
		}
	}
}
