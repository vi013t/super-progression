package violet.apeiron.item.boss;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.item.util.EventReceiver;

public class CyclopsEye extends ArmorItem implements EventReceiver {
	
	public CyclopsEye() {
		super(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties());
	}

	@Override
	public void onArmorTick(PlayerTickEvent event, ItemStack _stack) {
		event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 250, 0));
	}
}
