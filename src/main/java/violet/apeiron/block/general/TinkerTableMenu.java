package violet.apeiron.block.general;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import violet.apeiron.data.ApeironAttachments;
import violet.apeiron.item.general.ModifierItem;

public class TinkerTableMenu extends ItemCombinerMenu {

	/**
	 * Creates a new {@link TinkerTableMenu}. This is called when the player right clicks on the tinker table block. The parameters of this are generally
	 * passed from a lambda provided to {@link net.minecraft.world.SimpleMenuProvider SimpleMenuProvider}, i.e.,
	 * 
	 * <pre>
new SimpleMenuProvider(
	(containerId, playerInventory, containerAccess) -> new TinkerTableMenu(
		containerId, playerInventory, ContainerLevelAccess.create(level, blockPosition)
	), 
	CONTAINER_TITLE
);
	 * </pre>
	 * 
	 * @param containerId The ID of the container
	 * @param playerInventory The inventory of the player that is accessing the tinker table
	 * @param containerAccess The container level access of the menu
	 */
	public TinkerTableMenu(int containerId, Inventory playerInventory, ContainerLevelAccess containerAccess) {
        super(MenuType.ANVIL, containerId, playerInventory, containerAccess);
	}

	/**
	 * Returns whether the play is allowed to pick up the item in the result slot. For example, on an anvil, this is only true when the player
	 * has enough experience to get the result item.
	 * 
	 * In the case of the Tinker Table, it is always true. The result is only generated when the combination is valid anyway; See {@link #createResult()}.
	 * 
	 * @param _player The player attempting to pick up the result.
	 */
	@Override
	protected boolean mayPickup(Player _player, boolean _hasStack) {
		return true;
	}

	/**
	 * Called when the resulting item is taken. For example, in an anvil, this checks if the anvil needs to break, and takes experience from the player.
	 */
	@Override
	protected void onTake(Player _player, ItemStack _itemStack) {
		this.deleteInputItems();
	}

	@Override
	protected boolean isValidBlock(BlockState pState) {
		return true;
	}

	/**
	 * Called when the input items change. This is used to generate the output item.
	 * 
	 * For the case of the Tinker Table, this copies the first item, and applies the modifier of the second item. This only happens when the given items create a valid
	 * combination. If they do not, such as putting blocks in or a non-modifier item in the second slot, the output item is simply left blank and none is generated.
	 */
	@Override
	public void createResult() {
		ItemStack baseItem = this.baseItem();
		ItemStack modifierItemStack = this.modifierItem();
        if (!baseItem.isEmpty() && modifierItemStack.getItem() instanceof ModifierItem modifierItem) {
			ItemStack output = baseItem.copy();
			output.getData(ApeironAttachments.MODIFIER).addModifier(modifierItem.modifier);
			this.setOutputItem(output);
		}
	}

	/**
	 * Deletes the input items in the menu. This is called when the player picks up the output item.
	 */
	private void deleteInputItems() {
		this.inputSlots.setItem(0, ItemStack.EMPTY);
		this.inputSlots.setItem(1, ItemStack.EMPTY);
	}

	/**
	 * Returns the "base item", in other words, the item stack in the first slot of the menu. This is used in {@link #createResult()} to get the input item
	 * to be modified.
	 */
	private ItemStack baseItem() {
		return this.inputSlots.getItem(0);
	}

	/**
	 * Returns the "modifier item", in other words, the item stack in the second slot of the menu. This is used in {@link #createResult()} to get the
	 * modifier item to apply to the input item.
	 * 
	 * This method has no side effects and does not mutate this menu.
	 */
	private ItemStack modifierItem() {
		return this.inputSlots.getItem(1);
	}

	/**
	 * Sets the item stack in the output slot of the item. This is used in {@link #createResult()} to set the item in the output slot, which should be
	 * the item in the input slot with the additional modifier. This method doesn't do any of that calculation, it just passes the item given into the
	 * output slot.
	 * 
	 * This method has no side effects and does not mutate this menu.
	 * 
	 * @param itemStack The item to put in the output slot.
	 */
	private void setOutputItem(ItemStack itemStack) {
		this.resultSlots.setItem(0, itemStack);
	}

	/**
	 * Uses coordinates to generate where the actual item holding slots are.
	 */
	@Override
	protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
            .withSlot(0, 27, 47, _itemStack -> true)
            .withSlot(1, 76, 47, _itemStack -> true)
            .withResultSlot(2, 134, 47)
            .build();
	}

}
