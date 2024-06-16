package violet.apeiron.data.modifiers;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class ThornsModifier extends Modifier implements ArmorModifier {

	public static final ThornsModifier INSTANCE = new ThornsModifier();

	private ThornsModifier() {
		super("Thorns", 8, 0xCCAA00, "Attackers are damaged back.");
	}

	@Override
	public void onDamageTakenWhileWearing(LivingHurtEvent event) {
		var attacker = event.getSource().getEntity();
		var player = (Player) event.getEntity();
		if (attacker != null) {
			attacker.hurt(player.damageSources().playerAttack(player), event.getAmount());
		}
	}
}
