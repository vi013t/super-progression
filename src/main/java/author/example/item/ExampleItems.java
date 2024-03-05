package author.example.item;

import author.example.Example;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExampleItems {

    /** The registry of all items in the "Spacial & Temporal Rending" mod. */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Example.MODID);

    /** The registry of all creative tabs in the "Spacial & Temporal Rending" mod. */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Example.MODID);

    /** The one and only creative tab for all items and blocks in the Example mod. */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register(Example.MODID, () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup." + Example.MODID))
        .icon(Items.NETHER_STAR::getDefaultInstance)
        .displayItems((parameters, output) -> {
            for (var item : ExampleItems.ITEMS.getEntries()) {
                output.accept(item.get().getDefaultInstance());
            }
        })
        .build());

    /**
     * Registers the item register with the given event bus, as well as the creative tab register.
     *
     * @param eventBus the event bus to register the items and creative tabs on
     */
    public static void register(IEventBus eventBus) {
        ExampleItems.ITEMS.register(eventBus);
        ExampleItems.CREATIVE_MODE_TABS.register(eventBus);
    }
}
