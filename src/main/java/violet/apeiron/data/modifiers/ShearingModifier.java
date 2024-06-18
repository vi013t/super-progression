package violet.apeiron.data.modifiers;

import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ToolModifier;

public class ShearingModifier extends Modifier implements ToolModifier {

	public static final ShearingModifier INSTANCE = new ShearingModifier();

	private ShearingModifier() {
		super("Shearing", 4, 0xAAAAAA, "Allows creature shearing.");
	}

}
