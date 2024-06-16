package violet.apeiron.data.modifiers;

import net.neoforged.neoforge.common.ToolActions;
import net.neoforged.neoforge.event.level.BlockEvent.BlockToolModificationEvent;
import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ToolModifier;

public class TillingModifier extends Modifier implements ToolModifier {
	
	public static final TillingModifier INSTANCE = new TillingModifier();

	private TillingModifier() {
		super("Tilling", 1, 0x5B3428, "Allows tilling dirt into farmland.");
	}

	@Override
	public void onRightClickBlock(BlockToolModificationEvent event) {
		event.setFinalState(event.getState().getToolModifiedState(null, ToolActions.HOE_TILL, false));
	}
}
