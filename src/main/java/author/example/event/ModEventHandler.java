package author.example.event;

import author.example.Example;
import net.neoforged.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Example.MODID)
public class ModEventHandler {
}
