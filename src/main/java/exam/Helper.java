package exam;

import io.reactivex.Observable;
import java.util.*;


/**
 *
 * @author damian
 */
public class Helper {

	/**
	 * Metoda tworzy i zwraca sformatowane menu stworzone z danej listy.
	 * Formatowania wygląda następująco
	 * <ul>
	 * <li> Pojedyncza pizza zapisana w postaci: "nazwa_pizzy: nazwa_składnika1, nazwa_składnika2"</li>
	 * <li> Każda pizza zapisana w jednej linii tekstu, kolejne linie oddzielone znakiem '\n'</li>
	 * <li> Po ostatnie pizzy nie ma być znaku '\n'</li>
	 * </ul>
	 *
	 * @param pizzas lista z której jest utworzone menu
	 * @return sformatowane menu
	 */
	public String createFormatedMenu(List<Pizza> pizzas) {
		return String.join("\n", Observable.fromIterable(pizzas)
				.map(pizza -> pizza.getName() + ": " + String.join(", ", Observable.fromIterable(pizza.getIngredients()).map(ingredient -> ingredient.getPreetyName()).toList().blockingGet())).toList().blockingGet());
	}
	/**
	 * Metoda znajduje i zwraca najtańszą ostrą pizzę z podanej listy.
	 * Ostra pizza to taka, która ma przynajmniej jeden ostry składnik.
	 *
	 * @param pizzas lista, z której jest wyszukiwana pizza
	 * @return znaleziona pizza, lub {@code null} jeśli takiej nie ma
	 */
	public Pizza findCheapestSpicy(List<Pizza> pizzas) {

		return Observable.fromIterable(pizzas).filter(pizza -> Observable.fromIterable(pizza.getIngredients()).any(i -> i.isSpicy()).blockingGet()).sorted(Comparator.comparing(pizza -> Observable.fromIterable(pizza.getIngredients()).reduce(0, (a, b) -> a += b.getPrice()).blockingGet())).blockingFirst(null);
	}

        /**
	 * Metoda znajduje i zwraca wegetariańską pizzę na cienkim cieście z największą liczbą składników z podanej listy.
	 * Wegetariańska pizza to taka, która nie ma żadnego składnika mięsnego.
	 * @param pizzas lista, z której jest wyszukiwana pizza
	 * @return znaleziona pizza, lub {@code null} jeśli takiej nie ma
	 */
	public Pizza findThinVegetarian(List<Pizza> pizzas) {
			return Observable.fromIterable(pizzas)
					.filter(pizza -> Observable.fromIterable(pizza.getIngredients()).all(i -> !i.isMeat()).blockingGet())
					.filter(pizza -> Observable.fromIterable(pizza.getIngredients()).contains(Ingredient.THIN_CRUST).blockingGet())
					.blockingFirst(null);
        }
                
        /**
	 * Metoda zwraca dostęne składniki pogrupowane według kategorii.
	 * Metoda zwraca mapę w której kluczem jest nazwa kategorii, a wartoą zbiór składników.
	 * Kategorie:
	 * <ul>
	 * <li> "SPICY_MEAT" - składniki które są jednocześnie ostre i mięsne</li>
	 * <li> "MEAT" - składniki mięsne</li>
	 * <li> "SPICY" - składniki ostre</li>
	 * <li> "OTHER" - pozostałe składniki</li>
	 * </ul>
	 * Jeśli w danej kategorji nie występuje żaden składnik, to kategoria się nie pojawia 
	 * @param pizzas lista z pizzami z której składniki są poddawane analizie
	 * @return mapa z pogrupowanymi skĹ‚adnikami
	 */
	public Map<String, Set<Ingredient>> groupByIngredients(List<Pizza> pizzas) {

        return Observable.fromIterable(Observable.fromIterable(pizzas)
                .flatMap(pizza -> Observable.fromIterable(pizza.getIngredients()))
                .distinct()
                .groupBy(i -> i.isMeat() && i.isSpicy() ? "SPICY_MEAT" : i.isMeat() ? "MEAT" : i.isSpicy() ? "SPICY" : "OTHER")
                .blockingIterable())
                .toMap(f -> f.getKey(), h-> {
                	Set<Ingredient> set = new HashSet<>(h.toList().blockingGet());
                	return set;
				}).blockingGet();
    }
}
