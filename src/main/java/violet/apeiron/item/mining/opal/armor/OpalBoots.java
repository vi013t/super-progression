package violet.apeiron.item.mining.opal.armor;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.item.mining.opal.OpalUtils;

public class OpalBoots extends ArmorItem {
	
	public OpalBoots() {
		super(OpalArmorMaterial.INSTANCE, Type.HELMET, new Item.Properties());  
	}

	@Override
    public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
    }

	@Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.clear();
		components.add(OpalUtils.colorize("Opal Chestplate", Style.EMPTY.withBold(true)));
		components.add(OpalUtils.colorize("Tier 10"));
    }
}
