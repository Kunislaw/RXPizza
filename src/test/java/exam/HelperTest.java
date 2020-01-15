/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import static exam.Pizzas.*;
import static exam.Ingredient.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author damian
 */
public class HelperTest {

	public HelperTest() {
	}

	@Test
	public void testCreateFormatedMenu() {
		System.out.println("createFormatedMenu");
		// given
		List<Pizza> pizzas = Arrays.asList(SOPRANO, CAPRI, FOUR_CHEESE);
		String expResult = "Soprano: grube ciasto, sos pomidorowy, ser, szynka, pieczarki, cebula, bekon, pieprz\n"
				+ "Capri: cienkie ciasto, sos pomidorowy, ser, szynka, pieczarki\n"
				+ "Cztery sery: cienkie ciasto, sos pomidorowy, ser, mozarella, ser feta, ser pleśniowy";

		// when
		Helper helper = new Helper();
		String result = helper.createFormatedMenu(pizzas);

		// then
		assertEquals(expResult, result);
	}

	@Test
	public void testFindCheapestSpicy() {
		System.out.println("findCheapestSpicy");
		// given
		List<Pizza> pizzas = Pizzas.ALL;
		Pizza expResult = CARUSO;
		
		// when
		Helper helper = new Helper();
		Pizza result = helper.findCheapestSpicy(pizzas);
		
		// then
		assertEquals(expResult, result);
	}

	@Test
	public void testFindCheapestSpicy2() {
		System.out.println("findCheapestSpicy");
		// given
		List<Pizza> pizzas = Arrays.asList(AMORE, FOUR_CHEESE, TABASCO, SOPRANO);
		Pizza expResult = TABASCO;
		
		// when
		Helper helper = new Helper();
		Pizza result = helper.findCheapestSpicy(pizzas);
		
		// then
		assertEquals(expResult, result);
	}
	
	@Test
	public void testFindCheapestSpicy3() {
		System.out.println("findCheapestSpicy");
		// given
		List<Pizza> pizzas = Arrays.asList(MARGHERITA, CALABRESE, FARMER);
		Pizza expResult = null;
		
		// when
		Helper helper = new Helper();
		Pizza result = helper.findCheapestSpicy(pizzas);
		
		// then
		assertEquals(expResult, result);
	}
        
        @Test
	public void testFindThinVegetarian() {
		System.out.println("findThinVegetarian");
		// given
		List<Pizza> pizzas = Arrays.asList(MARGHERITA, CALABRESE, FARMER);
		Pizza expResult = MARGHERITA;
		
		// when
		Helper helper = new Helper();
		Pizza result = helper.findThinVegetarian(pizzas);
		
		// then
		assertEquals(expResult, result);
	}

	@Test
	public void testFindThinVegetarian2() {
		System.out.println("findThinVegetarian");
		// given
		List<Pizza> pizzas = Arrays.asList(VEGETARIANA, CARUSO, FOUR_CHEESE);
		Pizza expResult = VEGETARIANA;
		
		// when
		Helper helper = new Helper();
		Pizza result = helper.findThinVegetarian(pizzas);
		
		// then
		assertEquals(expResult, result);
	}
	
	@Test
	public void testFindThinVegetarian3() {
		System.out.println("findThinVegetarian");
		// given
		List<Pizza> pizzas = Arrays.asList(FARMER, MAMA_MIA, HAVAI);
		Pizza expResult = null;
		
		// when
		Helper helper = new Helper();
		Pizza result = helper.findThinVegetarian(pizzas);
		
		// then
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGroupByIngredients() {
		System.out.println("groupByIngredients");
		// given
		List<Pizza> pizzas = Arrays.asList(CAPRI, CARUSO, TABASCO);
		Map<String, Set<Ingredient>> expResult = new HashMap<>();
		expResult.put("MEAT", new HashSet<>(Arrays.asList(SUASAGE, HAM, SALAMI)));
		expResult.put("SPICY", new HashSet<>(Arrays.asList(PEPERONI, TABASCO_SUACE)));
		expResult.put("OTHER", new HashSet<>(Arrays.asList(THIN_CRUST, TOMATO_SUACE, CHEESE, MUSHROOMS, THICK_CRUST, CORN)));

		// when
		Helper helper = new Helper();
		Map<String, Set<Ingredient>> result = helper.groupByIngredients(pizzas);
		
		// then
		assertEquals(expResult, result);
	}

	@Test
	public void testGroupByIngredients2() {
		System.out.println("groupByIngredients");
		// given
		List<Pizza> pizzas = Arrays.asList(MARGHERITA, CAPRESE);
		Map<String, Set<Ingredient>> expResult = new HashMap<>();
		expResult.put("OTHER", new HashSet<>(Arrays.asList(THIN_CRUST, TOMATO_SUACE, CHEESE, THICK_CRUST, MOZARELLA, FETA, TOMATO, BASIL)));

		// when
		Helper helper = new Helper();
		Map<String, Set<Ingredient>> result = helper.groupByIngredients(pizzas);
		
		// then
		assertEquals(expResult, result);
	}

}
