package author.example;

import author.example.block.ExampleBlocks;
import author.example.item.ExampleItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

/**
 * The main mod class for the Example mod. This handles registering primary game elements like blocks, items, entities,
 * etc. into the NeoForge event bus.
 */
@Mod(Example.MODID)
public class Example {

    /** The unique ID for this mod, which must be different from all other mods in a pack, and must match src/resources/META_INF/mods.toml */
    public static final String MODID = "spacial_temporal_rending";
    /** A direct reference to a logger */
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Constructs the main mod instance, registering blocks, items, entities, etc. This should not be called directly from within the
     * mod code, but instead NeoForge will call this and pass the required information automatically.
     *
     * @param eventBus The event bus automatically passed by NeoForge.
     */
    public Example(IEventBus eventBus) {
        ExampleBlocks.register(eventBus);
        ExampleItems.register(eventBus);
    }
}
