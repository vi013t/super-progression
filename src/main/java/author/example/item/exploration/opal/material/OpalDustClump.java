package author.example.item.exploration.opal.material;

import java.util.List;

import javax.annotation.Nullable;

import author.example.item.exploration.opal.OpalUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class OpalDustClump extends Item {

	public OpalDustClump() {
		super(new Item.Properties());
	}

	@Override
    public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
    }

	@Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.clear();
		components.add(OpalUtils.colorize("Opal Dust Clump", Style.EMPTY.withBold(true)));
    }
}
