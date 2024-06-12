package violet.apeiron;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import violet.apeiron.block.ApeironBlocks;
import violet.apeiron.data.ApeironAttachments;
import violet.apeiron.item.ApeironItems;

/**
 * The main mod class for the Example mod. This handles registering primary game elements like blocks, items, entities, etc. into
 * the NeoForge event bus.
 */
@Mod(Apeiron.MODID)
public class Apeiron {

	/**
	 * The unique ID for this mod, which must be different from all other mods in a pack, and must match
	 * src/resources/META_INF/mods.toml
	 */
	public static final String MODID = "apeiron";
	/** A direct reference to a logger */
	public static final Logger LOGGER = LogUtils.getLogger();

	/**
	 * Constructs the main mod instance, registering blocks, items, entities, etc. This should not be called directly from within the
	 * mod code, but instead NeoForge will call this and pass the required information automatically.
	 *
	 * @param eventBus The event bus automatically passed by NeoForge.
	 */
	public Apeiron(IEventBus eventBus) {
		ApeironBlocks.register(eventBus);
		ApeironItems.register(eventBus);
		ApeironAttachments.register(eventBus);
	}
}
