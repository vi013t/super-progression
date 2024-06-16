package violet.apeiron.data.modifiers;

import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class ProtectionModifier extends Modifier implements ArmorModifier {

	public static final ProtectionModifier INSTANCE = new ProtectionModifier();

	private ProtectionModifier() {
		super("Protection", 0, 0xFF88CC, "Reduces damage taken.");
	}

	@Override
	public void onDamageTakenWhileWearing(LivingHurtEvent event) {
		event.setAmount(event.getAmount() / 2);
	}
}
