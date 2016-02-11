import java.util.ArrayList;
public class doWork {

	public static void main(String[] args) {
	
		ArrayList<String> ingredients = new ArrayList<String>();
		ArrayList<String> directions = new ArrayList<String>();
		
		ingredients.add("1 Cup Spaghetti");
		ingredients.add("1/2 lb Ground Beef");
		ingredients.add("1 Cup Spaghetti Sauce");
		ingredients.add("4 Fresh Mushrooms");
		
		directions.add("Cut Up Mushrooms into slices");
		directions.add("Cook beef on frying pan until brown");
		directions.add("boil spaghetti until al dente");
		directions.add("bring sauce to boil in sauce pan");
		directions.add("Fry mushrooms in pan");
		directions.add("Combine mushrooms, beef, and sauce");
		directions.add("poor sauce over spaghetti");
		
		Recipe recipe1 = new Recipe("Spaghetti", "Spaghetti with a meat sauce", ingredients, directions);
		
		ingredients.clear();
		directions.clear();
		ingredients.add("1 Cup frozen peas and carrots");
		ingredients.add("1/2 lb Ground Chicken");
		ingredients.add("1/3 Cup Honey Garlic Sauce");
		ingredients.add("1 Cup Rice");
		
		directions.add("boil peas and carrots until cooked ");
		directions.add("Cook chicken on frying pan until no pinkness remains");
		directions.add("cook rice until fluffy");
		directions.add("combine chicken, rice, and vegetables into pot");
		directions.add("add honey garlic sauce");
		directions.add("cook on low until warm");
		
		Recipe recipe2 = new Recipe("Honey Garlic Chicken", "A twist on stir fry thats simple to make", ingredients, directions);
		
//		ingredients.clear();
//		directions.clear();
//		ingredients.add("1 Cup Spaghetti");
//		ingredients.add("1/2 lb Ground Beef");
//		ingredients.add("1 Cup Spaghetti Sauce");
//		ingredients.add("4 Fresh Mushrooms");
//		
//		directions.add("Cut Up Mushrooms into slices");
//		directions.add("Cook beef on frying pan until brown");
//		directions.add("boil spaghetti until al dente");
//		directions.add("bring sauce to boil in sauce pan");
//		directions.add("Fry mushrooms in pan");
//		directions.add("Combine mushrooms, beef, and sauce");
//		directions.add("poor sauce over spaghetti");
//		Recipe recipe3;
//		
//		ingredients.clear();
//		directions.clear();
//		ingredients.add("1 Cup Spaghetti");
//		ingredients.add("1/2 lb Ground Beef");
//		ingredients.add("1 Cup Spaghetti Sauce");
//		ingredients.add("4 Fresh Mushrooms");
//		
//		directions.add("Cut Up Mushrooms into slices");
//		directions.add("Cook beef on frying pan until brown");
//		directions.add("boil spaghetti until al dente");
//		directions.add("bring sauce to boil in sauce pan");
//		directions.add("Fry mushrooms in pan");
//		directions.add("Combine mushrooms, beef, and sauce");
//		directions.add("poor sauce over spaghetti");
//		Recipe recipe4;
		
		ArrayList<Recipe> recipes = new ArrayList();
		recipes.add(recipe1);
		recipes.add(recipe2);
		//recipes.add(recipe3);
		//recipes.add(recipe4);
		
		System.out.println("Printing Recipes \n************************\n");
		for(int x = 0; x < recipes.size(); x++)
		{
			recipes.get(x).print();
			System.out.println("\n");
		}
	}
}
