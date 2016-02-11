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
		this.ingredients = ingredients;
		this.directions = new ArrayList<String>();
		this.directions = directions;
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
		System.out.println("Name:    " + name);
		System.out.println("Description:    " + description);
		System.out.println("Ingredients \n----------");
		System.out.println(ingredients.toString());
		System.out.println();
		System.out.println("Directions \n ----------");
		System.out.println(directions.toString());
		System.out.println();
//		for(int x=0; x < ingredients.size(); x++)
//		{
//			
//		}
	}
}
