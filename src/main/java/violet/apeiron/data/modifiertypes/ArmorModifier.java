package violet.apeiron.data.modifiertypes;

import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

public interface ArmorModifier {
	public default void onWearingTick(PlayerTickEvent event) {}
	public default void onDamageTakenWhileWearing(LivingHurtEvent event) {}
}