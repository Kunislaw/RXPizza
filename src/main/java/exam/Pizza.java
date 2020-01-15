package exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Klasa pizzy
 *
 * @author damian
 */
public class Pizza {

	private final String name;
	private final List<Ingredient> ingredients;

	public Pizza(String name, List<Ingredient> ingredients) {
		this.name = name;
		this.ingredients = Collections.unmodifiableList(ingredients);
	}

	public Pizza(String name, Ingredient... ingredients) {
		this(name, Arrays.asList(ingredients));
	}

	public String getName() {
		return name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + Objects.hashCode(this.name);
		hash = 41 * hash + Objects.hashCode(this.ingredients);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Pizza other = (Pizza) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.ingredients, other.ingredients)) {
			return false;
		}
		return true;
	}

}
