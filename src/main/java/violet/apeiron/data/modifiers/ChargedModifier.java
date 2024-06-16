package violet.apeiron.data.modifiers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.WeaponModifier;

public class ChargedModifier extends Modifier implements WeaponModifier {

	public static final ChargedModifier INSTANCE = new ChargedModifier();

	private ChargedModifier() {
		super("Charged", 2, 0xFFFF88, "Entities attacked are struck by lightning.");
	}

	@Override
	public void onAttack(AttackEntityEvent event) {
		var position = new BlockPos((int) event.getTarget().position().x, (int) event.getTarget().position().y, (int) event.getTarget().position().z);
		LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, event.getEntity().level());
		lightning.setPos(position.getX(), position.getY(), position.getZ());
		event.getEntity().level().addFreshEntity(lightning);
	}
}
