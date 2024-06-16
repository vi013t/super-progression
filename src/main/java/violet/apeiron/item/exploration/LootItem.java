package violet.apeiron.item.exploration;

import net.minecraft.world.item.Item;

public class LootItem extends Item {

	private final Rarity rarity;

	public LootItem(Rarity rarity) {
		super(new Item.Properties());
		this.rarity = rarity;
	}
	
	public enum Rarity {
		COMMON,
		UNCOMMON,
		RARE,
		EPIC,
		LEGENDARY
	}
}
