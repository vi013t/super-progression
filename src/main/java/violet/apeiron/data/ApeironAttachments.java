package violet.apeiron.data;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import violet.apeiron.Apeiron;

public class ApeironAttachments {

	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Apeiron.MODID);

	public static final Supplier<AttachmentType<ModifierAttachment>> MODIFIER = ATTACHMENT_TYPES.register("modifier", () -> AttachmentType.builder(ModifierAttachment::new).build());

	/**
	 * Registers the data attachments in the Apeiron mod with the given event bus. This should be called once during mod initialization.
	 * 
	 * @param eventBus The event bus, provided by NeoForge, to register the Apeiron attachments in.
	 */
	public static void register(@Nonnull IEventBus eventBus) {
		ApeironAttachments.ATTACHMENT_TYPES.register(eventBus);
	}

}
