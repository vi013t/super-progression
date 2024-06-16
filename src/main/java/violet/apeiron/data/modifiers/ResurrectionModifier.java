package violet.apeiron.data.modifiers;

import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class ResurrectionModifier extends Modifier implements ArmorModifier {

	public static final ResurrectionModifier INSTANCE = new ResurrectionModifier();

	private ResurrectionModifier() {
		super("Resurrection", 8, 0xFF5500, "Resurrects from death.");
	}

}
