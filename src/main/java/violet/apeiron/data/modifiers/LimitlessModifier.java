package violet.apeiron.data.modifiers;

import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class LimitlessModifier extends Modifier implements ArmorModifier {

	public static final LimitlessModifier INSTANCE = new LimitlessModifier();

	private LimitlessModifier() {
		super("Limitless", 10, 0x000000, "Entities move slower the closer they are.");
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		var entities = event.player.level().getEntities(event.player, event.player.getBoundingBox().inflate(5));
		for (var entity : entities) {
			double distance = event.player.position().distanceTo(entity.position());
			if (distance < 5) {
				entity.setDeltaMovement(entity.getDeltaMovement().scale(distance / 5));
			}
		} 		
	}
}
