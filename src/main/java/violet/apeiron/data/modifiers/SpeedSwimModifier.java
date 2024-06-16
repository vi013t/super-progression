package violet.apeiron.data.modifiers;

import violet.apeiron.data.Modifier;
import violet.apeiron.data.modifiertypes.ArmorModifier;

public class SpeedSwimModifier extends Modifier implements ArmorModifier {

	public static final SpeedSwimModifier INSTANCE = new SpeedSwimModifier();

	private SpeedSwimModifier() {
		super("Speed Swim", 5, 0x0033FF, "Increases swim speed.");
	}

}
