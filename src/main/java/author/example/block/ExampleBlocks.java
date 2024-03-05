package author.example.block;

import author.example.Example;
import author.example.item.ExampleItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

/**
 * Utility class for handling blocks in the Spacial & Temporal Rending mod. This class
 * handles the instantiation of all blocks, all of which can be retrieved as fields of this
 * class, as well as registering all the blocks via the {@link #register(IEventBus)} method
 * which should be called in the {@link Example main} class's constructor with the
 * given {@link IEventBus} from NeoForge.
 */
@ParametersAreNonnullByDefault
public class ExampleBlocks {

    /** The register for all blocks in the mod. */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Example.MODID);

    /** The register for all block entities in the mod */
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Example.MODID);

    /**
     * Registers the modded blocks into the registry, and adds event listeners onto this class.
     *
     * @param eventBus The event bus to register with.
     */
    public static void register(IEventBus eventBus) {
        ExampleBlocks.BLOCKS.register(eventBus);
        ExampleBlocks.BLOCK_ENTITIES.register(eventBus);
    }

    /**
     * Creates and returns a block, while also registering an item for it.
     *
     * @param name The name of the block and item in the registries
     * @param supplier A supplier that returns a new instance of the block each time it is called.
     *
     * @return The created block
     */
    private static <T extends Block> DeferredBlock<T> blockWithItem(String name, Supplier<T> supplier) {
        DeferredBlock<T> registryBlock = BLOCKS.register(name, supplier);
        ExampleItems.ITEMS.registerSimpleBlockItem(name, registryBlock);
        return registryBlock;
    }
}
