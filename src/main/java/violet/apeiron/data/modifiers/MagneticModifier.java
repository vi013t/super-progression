package violet.apeiron.data.modifiers;

import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class MagneticModifier extends Modifier implements ArmorModifier {

	public static final MagneticModifier INSTANCE = new MagneticModifier();

	private MagneticModifier() {
		super("Magnetic", 4, 0xFF4444, "Nearby items are attracted.");
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		var items = event.player.level().getEntitiesOfClass(ItemEntity.class, event.player.getBoundingBox().inflate(5));
		for (var item : items) {
			item.setDeltaMovement(event.player.position().subtract(item.position()));
		} 		
	}
}
