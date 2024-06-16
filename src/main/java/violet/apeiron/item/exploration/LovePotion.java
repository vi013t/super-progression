package violet.apeiron.item.exploration;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * The "Love Potion" is an uncraftable item that can be found in loot chests. It allows the player to breed animals without any items.
 */
public class LovePotion extends Item{

	public LovePotion() {
		super(new Item.Properties());
	}

	/**
	 * Called when the player uses the item on a block. For Infinio, this duplicates
	 * the entity, and consumes one item in the stack.
	 */
	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
		return InteractionResult.SUCCESS;
	}

}
