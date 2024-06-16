package violet.apeiron.data.modifiers;

import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class RadioactiveModifier extends Modifier implements ArmorModifier {

	public static final RadioactiveModifier INSTANCE = new RadioactiveModifier();

	private RadioactiveModifier() {
		super("Radioactive", 3, 0xAAFF00, "Passively damages nearby enemies.");
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		var entities = event.player.level().getEntities(event.player, event.player.getBoundingBox().inflate(10));
		for (var entity : entities) {
			if (event.player.level().getGameTime() % 60 == 0) {
				entity.hurt(event.player.damageSources().playerAttack(event.player), 1);
			}
		} 		
	}

}
