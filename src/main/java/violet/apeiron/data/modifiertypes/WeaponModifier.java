package violet.apeiron.data.modifiertypes;

import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

public interface WeaponModifier {
	public default void onAttack(AttackEntityEvent event) {}
}
