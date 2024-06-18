package violet.apeiron.event;

import com.mojang.datafixers.util.Either;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import violet.apeiron.Apeiron;
import violet.apeiron.data.ApeironAttachments;
import violet.apeiron.data.modifiertypes.ArmorModifier;
import violet.apeiron.item.ApeironItems;
import violet.apeiron.item.util.EventReceiver;

/**
 * Example Mod's event handler for all events posted on the Forge bus.
 *
 * @see ModEventHandler
 */
@Mod.EventBusSubscriber(modid = Apeiron.MODID)
public class ForgeEventHandler {

	@SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		// Regular Item Ticks
		for (var item : ApeironItems.ITEMS.getEntries()) {
			if (item.get() instanceof EventReceiver eventReceiver) {
				if (event.player.getInventory().contains(item.get().getDefaultInstance())) { 
					eventReceiver.onInventoryTick(event);
				}
			}
		}

		// Armor Item Ticks
		for (ItemStack armorItem : event.player.getArmorSlots()) {
			if (armorItem.getItem() instanceof EventReceiver eventReceiver) {
				eventReceiver.onArmorTick(event, armorItem);
			}

			for (var modifier : armorItem.getData(ApeironAttachments.MODIFIER).modifierEntries()) {
				ArmorModifier armorModifier = (ArmorModifier) modifier;	
				armorModifier.onWearingTick(event);
			}
		}
    }

	@SubscribeEvent
	public static void onEntityHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof Player player) {

			// Armor hurt events
			for (ItemStack armorItem : player.getArmorSlots()) {
				for (var modifier : armorItem.getData(ApeironAttachments.MODIFIER).modifierEntries()) {
					ArmorModifier armorModifier = (ArmorModifier) modifier;	
					armorModifier.onDamageTakenWhileWearing(event);
				}
			}

		}
	}

	@SubscribeEvent
	public static void renderTooltip(RenderTooltipEvent.GatherComponents event) {

		// Display the modifiers
		event.getTooltipElements().add(Either.left(FormattedText.of("Modifiers:")));
		for (var modifierEntry : event.getItemStack().getData(ApeironAttachments.MODIFIER).modifierEntries()) {
			event.getTooltipElements().add(Either.left(FormattedText.of("    " + modifierEntry.getKey().name, Style.EMPTY.withColor(modifierEntry.getKey().color))));
		}

		// Add the "Hold shift for more information" message
		if (!Screen.hasShiftDown()) {
			event.getTooltipElements().add(Either.left(FormattedText.of("    ")));
			event.getTooltipElements().add(Either.left(FormattedText.of("Hold SHIFT for more information...", Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true))));
		}
	}

	@SubscribeEvent
	public static void renderTooltipColor(RenderTooltipEvent.Color event) {
	}
}
