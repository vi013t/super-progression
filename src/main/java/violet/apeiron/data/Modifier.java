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
import violet.apeiron.data.modifiers.ShearingModifier;
import violet.apeiron.data.modifiers.SpeedSwimModifier;
import violet.apeiron.data.modifiers.StepAssistModifier;
import violet.apeiron.data.modifiers.ThornsModifier;
import violet.apeiron.data.modifiers.TillingModifier;

/**
 * A "modifier" for a tool, weapon, armor, etc. Modifiers make up the core of Apeiron's progression system. Modifiers can be applied to items to enhance their effects. Most modifiers
 * are miscellaneous effects such as fire resistance, water breathing, flight, etc. Some modifiers, which we call "core modifiers" make up the main utililty of an item &mdash; Specifically,
 * sharpness, protection, efficiency, and durability are the core modifiers. These are the modifiers that are the most powerful and can be applied to the most items, and are much harder
 * to obtain.
 * 
 * <br></br>
 * 
 * Modifiers are attached to item stacks via the <a href="https://docs.neoforged.net/docs/datastorage/attachments">Data Attachment API</a>, i.e.,
 * 
 * <br></br>
 * 
 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.AUTO_SMELT)</pre>
 */
public class Modifier {

	/**
	 * The {@link AutoSmeltModifier} instance. This field references the same value as {@link AutoSmeltModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to tools, and makes it so that blocks broken by the tool drop their "smelted version" if possible &mdash; for example, when breaking cobblestone
	 * with a tool with auto-smelt, it will drop stone, because cobblestone smelts into stone. When breaking dirt with the same tool, it will simply drop dirt, because dirt cannot
	 * be smelted.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(AutoSmeltModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.AUTO_SMELT)</pre>
	 */
	public static final AutoSmeltModifier AUTO_SMELT = AutoSmeltModifier.INSTANCE;

	/**
	 * The {@link ChargedModifier} instance. This field references the same value as {@link ChargedModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to melee weapons, and makes it so that enemies hit have a chance to be struck by lightning. The lightning will not damage the player. This
	 * is a tier 2 modifier, and thus can be obtained relatively early; This should be balanced appropriately to account for this. This modifier can be obtained via the
	 * {@link violet.apeiron.item.ApeironItems#ELECTRIO Electrio} item, which is the tier 2 item of the magic path.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(ChargedModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.CHARGED)</pre>
	 */
	public static final ChargedModifier CHARGED = ChargedModifier.INSTANCE;

	/**
	 * The {@link FireResistanceModifier} instance. This field references the same value as {@link FireResistanceModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to armor, and makes it so that the player is immune to fire and lava damage. This is a tier 8 modifier, so it takes quite a long time to obtain this. This
	 * modifier can be obtained via the {@link violet.apeiron.item.ApeironItems#FLARIO Flario} item, which is the tier 8 item of the magic path.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(ChargedModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.FIRE_RESISTANCE)</pre>
	 */
	public static final FireResistanceModifier FIRE_RESISTANCE = FireResistanceModifier.INSTANCE;

	/**
	 * The {@link FlightModifier} instance. This field references the same value as {@link FlightModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to armor, and makes it so that the player is able to fly. This is a tier 10 modifier, so it is only obtainable at the end of progression.
	 * This modifier can be obtained via the {@link violet.apeiron.item.ApeironItems#DRAGON_SCALE DragonScale} item, which is the tier 10 item of the "boss" path.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(FlightModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.FLIGHT)</pre>
	 */
	public static final FlightModifier FLIGHT = FlightModifier.INSTANCE;

	/**
	 * The {@link HealingModifier} instance. This field references the same value as {@link HealingModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to weapons, and makes it so that attacks with the weapon will heal the target instead of damaging it. This is a tier 3 modifier, so it can
	 * be obtained relatively early. This modifier can be obtained via the {@link violet.apeiron.item.ApeironItems#VITALIO Vitalio} item, which is the tier 3 item of the "magic" path.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(HealingModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.HEALING)</pre>
	 */
	public static final HealingModifier HEALING = HealingModifier.INSTANCE;

