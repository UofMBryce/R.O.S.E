package comp3350.rose.Stub;

/**
 * Created by Bryce on 3/7/2016.
 */

import android.content.Context;

import java.util.ArrayList;

import comp3350.rose.Controller.DBInterface;
import comp3350.rose.model.Recipe;

public class StubDB implements DBInterface{
    private static StubDB sInstance;
    private static Context sContext;

    public static synchronized StubDB getInstance(Context context){
        if(sInstance == null){
            sInstance = new StubDB(context.getApplicationContext());
        }
        return sInstance;
    }

    private StubDB(Context context){
        sContext = context;
        this.initializeRecipes();

    }

    static ArrayList<Recipe> recipes = new ArrayList<>();



    public void initializeRecipes(){
        ArrayList<String> ingredients = new ArrayList<>();
        ArrayList<String> directions = new ArrayList<>();


//-----------------------------------------------------------------------------------------------------------------------------------
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
        recipe1.setMainIngredient("Beef");
        recipe1.setMealType("Supper");
//-----------------------------------------------------------------------------------------------------------------------------------
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
        recipe2.setMainIngredient("Chicken");
        recipe2.setMealType("Supper");
//-----------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("2 Slices Bread");
        ingredients.add("4 thin slices turkey");
        ingredients.add("20 ml Mayonaise");
        ingredients.add("1 slice cheddar cheese");
        ingredients.add("1 Leaf lettuce");

        directions.add("Toast bread lightly");
        directions.add("rip lettuce up into shreds");
        directions.add("cover bottom piece of bread in mayonaise");
        directions.add("add cheese slice, turkey, and shredded lettuce");
        directions.add("top with second piece of bread");
        directions.add("silce down the middle");

        Recipe recipe3 = new Recipe("Turkey Sandwhich","A classic toasted turkey sandwhich", ingredients, directions);
        recipe3.setMainIngredient("Turkey");
        recipe3.setMealType("Lunch");
//-----------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("2 eggs");
        ingredients.add("1/2 cup milk");
        ingredients.add("4 slices bread");
        ingredients.add("1 tsbp cinnamon");

        directions.add("whisk egg, milk, and cinnamon together");
        directions.add("soak each piece of bread in egg mixture");
        directions.add("place on frying pan, cook side until golden brown");
        directions.add("flip bread, do same to other side");
        directions.add("add topping of choice (syrup and icing sugar");

        Recipe recipe4 = new Recipe("French Toast", "Simple French Toast thats sure to be a hit", ingredients, directions);
        recipe4.setMealType("Breakfast");
//-----------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("1 cup cereal of choice");
        ingredients.add("1 cup milk");

        directions.add("pour cereal into bowl ");
        directions.add("pour milk into bowl");

        Recipe recipe5 = new Recipe("Cereal", "Just cereal. pretty basic", ingredients, directions);
        recipe5.setMealType("Breakfast");
//-----------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("1 lb pork roast");
        ingredients.add("1 bottle bbq sauce");
        ingredients.add("1 red onion, diced");
        ingredients.add("1 can soda (7-up or coke");
        ingredients.add("1 slice marble cheese");
        ingredients.add("1 dinner roll");
        ingredients.add("15 ml mayonaise");

        directions.add("cook pork roast in slow cooker for 8 hours");
        directions.add("use forks to shred pork");
        directions.add("add shredded pork back into slow cooker");
        directions.add("pour bbq sauce and can of pop into slow cooker");
        directions.add("cook on low for one hour00");
        directions.add("add pork, mayo, onion, and cheese to dinner roll");

        Recipe recipe6 = new Recipe("BBQ pulled pork", "delicous slow cooked pull pork in savory bbq sauce", ingredients, directions);

        recipe6.setMainIngredient("Pork");
        recipe6.setMealType("Supper");
//-----------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("2 boneless skinless chicken breasts");
        ingredients.add("2 cups chopped carrots");
        ingredients.add("1 cup chopped celery");
        ingredients.add("2 cups spaghetti noodles");
        ingredients.add("4 cups chicken broth");

        directions.add("combine chicken broth, chicken breasts, carrots, and celery into slowcooker");
        directions.add("cook on low for 7 hours");
        directions.add("remove chicken breasts and cut into small chunks");
        directions.add("add noodles and chicken to slow cooker");
        directions.add("cook until noodles are soft");

        Recipe recipe7 = new Recipe("Chicken Noodle Soup", "Classic chicken noodle soup thats sure to delight", ingredients, directions);
        recipe7.setMainIngredient("Chicken");
        recipe7.setMealType("Lunch");
//-------------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("1 lb roast beef");
        ingredients.add("2 cans beef stock or broth");
        ingredients.add("1 slice swiss cheese");
        ingredients.add("1 cup diced white onion");
        ingredients.add("1 cup chopped mushrooms");
        ingredients.add("1 tbsp butter");
        ingredients.add("1 crusty roll");

        directions.add("combine roast beef, onion, and broth in slowcooker");
        directions.add("cook on low for 6 hours");
        directions.add("fry mushrooms in butter");
        directions.add("Thinly slice beef");
        directions.add("toast crusty bun");
        directions.add("layer beef on bun, top with mushrooms and cheese");
        directions.add("pour broth into cup for dipping");

        Recipe recipe8 = new Recipe("Beef Dip", "Deli style beef dip with tasty aus jus", ingredients, directions);

        recipe8.setMainIngredient("Beef");
        recipe8.setMealType("Lunch");
//--------------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("1 package bacon");
        ingredients.add("2 cups cubed hashbrowns");
        ingredients.add("2 eggs");
        ingredients.add("1 cup shredded cheddar cheese");

        directions.add("fry bacon in frying pan on medium");
        directions.add("cook hashbrowns in oven at 400 degrees for 20 minutes");
        directions.add("cook eggs to taste on frying pan");
        directions.add("fill bowl with cooked hashbrowns");
        directions.add("chop up bacon and eggs, and add on top of hashbrowns");
        directions.add("cover with shredded cheese");
        directions.add("bake in oven at 350 degrees for 5 minutes or until cheese is melted");

        Recipe recipe9 = new Recipe("Breakfast Bowl", "a hearty breakfast bowl to start the day off right", ingredients, directions);

        recipe9.setMainIngredient("Pork");
        recipe9.setMealType("Breakfast");
//--------------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("1 cup vanilla yogurt");
        ingredients.add("1/2 cup granola");
        ingredients.add("1/2 cup frozen mixed berries");
        ingredients.add("1 banana");

        directions.add("cook granola on cooking pan in oven at 350 degrees for 10 minutes");
        directions.add("Slice banana");
        directions.add("fill a tall glass with half of the yogurt");
        directions.add("add half the berries and half the chopped banana");
        directions.add("fill cup with rest of yogurt");
        directions.add("top yogurt with rest of berries and banana");
        directions.add("sprinkle granola over beries");

        Recipe recipe10 = new Recipe("Yogurt Parfait", "A healthy natural breakfast option", ingredients, directions);

        recipe10.setMealType("Breakfast");
//--------------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();
        ingredients.add("2 slices white bread");
        ingredients.add("1 slice cheddar cheese");
        ingredients.add("1 slice mozzarella cheese");
        ingredients.add("2 thin slices of ham");
        ingredients.add("1 tbsp butter");

        directions.add("cover both sides of each piece of bread with butter");
        directions.add("make a sandwhich out of the buttered bread, cheese, and ham");
        directions.add("place sandwhich on frying pan and cook until first side is golden");
        directions.add("flip sandwhich, and fry second side until golden");
        directions.add("slice sandwhich down the middle");

        Recipe recipe11 = new Recipe("Grilled Ham & Cheese", "A grilled cheese with ham added in", ingredients, directions);

        recipe11.setMainIngredient("Pork");
        recipe11.setMealType("Breakfast");
//--------------------------------------------------------------------------------------------------------------------------------------
        ingredients.clear();
        directions.clear();

        ingredients.add("1 head romaine lettuce");
        ingredients.add("1 chicken breast, diced");
        ingredients.add("1 cup croutons");
        ingredients.add("1/2 cup caesar salad dressing");
        ingredients.add("2 tbsp parmesean cheese");
        ingredients.add("2 strips bacon");

        directions.add("fry bacon on medium until crispy");
        directions.add("bake chicken at 400 degrees for 20 minutes");
        directions.add("chop letuce");
        directions.add("mix lettuce, dressing, croutons, and chicken breast");
        directions.add("crumble bacon over salad");
        directions.add("sprinkle parmesean cheese over salad");

        Recipe recipe12 = new Recipe("Chicken Caesar Salad", "classic chicken caesar salad", ingredients, directions);

        recipe12.setMainIngredient("Chicken");
        recipe12.setMealType("Supper");
//--------------------------------------------------------------------------------------------------------------------------------------
        this.addRecipe(recipe1);
        this.addRecipe(recipe2);
        this.addRecipe(recipe3);
        this.addRecipe(recipe4);
        this.addRecipe(recipe5);
        this.addRecipe(recipe6);
        this.addRecipe(recipe7);
        this.addRecipe(recipe8);
        this.addRecipe(recipe9);
        this.addRecipe(recipe10);
        this.addRecipe(recipe11);
        this.addRecipe(recipe12);
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
        String result;
        result = "Add Completed";
    }

    public void editRecipe(Recipe newRecipe){
        int x;
        boolean flag = false;
        String result;

        for(x = 0; x < recipes.size(); x++)
        {
            if(recipes.get(x).equals(newRecipe)) {
                recipes.set(x, newRecipe);
                flag = true;
            }
        }
        if(flag)
            result = "Update Completed";
        else
            result = "Update Failed";
    }

    public void deleteRecipe(Recipe recipe){
        int x;
        boolean flag = false;
        String result;

        for(x = 0; x < recipes.size(); x++)
        {
            if(recipes.get(x).equals(recipe)) {
                recipes.remove(x);
                flag = true;
            }
        }
        if(flag)
            result = "Deletion Completed";
        else
            result = "Deletion Failed";
    }
    @Override
    public ArrayList<Recipe> getList() {
        return recipes;
    }

    //TODO Move this to seperate class
    public static ArrayList<String> getShoppingList(){
        ArrayList<String> shoppingList = new ArrayList<>();
        shoppingList.add("Carrots");
        shoppingList.add("Butter");
        shoppingList.add("Bacon");
        shoppingList.add("Jello");
        return shoppingList;
    }


}