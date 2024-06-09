package author.example.item.general;

import java.util.List;

import javax.annotation.Nullable;

import author.example.data.ExampleAttachments;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class BaseSword extends Item {

	public BaseSword() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		for (var modifierEntry : stack.getData(ExampleAttachments.MODIFIER).modifierEntries()) {
			components.add(Component.literal(modifierEntry.getKey().getName() + " " + modifierEntry.getValue()).withColor(modifierEntry.getKey().getColor()));
		}
	}
}
