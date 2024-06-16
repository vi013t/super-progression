package violet.apeiron.item.boss;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import violet.apeiron.data.Modifier;
import violet.apeiron.item.general.TieredArmorItem;

public class CyclopsEye extends TieredArmorItem {
	
	public CyclopsEye() {
		super(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, Modifier.NIGHT_VISION);
	}
}
