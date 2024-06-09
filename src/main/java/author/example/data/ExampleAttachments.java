package author.example.data;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import author.example.Example;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ExampleAttachments {

	@SuppressWarnings("null")
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Example.MODID);

	public static final Supplier<AttachmentType<ModifierAttachment>> MODIFIER = ATTACHMENT_TYPES.register("modifier",
			() -> AttachmentType.builder(ModifierAttachment::new).build());

	public static void register(@Nonnull IEventBus eventBus) {
		ExampleAttachments.ATTACHMENT_TYPES.register(eventBus);
	}

}
