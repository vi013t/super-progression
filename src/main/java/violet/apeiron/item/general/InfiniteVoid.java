package violet.apeiron.item.general;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import violet.apeiron.item.util.EventReceiver;

public class InfiniteVoid extends Item implements EventReceiver {

	public InfiniteVoid() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> components, TooltipFlag isAdvanced) {
		components.clear();
		components.add(Component.translatable("item.example.limitless").withStyle(Style.EMPTY.withBold(true).withColor(0xAAAAFF)));
		components.add(Component.literal(""));
		components.add(Component.literal("What do you think happens").withStyle(ChatFormatting.GRAY));
		components.add(Component.literal("when one touches the void?").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public void onInventoryTick(PlayerTickEvent event) {
		var entities = event.player.level().getEntities(event.player, event.player.getBoundingBox().inflate(5));
		for (var entity : entities) {
			double distance = event.player.position().distanceTo(entity.position());
			if (distance < 5) {
				entity.setDeltaMovement(entity.getDeltaMovement().scale(distance / 5));
			}
		} 		
	}

}
