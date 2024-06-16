package violet.apeiron.data.modifiers;

import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.WeaponModifier;

public class SharpnessModifier extends Modifier implements WeaponModifier {

	public static final SharpnessModifier INSTANCE = new SharpnessModifier();

	private SharpnessModifier() {
		super("Sharpness", 0, 0x5555FF, "Increases damage dealt.");
	}

	@Override
	public void onAttack(AttackEntityEvent event) {
	}
}
