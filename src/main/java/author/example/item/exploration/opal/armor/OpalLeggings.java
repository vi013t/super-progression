package author.example.item.exploration.opal.armor;

import java.util.List;

import javax.annotation.Nullable;

import author.example.item.exploration.opal.OpalUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class OpalLeggings extends ArmorItem {
	
	public OpalLeggings() {
		super(OpalArmorMaterial.INSTANCE, Type.HELMET, new Item.Properties());
	}

	@Override  
    public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
    }

	@Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.clear();
		components.add(OpalUtils.colorize("Opal Helmet", Style.EMPTY.withBold(true)));
		components.add(OpalUtils.colorize("Tier 10"));
    }
}
