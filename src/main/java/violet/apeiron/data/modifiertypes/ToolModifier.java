package violet.apeiron.data.modifiertypes;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.BlockEvent.BlockToolModificationEvent;

public interface ToolModifier {
	public default void onBlockBreak(BlockEvent.BreakEvent event) {}
	public default void onRightClickBlock(BlockToolModificationEvent event) {}
}
