/**
 * @author Bryce
 *
 */
import java.util.ArrayList;

class Recipe {
	
	private String name;
	private String mealType;
	private String mainIngredient;
	private int rating;
	private String description;
	private ArrayList<String> ingredients;
	private ArrayList<String> directions;
	private int cooktime;
	private String notes;
	
	public Recipe(String name, String description, ArrayList<String> ingredients, ArrayList<String> directions)
	{
		this.name = name;
		this.description = description;
		this.ingredients = new ArrayList<String>();
		for(String p : ingredients)
			this.ingredients.add(p);
		this.directions = new ArrayList<String>();
		for(String p : directions)
			this.directions.add(p);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCooktime() {
		return cooktime;
	}

	public void setCooktime(int cooktime) {
		this.cooktime = cooktime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void print() {
		System.out.format("Name: \t\t\t %s", name + "\n");
		System.out.format("Description: \t\t %s", description + "\n");
		if(mainIngredient != null)
			System.out.format("Main Ingredient: \t %s", mainIngredient + "\n");
		if(mealType != null)
			System.out.format("Meal Type: \t\t %s", mealType + "\n");
		System.out.println("\nIngredients \n----------");
		for(int x=0; x < ingredients.size(); x++)
		{
			System.out.println(ingredients.get(x).toString());
		}
		//System.out.println(ingredients.toString());
		System.out.println();
		System.out.println("Directions \n----------");
		for(int x=0; x < directions.size(); x++)
		{
			System.out.println((x+1) + ". " + directions.get(x).toString());
		}
		System.out.println();
	}
}
