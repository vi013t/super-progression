package author.example.event;

import author.example.Example;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

/**
 * Example Mod's event handler for all events posted on the mod event bus.
 *
 * @see ForgeEventHandler
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Example.MODID)
public class ModEventHandler {
    @SubscribeEvent
    public static void exampleEvent(EntityAttributeCreationEvent event) {
        System.out.println("Attribute created!");
    }
}
