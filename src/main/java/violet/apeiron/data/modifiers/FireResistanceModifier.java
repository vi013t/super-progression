package violet.apeiron.data.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class FireResistanceModifier extends Modifier implements ArmorModifier {

	public static final FireResistanceModifier INSTANCE = new FireResistanceModifier();

	private FireResistanceModifier() {
		super("Fire Resistance", 8, 0xFF6655, "Grants immunity to fire damage.");
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 150));
	}
}
