package violet.apeiron.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
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
}
