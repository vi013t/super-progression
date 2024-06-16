package violet.apeiron.item.mining.opal;

import java.awt.Color;
import java.util.Optional;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

public class OpalUtils {
	public static MutableComponent colorize(String name) {
		return colorize(name, Style.EMPTY);
    }

	public static MutableComponent colorize(String name, Style style) {
		Optional<MutableComponent> characterComponent = Optional.empty();
		for (int index = 0; index < name.length(); index++) {
			Color color = Color.getHSBColor(((float) index) / ((float) name.length()), 0.15f, 1);
			MutableComponent newCharacterComponent = Component.literal(Character.toString(name.charAt(index)))
				.withStyle(
					style
					.withColor(color.getRGB())
				);
			if (characterComponent.isEmpty()) characterComponent = Optional.of(newCharacterComponent);
			else characterComponent = Optional.of(characterComponent.get().append(newCharacterComponent));
		}
		return characterComponent.get();
    }
}
