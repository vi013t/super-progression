package violet.apeiron.data.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class NightVisionModifier extends Modifier implements ArmorModifier {

	public static final NightVisionModifier INSTANCE = new NightVisionModifier();

	private NightVisionModifier() {
		super("Night Vision", 9, 0xAAAAFF, "Allows seeing in the dark.");
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 150));
	}
}
