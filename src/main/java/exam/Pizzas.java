package exam;

import static exam.Ingredient.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public final class Pizzas {

	private Pizzas() {
	}
	
	public static final Pizza MARGHERITA = new Pizza("Marrgherita", THIN_CRUST, TOMATO_SUACE, CHEESE);
	public static final Pizza CAPRI = new Pizza("Capri", THIN_CRUST, TOMATO_SUACE, CHEESE, HAM, MUSHROOMS);
	public static final Pizza HAVAI = new Pizza("Havai", THIN_CRUST, TOMATO_SUACE, CHEESE, HAM, PINEAPPLE);
	public static final Pizza CARUSO = new Pizza("Caruso", THIN_CRUST, TOMATO_SUACE, SUASAGE, PEPERONI);
	public static final Pizza MAMA_MIA = new Pizza("Mama Mia", THIN_CRUST, TOMATO_SUACE, CHEESE, ONION, MUSHROOMS, BECON);
	public static final Pizza SOPRANO = new Pizza("Soprano", THICK_CRUST, TOMATO_SUACE, CHEESE, HAM, MUSHROOMS, ONION, BECON, PEPPER);
	public static final Pizza CALABRESE = new Pizza("Calabrese", THICK_CRUST, TOMATO_SUACE, CHEESE, HAM, MUSHROOMS, SUASAGE, ONION, OLIVES);
	public static final Pizza VEGETARIANA = new Pizza("Vegetariana", THIN_CRUST, TOMATO_SUACE, CHEESE, ONION, BEAN, CORN, BROCCOLI, ARUGULA);
	public static final Pizza CAPRESE = new Pizza("Caprese", THICK_CRUST, TOMATO_SUACE, MOZARELLA, FETA, TOMATO, BASIL);
	public static final Pizza PASCETORE = new Pizza("Pascetore", THIN_CRUST, TOMATO_SUACE, CHEESE, TUNA, ONION);
	public static final Pizza FOUR_CHEESE = new Pizza("Cztery sery", THIN_CRUST, TOMATO_SUACE, CHEESE, MOZARELLA, FETA, BLUE_CHEESE);
	public static final Pizza TABASCO = new Pizza("Tabasco", THICK_CRUST, TOMATO_SUACE, CHEESE, HAM, SALAMI, PEPERONI, CORN, TABASCO_SUACE);
	public static final Pizza AMORE = new Pizza("Amore", THIN_CRUST, TOMATO_SUACE, CHEESE, CHICKEN, TOMATO);
	public static final Pizza FARMER = new Pizza("Farmerska", THICK_CRUST, TOMATO_SUACE, CHEESE, CHICKEN, BECON, ONION, CORN);
	// wszystkie
	public static final List<Pizza> ALL = Arrays.asList(MARGHERITA, CAPRI, HAVAI, CARUSO, MAMA_MIA, SOPRANO, CALABRESE, VEGETARIANA, CAPRESE, PASCETORE, FOUR_CHEESE, TABASCO, AMORE, FARMER);
}
