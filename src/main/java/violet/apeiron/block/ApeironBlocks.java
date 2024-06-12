package violet.apeiron.block;

import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import violet.apeiron.Apeiron;
import violet.apeiron.block.exploration.OpalOre;
import violet.apeiron.block.exploration.OpalOreItem;
import violet.apeiron.block.general.TinkerTable;
import violet.apeiron.item.ApeironItems;

/**
 * Utility class for handling blocks in the Spacial & Temporal Rending mod. This class handles the instantiation of all blocks,
 * all of which can be retrieved as fields of this class, as well as registering all the blocks via the
 * {@link #register(IEventBus)} method which should be called in the {@link Apeiron main} class's constructor with the given
 * {@link IEventBus} from NeoForge.
 */
public class ApeironBlocks {

	/** The register for all blocks in the mod. */
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Apeiron.MODID);

	public static final DeferredBlock<OpalOre> OPAL_ORE = blockWithItem("opal_ore", OpalOre::new, OpalOreItem::new);
	public static final DeferredBlock<TinkerTable> TINKER_TABLE = blockWithItem("tinker_table", TinkerTable::new);

	/** The register for all block entities in the mod */
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Apeiron.MODID);

	/**
	 * Registers the modded blocks into the registry, and adds event listeners onto this class.
	 *
	 * @param eventBus The event bus to register with.
	 */
	public static void register(IEventBus eventBus) {
		ApeironBlocks.BLOCKS.register(eventBus);
		ApeironBlocks.BLOCK_ENTITIES.register(eventBus);
	}

	/**
	 * Creates and returns a block, while also registering an item for it.
	 *
	 * @param <T>      The type of block to create
	 * 
	 * @param name     The name of the block and item in the registries; This must be unique for each block, and the corresponding
	 *                 `BlockItem` will be registered with the same name.
	 * @param supplier A supplier that returns a new instance of the block each time it is called.
	 *
	 * @return The created block
	 */
	private static <T extends Block> DeferredBlock<T> blockWithItem(String name, Supplier<T> supplier) {
		DeferredBlock<T> registryBlock = BLOCKS.register(name, supplier);
		ApeironItems.ITEMS.registerSimpleBlockItem(name, registryBlock);
		return registryBlock;
	}

	/**
	 * Creates and returns a block, while also registering an item for it.
	 *
	 * @param name     The name of the block and item in the registries
	 * @param supplier A supplier that returns a new instance of the block each time it is called.
	 *
	 * @return The created block
	 */
	private static <T extends Block, E extends BlockItem> DeferredBlock<T> blockWithItem(String name, Supplier<T> supplier, Supplier<E> itemSupplier) {
		DeferredBlock<T> registryBlock = BLOCKS.register(name, supplier);
		ApeironItems.ITEMS.register(name, itemSupplier);
		return registryBlock;
	}
}
