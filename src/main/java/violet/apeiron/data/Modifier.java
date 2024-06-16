package violet.apeiron.data;

import violet.apeiron.data.modifiers.AutoSmeltModifier;
import violet.apeiron.data.modifiers.ChargedModifier;
import violet.apeiron.data.modifiers.FireResistanceModifier;
import violet.apeiron.data.modifiers.FlightModifier;
import violet.apeiron.data.modifiers.HealingModifier;
import violet.apeiron.data.modifiers.LimitlessModifier;
import violet.apeiron.data.modifiers.MagneticModifier;
import violet.apeiron.data.modifiers.NightVisionModifier;
import violet.apeiron.data.modifiers.ProtectionModifier;
import violet.apeiron.data.modifiers.RadioactiveModifier;
import violet.apeiron.data.modifiers.ResurrectionModifier;
import violet.apeiron.data.modifiers.SharpnessModifier;
import violet.apeiron.data.modifiers.SpeedSwimModifier;
import violet.apeiron.data.modifiers.StepAssistModifier;
import violet.apeiron.data.modifiers.ThornsModifier;
import violet.apeiron.data.modifiers.TillingModifier;

public class Modifier {

	public static final AutoSmeltModifier AUTO_SMELT = AutoSmeltModifier.INSTANCE;
	public static final ChargedModifier CHARGED = ChargedModifier.INSTANCE;
	public static final FireResistanceModifier FIRE_RESISTANCE = FireResistanceModifier.INSTANCE;
	public static final FlightModifier FLIGHT = FlightModifier.INSTANCE;
	public static final HealingModifier HEALING = HealingModifier.INSTANCE;
	public static final LimitlessModifier LIMITLESS = LimitlessModifier.INSTANCE;
	public static final MagneticModifier MAGNETIC = MagneticModifier.INSTANCE;
	public static final NightVisionModifier NIGHT_VISION = NightVisionModifier.INSTANCE;
	public static final ProtectionModifier PROTECTION = ProtectionModifier.INSTANCE;
	public static final RadioactiveModifier RADIOACTIVE = RadioactiveModifier.INSTANCE;
	public static final ResurrectionModifier RESURRECTION = ResurrectionModifier.INSTANCE;
	public static final SharpnessModifier SHARPNESS = SharpnessModifier.INSTANCE;
	public static final SpeedSwimModifier SPEED_SWIM = SpeedSwimModifier.INSTANCE;
	public static final StepAssistModifier STEP_ASSIST = StepAssistModifier.INSTANCE;
	public static final ThornsModifier THORNS = ThornsModifier.INSTANCE;
	public static final TillingModifier TILLING = TillingModifier.INSTANCE;

	public final String name;
	public final String description;
	public final int tier;
	public final int color;

	protected Modifier(String name, int tier, int color, String description) {
		this.name = name;
		this.description = description;
		this.tier = tier;
		this.color = color;
	}
}
