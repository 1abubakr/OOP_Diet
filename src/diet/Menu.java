package diet;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	private String name;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	private Food food;
	Map<NutritionalElement, Double> addrecipes = new TreeMap<>();
	Set<NutritionalElement> addProducts = new TreeSet<>();

	public Menu(String m1, Food food) {
	}

	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	public Menu addRecipe(String recipe, double quantity) {
		for (NutritionalElement nutRecipes : food.recipes) {
			if (nutRecipes.getName().equals(recipe)) addrecipes.put(nutRecipes, quantity);
		}
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
	public Menu addProduct(String product) {
		for (NutritionalElement nutProduct : food.products) {
			if (nutProduct.getName().equals(product)); addProducts.add(nutProduct);
		}
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		return calories;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		return proteins;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		return getCarbs();
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		return fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
