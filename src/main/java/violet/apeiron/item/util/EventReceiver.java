package violet.apeiron.item.util;

import org.checkerframework.checker.nullness.qual.NonNull;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;

public interface EventReceiver {

	/**
	 * Called every tick if this item is in the players inventory.
	 * 
	 * @param event The event fired by forge
	 */
	public default void onInventoryTick(@NonNull PlayerTickEvent event) {}

	/**
	 * Called every tick if the player is wearing this item.
	 * 
	 * @param event The event fired by forge
	 */
	public default void onArmorTick(PlayerTickEvent event, ItemStack stack) {}
}