	/**
	 * The {@link LimitlessModifier} instance. This field references the same value as {@link LimitlessModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to armor, and makes it so that the closer entities are to the player, the slower they move, until ultimately they can never reach the player. 
	 * This includes hostile mobs, but also projectiles such as fireballs and arrows. This is a tier 10 modifier, meaning it can only be obtained at the very end of the progression, 
	 * and rightfully so, because it makes it basically impossible to take any damage (only non-entity related damage can be taken, such as lava, fall damage, etc.). This modifier 
	 * can be obtained via the {@link violet.apeiron.item.ApeironItems#INFINIO Infinio} item, which is the tier 10 item in the magic path.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(LimitlessModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.LIMITLESS)</pre>
	 */
	public static final LimitlessModifier LIMITLESS = LimitlessModifier.INSTANCE;

	/**
	 * The {@link MagneticModifier} instance. This field references the same value as {@link MagneticModifier#INSTANCE}, and referencing these two fields are exactly equivalent.
	 * This modifier can be applied to armor, and makes it so that the wearer of the armor "attracts" dropped items &mdash; Items dropped on the ground within a certain radius
	 * will be pulled towards the player. This is a tier 4 modifier, so it can be obtained roughly halfway through the progression.
	 * 
	 * This modifier can be added to an item stack with either:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(MagneticModifier.INSTANCE)</pre>
	 * 
	 * <br></br>
	 * 
	 * or, perhaps more readably:
	 * 
	 * <br></br>
	 * 
	 * <pre>itemStack.getData(ApeironAttachments.MODIFIER).addModifier(Modifier.MAGNETIC)</pre>
	 */
	public static final MagneticModifier MAGNETIC = MagneticModifier.INSTANCE;
	public static final NightVisionModifier NIGHT_VISION = NightVisionModifier.INSTANCE;
	public static final ProtectionModifier PROTECTION = ProtectionModifier.INSTANCE;
	public static final RadioactiveModifier RADIOACTIVE = RadioactiveModifier.INSTANCE;
	public static final ResurrectionModifier RESURRECTION = ResurrectionModifier.INSTANCE;
	public static final SharpnessModifier SHARPNESS = SharpnessModifier.INSTANCE;
	public static final ShearingModifier SHEARING = ShearingModifier.INSTANCE;
	public static final SpeedSwimModifier SPEED_SWIM = SpeedSwimModifier.INSTANCE;
	public static final StepAssistModifier STEP_ASSIST = StepAssistModifier.INSTANCE;
	public static final ThornsModifier THORNS = ThornsModifier.INSTANCE;
	public static final TillingModifier TILLING = TillingModifier.INSTANCE;

	/**
	 * The name of this modifier. This is the name displayed to the user, so it should be a human-readable string.
	 */
	public final String name;

	/**
	 * The description of this modifier. This is the description displayed to the user, so it should be a human-readable string. This description is displayed
	 * on a single line on item tooltips, so it should be as short as possible.
	 */
	public final String description;

	/**
	 * The tier of this modifier. This should be a number between 1 and 10, inclusive. This represents the level of progression required to obtain the modifier
	 * and the item that grants the modifier.
	 */
	public final int tier;

	/**
	 * The color of this modifier. This is the color that will be displayed on item tooltips. This should be passed as a hexidecimal number, for example,
	 * 0x4A08A9.
	 */
	public final int color;

	/**
	 * Creates a new `Modifier`. This should only be called by subclasses, which should each be singletons.
	 * 
	 * @param name The name of this modifier. This is the name displayed to the user, so it should be a human-readable string.
	 * @param tier The tier of this modifier. This should be a number between 1 and 10, inclusive, and it represents how late into the progression the modifier can be obtained. Thus,
	 * it should also represent how "good" the modifier is.
	 * @param color The color of this modifier. This is the color that will be displayed on item tooltips. This should be passed as a hexidecimal number, for example, 0x4A08A9. Please
	 * keep in mind that this will be displayed on the item tooltip background, which is generally black. Take care to make this a relatively bright color that can be read on a black
	 * background. Ideally, comply with <a href="https://www.w3.org/WAI/WCAG21/Understanding/contrast-minimum">WCAG Success Criterion 1.4.3 defining minimum contrast</a> with black.
	 * @param description The description of this modifier. This is the description displayed to the user, so it should be a human-readable string. This description is displayed
	 * on a single line on item tooltips, so it should be as short as possible.
	 */
	protected Modifier(String name, int tier, int color, String description) {
		this.name = name;
		this.description = description;
		this.tier = tier;
		this.color = color;
	}
}
