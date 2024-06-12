package violet.apeiron.item.boss;

import java.util.List;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.IShearable;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.item.util.EventReceiver;

public class KarkinosClaw extends SwordItem implements EventReceiver{

	public KarkinosClaw() {
		super(Tiers.NETHERITE, 3, 1, new Properties());
	}

	@Override
	@SuppressWarnings({ "null", "resource" })
	public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
		if (entity instanceof IShearable shearableTarget) {
			if (entity.level().isClientSide)
				return InteractionResult.SUCCESS;
			BlockPos pos = BlockPos.containing(entity.position());
			if (shearableTarget.isShearable(stack, entity.level(), pos)) {
				List<ItemStack> drops = shearableTarget.onSheared(playerIn, stack, entity.level(), pos, stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
				Random rand = new Random();
				drops.forEach(drop -> {
					ItemEntity itemEntity = entity.spawnAtLocation(drop, 1.0F);
					itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double) (rand.nextFloat() * 0.05F),
							(double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
				});
				stack.hurtAndBreak(1, playerIn, event -> event.broadcastBreakEvent(hand));
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	public void onArmorTick(PlayerTickEvent event, ItemStack armorItem) {
		// Aqua Affinity
		if (!armorItem.getAllEnchantments().containsKey(Enchantments.AQUA_AFFINITY)) {
			armorItem.enchant(Enchantments.AQUA_AFFINITY, 1);
		}

		// Dolphin's Grace & Water Breathing
		event.player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 250, 19));
		event.player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 250, 0));

		// Night Vision
		if (event.player.isInWater()) {
			event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 250, 0));
		} else {
			event.player.removeEffect(MobEffects.NIGHT_VISION);
		}
	}
}