package violet.apeiron.item.general;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import violet.apeiron.data.ApeironAttachments;
import violet.apeiron.data.Modifier;
import violet.apeiron.item.mining.opal.OpalUtils;

/**
 * An item in the mod that can be used to apply a modifier to a tool, weapon, armor piece, etc.
 * 
 * <br></br>
 * 
 * Modifier items store a {@link violet.apeiron.data.Modifier Modifier}, which each store a numeric "tier" from 1 to 10. The tier represents the level of progression required to
 * obtain the modifier, and the modifiers themselves each represent an applicable effect, such as fire resistance, sharpness, etc.
 * 
 */
public class ModifierItem extends Item {

	/**
	 * The modifier of this modifier item. This reflects the effect of the modifier item, as well as its tier.
	 */
	public final Modifier modifier;

	/**
	 * The name of this modifier item. This is only present if the modifier is tier 10, in which case, we need the name in order to custom render it with a rainbow
	 * gradient. 
	 * 
	 * <br></br>
	 * 
	 * For all tier 10 modifier items, this is guaranteed to be present; For all others, this is guaranteed to be {@link Optional#empty()}.
	 */
	private final Optional<String> name;

	/**
	 * Creates a new tier 10 modifier item. Tier 10 modifiers must be created with this constructor that provides the name of the item, because the item names are
	 * rendered custom to make a rainbow gradient, which isn't possible with the default translation method. To create a modifier item that is not tier 10, use the
	 * {@link #ModifierItem(Modifier)} constructor, which does not take a name parameter, and uses the built-in system for item name rendering.
	 * 
	 * @param modifier The modifier of this modifier item.
	 * 
	 * @throws IllegalArgumentException If the given modifier is not tier 10.
	 */
	public ModifierItem(Modifier modifier, String name) throws IllegalArgumentException {
		super(new Item.Properties());
		if (modifier.tier != 10) {
			throw new IllegalArgumentException("Only tier 10 items can have a name");
		}
		this.modifier = modifier;
		this.name = Optional.of(name);
	}

	/**
	 * Creates a new modifier item for a modifier that is <i>not</i> tier 10. Tier 10 modifiers must be created with a separate constructor; See {@link #ModifierItem(Modifier, String)}.
	 * 
	 * @param modifier The modifier of this modifier item.
	 * 
	 * @throws IllegalArgumentException If the given modifier is tier 10.
	 */
	public ModifierItem(Modifier modifier) throws IllegalArgumentException {
		super(new Item.Properties());
		if (modifier.tier == 10) {
			throw new IllegalArgumentException("Tier 10 items must have a name");
		}
		this.modifier = modifier;
		this.name = Optional.empty();
	}

	/**
	 * Returns the default item stack instance for this item. This adds the appropriate modifier data to the item. This is used, for example, in the creative menu;
	 * Overriding this allows the items to display their modifier information in the creative menu, and other places that use the default item stack instance.
	 */
	@Override
	public ItemStack getDefaultInstance() {
		ItemStack stack = new ItemStack(this);
		stack.getData(ApeironAttachments.MODIFIER).addModifier(this.modifier);
		return stack;
	}

	/**
	 * Called every tick that the item exists in a player's inventory. This adds the appropriate modifier to the item if it's not already present.
	 * In theory, this should be handled already by {@link #getDefaultInstance()}, but it seems like that doesn't actually persist once you take the item
	 * out of the creative menu, for example. This will be called on both the logical client and server, and ensure the correct modifier is present on both.
	 * 
	 * <br></br>
	 * 
	 * This will be called automatically by Minecraft/NeoForge when appropriate, and doesn't ever need to be called manually.
	 * 
	 * @param itemStack The item stack in the player's inventory of this item.
	 * @param level The level that the update is taking place in. This should be equivalent to <code>player.level()</code>
	 * @param player The player that has the item stack in their inventory
	 * @param slotId The ID of the inventory slot that the item stack exists in
	 * @param isSelected Whether the item stack is currently selected by the player.
	 */
	@Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity player, int slotId, boolean isSelected) {
		if (!itemStack.getData(ApeironAttachments.MODIFIER).hasModifier(this.modifier)) itemStack.getData(ApeironAttachments.MODIFIER).addModifier(this.modifier);
		System.out.println((level.isClientSide ? "Client: " : "Server: ") + itemStack.getData(ApeironAttachments.MODIFIER));
    }

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {

		// Tier
		if (this.modifier.tier == 10) {
			components.clear();
			components.add(OpalUtils.colorize(this.name.get(), Style.EMPTY.withBold(true)));
			components.add(OpalUtils.colorize("Tier 10"));
		} else {
			components.add(Component.literal("Tier " + this.modifier.tier).withStyle(ChatFormatting.GRAY));
		}

		components.add(Component.literal(""));
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {

		// Shearing Modifier
		// if (stack.getData(ApeironAttachments.MODIFIER).hasModifier(Modifier.SHEARING) && entity instanceof IShearable shearableTarget) {
		// 	if (entity.level().isClientSide) {
		// 		return InteractionResult.SUCCESS;
		// 	}
		// 	BlockPos pos = BlockPos.containing(entity.position());
		// 	if (shearableTarget.isShearable(stack, entity.level(), pos)) {
		// 		List<ItemStack> drops = shearableTarget.onSheared(playerIn, stack, entity.level(), pos, stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
		// 		Random rand = new Random();
		// 		drops.forEach(drop -> {
		// 			ItemEntity itemEntity = entity.spawnAtLocation(drop, 1.0F);
		// 			double deltaX = (rand.nextFloat() - rand.nextFloat()) * 0.1F;
		// 			double deltaY = rand.nextFloat() * 0.05F;
		// 			double deltaZ = (rand.nextFloat() - rand.nextFloat()) * 0.1F;
		// 			itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add(deltaX, deltaY, deltaZ));
		// 		});
		// 		stack.hurtAndBreak(1, playerIn, event -> event.broadcastBreakEvent(hand));
		// 	}
		// 	return InteractionResult.SUCCESS;
		// }

		// No Modifier
		return InteractionResult.PASS;
	}
}
