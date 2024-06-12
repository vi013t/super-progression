package violet.apeiron.item.general;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.item.mining.opal.OpalUtils;

public class TieredItem extends Item {

	protected final int tier;
	private final Optional<String> name;

	public TieredItem(int tier, String name) {
		super(new Item.Properties());
		this.tier = tier;
		this.name = Optional.of(name);
	}

	public TieredItem(int tier) throws IllegalArgumentException {
		super(new Item.Properties());
		this.tier = tier;
		this.name = Optional.empty();
		if (tier == 10)
			throw new IllegalArgumentException("Tier 10 items must have a name");
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		if (tier <= 2)
			return Rarity.COMMON;
		if (tier <= 5)
			return Rarity.UNCOMMON;
		if (tier <= 7)
			return Rarity.RARE;
		return Rarity.EPIC;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		if (this.tier == 10) {
			components.clear();
			components.add(OpalUtils.colorize(this.name.get(), Style.EMPTY.withBold(true)));
			components.add(OpalUtils.colorize("Tier 10"));
			return;
		}
		components.add(Component.literal("Tier " + tier));
	}
}