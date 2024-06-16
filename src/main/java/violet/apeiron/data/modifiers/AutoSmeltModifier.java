package violet.apeiron.data.modifiers;

import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ToolModifier;

public class AutoSmeltModifier extends Modifier implements ToolModifier {

	public static final AutoSmeltModifier INSTANCE = new AutoSmeltModifier();

	private AutoSmeltModifier() {
		super("Auto-Smelt", 8, 0xFFAA00, "Automatically smelts blocks broken.");
	}
}
