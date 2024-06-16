package violet.apeiron.data.modifiers;

import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class FlightModifier extends Modifier implements ArmorModifier {

	public static final FlightModifier INSTANCE = new FlightModifier();

	private FlightModifier() {
		super("Flight", 10, 0xAACCFF, "Grants the ability to fly.");
	}

}
