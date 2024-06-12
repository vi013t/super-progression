package violet.apeiron.item.general;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.IShearable;
import violet.apeiron.data.ApeironAttachments;
import violet.apeiron.data.Modifier;
import violet.apeiron.item.mining.opal.OpalUtils;

public class ArmorPlate extends Item {

	private final Modifier modifier;
	private final int tier;
	private final Optional<String> name;

	public ArmorPlate(Modifier modifier, int tier, String name) throws IllegalArgumentException {
		super(new Item.Properties());
		if (tier != 10) {
			throw new IllegalArgumentException("Only tier 10 items can have a name");
		}
		this.modifier = modifier;
		this.tier = tier;
		this.name = Optional.of(name);
	}

	public ArmorPlate(Modifier modifier, int tier) throws IllegalArgumentException {
		super(new Item.Properties());
		if (tier == 10) {
			throw new IllegalArgumentException("Tier 10 items must have a name");
		}
		this.modifier = modifier;
		this.tier = tier;
		this.name = Optional.empty();
	}

	@Override
	public ItemStack getDefaultInstance() {
		ItemStack stack = new ItemStack(this);
		stack.getData(ApeironAttachments.MODIFIER).addModifier(this.modifier, this.tier);
		return stack;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (!stack.getData(ApeironAttachments.MODIFIER).hasModifier(modifier)) {
			stack.getData(ApeironAttachments.MODIFIER).addModifier(modifier, this.tier);
		}
	}

	@Override
	@SuppressWarnings("null")
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		if (this.tier == 10) {
			components.clear();
			components.add(OpalUtils.colorize(this.name.get(), Style.EMPTY.withBold(true)));
			components.add(OpalUtils.colorize("Tier 10"));
			return;
		}
		components.add(Component.literal("Tier " + tier).withStyle(ChatFormatting.GRAY));
		for (var modifierEntry : stack.getData(ApeironAttachments.MODIFIER).modifierEntries()) {
			components.add(Component.literal(modifierEntry.getKey().getName()).withColor(modifierEntry.getKey().getColor()));
		}
	}

	@Override
	@SuppressWarnings({ "null", "resource" })
	public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
		System.out.println(stack.getData(ApeironAttachments.MODIFIER).modifierEntries().toString());
		if (stack.getData(ApeironAttachments.MODIFIER).hasModifier(Modifier.SHEARING) && entity instanceof IShearable shearableTarget) {
			if (entity.level().isClientSide) {
				return InteractionResult.SUCCESS;
			}
			BlockPos pos = BlockPos.containing(entity.position());
			if (shearableTarget.isShearable(stack, entity.level(), pos)) {
				List<ItemStack> drops = shearableTarget.onSheared(playerIn, stack, entity.level(), pos, stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
				Random rand = new Random();
				drops.forEach(drop -> {
					ItemEntity itemEntity = entity.spawnAtLocation(drop, 1.0F);
					double deltaX = (rand.nextFloat() - rand.nextFloat()) * 0.1F;
					double deltaY = rand.nextFloat() * 0.05F;
					double deltaZ = (rand.nextFloat() - rand.nextFloat()) * 0.1F;
					itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add(deltaX, deltaY, deltaZ));
				});
				stack.hurtAndBreak(1, playerIn, event -> event.broadcastBreakEvent(hand));
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
