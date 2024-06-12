package violet.apeiron.item.mining.opal.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class OpalArmorMaterial implements ArmorMaterial {

	public static final OpalArmorMaterial INSTANCE = new OpalArmorMaterial();

	@Override
	public int getDurabilityForType(Type pType) {
		return -1;
	}

	@Override
	public int getDefenseForType(Type pType) {
		return Integer.MAX_VALUE;
	}

	@Override
	public int getEnchantmentValue() {
		return 0;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}

	@Override
	public String getName() {
		return "Opal";
	}

	@Override
	public float getToughness() {
		return Integer.MAX_VALUE;
	}

	@Override
	public float getKnockbackResistance() {
		return Integer.MAX_VALUE;
	}
	
}
