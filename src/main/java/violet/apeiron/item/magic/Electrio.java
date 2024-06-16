package violet.apeiron.item.magic;

import java.util.List;

import javax.annotation.Nullable;

import org.checkerframework.checker.nullness.qual.NonNull;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import violet.apeiron.data.Modifier;
import violet.apeiron.item.general.ArmorPlate;

public class Electrio extends ArmorPlate {

	public Electrio() {
		super(Modifier.CHARGED);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		BlockPos blockPlacePosition = context.getClickedPos().offset(context.getClickedFace().getNormal());
		if (context.getLevel().isEmptyBlock(blockPlacePosition) && context.getLevel().getBlockState(blockPlacePosition.below()).isSolidRender(context.getLevel(), blockPlacePosition.below())) {
			context.getItemInHand().shrink(1);
			LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, context.getLevel());
			lightning.setPos(blockPlacePosition.getX(), blockPlacePosition.getY(), blockPlacePosition.getZ());
			context.getLevel().addFreshEntity(lightning);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	/**
	 * Called when the player uses the item on an entity. For vitalio, this heals the entity.
	 */
	@Override
	public @NonNull InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
		if (entity instanceof Creeper creeper && creeper.level() instanceof ServerLevel level) {
			creeper.thunderHit(level, new LightningBolt(EntityType.LIGHTNING_BOLT, level));
			creeper.extinguishFire();
			stack.shrink(1);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, world, components, isAdvanced);
		if (Screen.hasShiftDown()) {
			components.add(Component.literal("").withStyle(Style.EMPTY.withColor(0xFFFF00)));
			components.add(Component.literal("Pure concentrated electricity essence.").withStyle(Style.EMPTY.withColor(0xFFFF00)));
		} else {
			components.add(Component.literal("Hold SHIFT for more information").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
		}
	}
}
