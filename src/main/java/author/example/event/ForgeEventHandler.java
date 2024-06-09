package author.example.event;

import author.example.Example;
import author.example.item.boss.CyclopsEye;
import author.example.item.magic.KrakenTentacles;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

/**
 * Example Mod's event handler for all events posted on the Forge bus.
 *
 * @see ModEventHandler
 */
@Mod.EventBusSubscriber(modid = Example.MODID)
public class ForgeEventHandler {

	@SubscribeEvent
    public static void giveArmorEffects(TickEvent.PlayerTickEvent event) {
		for (ItemStack armorItem : event.player.getArmorSlots()) {

			// Cyclops Eye
			if (armorItem.getItem() instanceof CyclopsEye) {
				event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 250, 0));
				continue;
			}

			// Kraken Tentacles
			if (armorItem.getItem() instanceof KrakenTentacles) {

				// Aqua Affinity
				if (!armorItem.getAllEnchantments().containsKey(Enchantments.AQUA_AFFINITY)) {
					armorItem.enchant(Enchantments.AQUA_AFFINITY, 1);
				}

				// Dolphin's Grace & Water Breathing
				event.player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 250, 19));
				event.player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 250, 0));

				// Night Vision
				if (event.player.isInWater()) {
					event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 250, 0));
				} else {
					event.player.removeEffect(MobEffects.NIGHT_VISION);
				}

				continue;
			}
		}
    }
}
