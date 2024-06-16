package violet.apeiron.data.modifiers;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.WeaponModifier;

public class HealingModifier extends Modifier implements WeaponModifier {

	public static final HealingModifier INSTANCE = new HealingModifier();

	private HealingModifier() {
		super("Healing", 3, 0x55FF55, "Attacks heal the target.");
	}

	@Override
	public void onAttack(AttackEntityEvent event) {
		if (event.getTarget() instanceof LivingEntity living) {
			living.heal(4);
			event.setCanceled(true);
		}
	}
}
