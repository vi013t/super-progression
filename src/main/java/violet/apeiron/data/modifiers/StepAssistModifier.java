package violet.apeiron.data.modifiers;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class StepAssistModifier extends Modifier implements ArmorModifier {

	public static final StepAssistModifier INSTANCE = new StepAssistModifier();

	private StepAssistModifier() {
		super("Step Assist", 1, 0xFF7700, "Increases step height.");
	}
	
	@Override
	@SuppressWarnings("null")
	public void onWearingTick(PlayerTickEvent event) {
		event.player.getAttribute(NeoForgeMod.STEP_HEIGHT.value()).addTransientModifier(new AttributeModifier("Step Assist", 1, AttributeModifier.Operation.ADDITION));
	}
}
