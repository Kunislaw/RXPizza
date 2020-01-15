package exam;

/**
 * Skladniki pizzy
 */
public enum Ingredient {
	THIN_CRUST("cienkie ciasto", 12),
	THICK_CRUST("grube ciasto", 14),
	TOMATO_SUACE("sos pomidorowy", 0),
	CHEESE("ser", 1),
	ONION("cebula", 1),
	PINEAPPLE("ananas", 1),
	BROCCOLI("brokuły", 1),
	BEAN("fasola", 1),
	CORN("kukurydza", 1),
	PEPERONI("papryka peperoni", 1, false, true),
	MUSHROOMS("pieczarki", 1),
	TOMATO("pomidor", 1),
	FETA("ser feta", 2),
	MOZARELLA("mozarella", 2),
	SUASAGE("kiełbasa", 2, true, false),
	CHICKEN("kurczak", 2, true, false),
	OLIVES("oliwki", 2),
	SALAMI("salami", 2, true, false),
	TUNA("tuńczyk", 2),
	BECON("bekon", 3, true, false),
	ARUGULA("rukola", 3),
	BLUE_CHEESE("ser pleśniowy", 2),
	HAM("szynka", 3, true, false),
	BASIL("bazylia", 0),
	PEPPER("pieprz", 0, false, true),
	TABASCO_SUACE("tabasco", 0, false, true)
	;
	private final String preetyName;
	private final int price;
	private final boolean meat;
	private final boolean spicy;

	private Ingredient(String preetyName, int price, boolean meat, boolean spicy) {
		this.preetyName = preetyName;
		this.price = price;
		this.meat = meat;
		this.spicy = spicy;
	}

	private Ingredient(String preetyName, int price) {
		this.preetyName = preetyName;
		this.price = price;
		this.meat = false;
		this.spicy = false;
	}
	
	/**
	 * Zwraca nazwe skladnika
	 * @return 
	 */
	public String getPreetyName() {
		return preetyName;
	}

	/**
	 * Zwraca cene skladnika
	 * @return 
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * zwraca true jesli skladnik jest miesem (nie dla wegetarian)
	 * @return 
	 */
	public boolean isMeat() {
		return meat;
	}

	/**
	 * zwraca true jesli skladnik jest pikantny
	 * @return 
	 */
	public boolean isSpicy() {
		return spicy;
	}

	@Override
	public String toString() {
		return preetyName;
	}
	
}
