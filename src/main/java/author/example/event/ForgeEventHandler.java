package author.example.event;

import author.example.Example;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

/**
 * Example Mod's event handler for all events posted on the Forge bus.
 *
 * @see ModEventHandler
 */
@Mod.EventBusSubscriber(modid = Example.MODID)
public class ForgeEventHandler {
    @SubscribeEvent
    public static void exampleEvent(TickEvent.PlayerTickEvent event) {
        System.out.println("Tick!");
    }
}
