package violet.apeiron.data;

import java.util.Arrays;

public enum Modifier {

	/**
	 * The air affinity modifier, which removes the block breaking speed penalty when in the air. This can be applied to helmets.
	 */
	AIR_AFFINITY("Air Affinity", 0xAACCFF, Type.HELMET),

	/**
	 * The aqua affinity modifier, which increases the block breaking speed when underwater. This can be applied to helmets.
	 */
	AQUA_AFFINITY("Aqua Affinity", 0x55FFFF, Type.HELMET),

	/**
	 * The dousing modifier, which extinguishes entities from fire. This can be applied to tools and weapons.
	 */
	DOUSING("Dousing", 0x4444FF, Type.TOOL, Type.WEAPON),

	/**
	 * The durability modifier, which increases the durability of the item. This can be applied to tools, weapons, and armor.
	 */
	DURABILITY("Durability", 0x00BBBB, Type.ALL),

	/**
	 * The Limitless modifier. This modifier makes it so that entities move slower the closer they get to the player, and they will never make contact with the player.
	 * This includes, mobs, projectiles, everything. This modifier is granted by Infinio.
	 */
	LIMITLESS("Limitless", 0xAAAAFF, Type.ARMOR),

	/**
	 * The fire resistance modifier, which reduces damage taken from fire. This can be applied to armor.
	 */
	FIRE_RESISTANCE("Fire Resistance", 0xFF6655, Type.ARMOR),

	FLIGHT("Flight", 0xAACCFF, Type.CHESTPLATE),

	FORTUNE("Fortune", 0x00FFFF, Type.PICKAXE),

	/**
	 * The healing modifier, which heals entities instead of hurting them. This can be applied to tools and weapons, and can be
	 * applied with {@link violet.apeiron.item.ApeironItems#VITALIO Vitalio}.
	 */
	HEALING("Healing", 0x55FF55, Type.TOOL, Type.WEAPON),

	MAGNETIC("Magnetic", 0xFF4444, Type.TOOL),

	/**
	 * The protection modifier, which reduces damage taken. This can be applied to armor, and can be applied with armor plates of any
	 * tier.
	 */
	PROTECTION("Protection", 0xFF88CC, Type.ARMOR),

	/**
	 * The sharpness modifier, which increases damage dealt. This can be applied to tools and weapons.
	 */
	SHARPNESS("Sharpness", 0x5555FF, Type.WEAPON, Type.TOOL), WATER_BREATHING("Water Breathing", 0x3388FF, Type.HELMET),

	SHEARING("Shearing", 0xAAAAAA, Type.SHEARS),

	SILK_TOUCH("Silk Touch", 0xFFFFAA, Type.TOOL),

	STEP_ASSIST("Step Assist", 0xFF7700, Type.BOOTS);

	private final Type[] applicableTypes;
	private final String name;
	private final int color;

	/**
	 * Creates a new modifier which can be applied to the given types.
	 * 
	 * @param applicableTypes The types which this can be applied to.
	 */
	private Modifier(String name, int color, Type... applicableTypes) {
		this.applicableTypes = applicableTypes;
		this.name = name;
		this.color = color;
	}

	/**
	 * Returns an array of types that this modifier can be applied to. Note that this returns a clone of the stored array, so any
	 * modifications to this will not affect the modifier. If you'd like to check if a type can be applied to this, you should be
	 * careful using this method, because for example a modifier that can be applied to a pickaxe, might only have `Type.TOOL` in it's
	 * applicable type list, and not `Type.PICKAXE` itself. For this functionalty, it is recommended to use
	 * {@link #canBeAppliedTo(Type)}.
	 * 
	 * @return The types which this can be applied to.
	 */
	public Type[] getApplicableTypes() {
		return this.applicableTypes.clone();
	}

	public String getName() {
		return this.name;
	}

	public int getColor() {
		return this.color;
	}

	/**
	 * Returns whether this modifier can be applied to the given type. This will return true if the type is directly contained within
	 * this modifier's applicable types, or if the applicable types contains a superset, such as `Types.TOOL` for a pickaxe.
	 * 
	 * @param type The type to check if this can be applied to.
	 * 
	 * @return Whether this can be applied to the given type.
	 */
	public boolean canBeAppliedTo(Type type) {
		// Exact match
		if (Arrays.asList(this.applicableTypes).contains(type)) {
			return true;
		}

		// All
		if (Arrays.asList(this.applicableTypes).contains(Type.ALL)) {
			return true;
		}

		// Tools
		if (type == Type.AXE || type == Type.PICKAXE || type == Type.SHOVEL || type == Type.HOE) {
			return Arrays.asList(this.applicableTypes).contains(Type.TOOL);
		}

		// Weapon
		if (type == Type.SWORD) {
			return Arrays.asList(this.applicableTypes).contains(Type.WEAPON);
		}

		// Armor
		if (type == Type.HELMET || type == Type.CHESTPLATE || type == Type.LEGGINGS || type == Type.BOOTS) {
			return Arrays.asList(this.applicableTypes).contains(Type.ARMOR);
		}

		return false;
	}

	/**
	 * A type of equipment which modifiers can be applied to.
	 */
	public static enum Type {
		ALL, ARMOR, TOOL, SWORD, HELMET, CHESTPLATE, LEGGINGS, BOOTS, AXE, PICKAXE, SHOVEL, HOE, SHEARS, WEAPON
	}
}
