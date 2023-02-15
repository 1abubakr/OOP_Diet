package diet;

import java.util.*;

/**
 * Represents a recipe of the diet.
 * <p>
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 */
public class Recipe implements NutritionalElement {
    private String name;
    private double calories;
    private double proteins;
    private double carbs;
    private double fat;
    private Food food;
    Map<NutritionalElement, Double> ingredients = new TreeMap<>();

    public Recipe(String name, Food food) {
        this.name = name;
        this.food = food;
    }

    public Recipe(String name) {
    }


    /**
     * Adds a given quantity of an ingredient to the recipe.
     * The ingredient is a raw material.
     *
     * @param material the name of the raw material to be used as ingredient
     * @param quantity the amount in grams of the raw material to be used
     * @return the same Recipe object, it allows method chaining.
     */
    public Recipe addIngredient(String material, double quantity) {
        NutritionalElement rawmaterial = food.getRawMaterial(material);
            ingredients.put(rawmaterial, quantity);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCalories() {
        return calories;
    }

    @Override
    public double getProteins() {
        return proteins;
    }

    @Override
    public double getCarbs() {
        return carbs;
    }

    @Override
    public double getFat() {
        return fat;
    }

    /**
     * Indicates whether the nutritional values returned by the other methods
     * refer to a conventional 100g quantity of nutritional element,
     * or to a unit of element.
     * <p>
     * For the {@link Recipe} class it must always return {@code true}:
     * a recipe expressed nutritional values per 100g
     *
     * @return boolean indicator
     */
    @Override
    public boolean per100g() {
        // a recipe expressed nutritional values per 100g
        return true;
    }


}
