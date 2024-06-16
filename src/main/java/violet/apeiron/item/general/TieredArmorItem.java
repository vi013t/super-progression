package violet.apeiron.item.general;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.data.ApeironAttachments;
import violet.apeiron.data.Modifier;

public class TieredArmorItem extends ArmorItem {

	private final Modifier modifier;

	public TieredArmorItem(ArmorMaterial material, ArmorItem.Type type, Modifier modifier) {
		super(material, type, new Item.Properties());
		this.modifier = modifier;
	}

	@Override
	public ItemStack getDefaultInstance() {
		ItemStack stack = new ItemStack(this);
		stack.getData(ApeironAttachments.MODIFIER).addModifier(this.modifier, this.modifier.tier);
		return stack;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (!stack.getData(ApeironAttachments.MODIFIER).hasModifier(modifier)) {
			stack.getData(ApeironAttachments.MODIFIER).addModifier(modifier, this.modifier.tier);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.add(Component.literal("Tier " + this.modifier.tier).withStyle(ChatFormatting.GRAY));
		components.add(Component.literal(""));

		// Modifiers
		components.add(Component.literal("Modifiers:"));
		for (var modifierEntry : stack.getData(ApeironAttachments.MODIFIER).modifierEntries()) {
			var component = Component.literal("    " + modifierEntry.getKey().name).withColor(modifierEntry.getKey().color);
			if (Screen.hasShiftDown()) {
				component.append(Component.literal(" - " + modifierEntry.getKey().description).withStyle(ChatFormatting.DARK_GRAY));
			}
			components.add(component);
		}

		// Shift Info
		if (!Screen.hasShiftDown()) {
			components.add(Component.literal(""));
			components.add(Component.literal("Hold SHIFT for more information...").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true)));
		}
	}
}
