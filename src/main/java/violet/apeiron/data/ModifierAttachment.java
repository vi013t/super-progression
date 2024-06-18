package violet.apeiron.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ModifierAttachment {

	private final Map<Modifier, Integer> modifiers = new LinkedHashMap<>();

	public void addModifier(Modifier modifier, int level) {
		this.modifiers.put(modifier, level);
	}

	public void addModifier(Modifier modifier) {
		this.addModifier(modifier, 1);
	}

	public void upgradeModifier(Modifier modifier) {
		if (this.modifiers.containsKey(modifier)) {
			this.modifiers.put(modifier, this.modifiers.get(modifier) + 1);
		} else {
			this.addModifier(modifier);
		}
	}

	public Optional<Integer> getModifierLevel(Modifier modifier) {
		return Optional.ofNullable(this.modifiers.get(modifier));
	}

	public Set<Map.Entry<Modifier, Integer>> modifierEntries() {
		return this.modifiers.entrySet();
	}

	public boolean hasModifier(Modifier modifier) {
		return this.modifiers.containsKey(modifier);
	}

	public Optional<Modifier> firstModifier() {
		return Optional.ofNullable(this.modifiers.entrySet().toArray(Modifier[]::new)[0]);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (var modifier : this.modifiers.entrySet()) {
			builder.append(modifier.getKey().name + ", ");
		}
		builder.append("]");
		return builder.toString();
	}
}