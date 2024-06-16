package violet.apeiron.item.general;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
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

public class ArmorPlate extends Item {

	private final Modifier modifier;
	private final Optional<String> name;

	public ArmorPlate(Modifier modifier, String name) throws IllegalArgumentException {
		super(new Item.Properties());
		if (modifier.tier != 10) {
			throw new IllegalArgumentException("Only tier 10 items can have a name");
		}
		this.modifier = modifier;
		this.name = Optional.of(name);
	}

	public ArmorPlate(Modifier modifier) throws IllegalArgumentException {
		super(new Item.Properties());
		if (modifier.tier == 10) {
			throw new IllegalArgumentException("Tier 10 items must have a name");
		}
		this.modifier = modifier;
		this.name = Optional.empty();
	}

	@Override
	public ItemStack getDefaultInstance() {
		ItemStack stack = new ItemStack(this);
		stack.getData(ApeironAttachments.MODIFIER).addModifier(this.modifier, this.modifier.tier);
		return stack;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (!stack.getData(ApeironAttachments.MODIFIER).hasModifier(modifier)) {
			stack.getData(ApeironAttachments.MODIFIER).addModifier(modifier, this.modifier.tier);
		}
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

		// Modifiers
		components.add(Component.literal("Modifiers:"));
		for (var modifierEntry : stack.getData(ApeironAttachments.MODIFIER).modifierEntries()) {
			MutableComponent component;
			if (this.modifier.tier == 10) component = OpalUtils.colorize("    " + modifierEntry.getKey().name);
			else component = Component.literal("    " + modifierEntry.getKey().name).withColor(modifierEntry.getKey().color);

			if (Screen.hasShiftDown()) {
				component.append(Component.literal(" - " + modifierEntry.getKey().description).withStyle(ChatFormatting.DARK_GRAY));
			}
			components.add(component);
		}

		// Shift Info
		if (!Screen.hasShiftDown()) {
			components.add(Component.literal(""));
			components.add(Component.literal("Hold SHIFT for more information...").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true)));
		}
	}

	@Override
	@SuppressWarnings({ "null", "resource" })
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
