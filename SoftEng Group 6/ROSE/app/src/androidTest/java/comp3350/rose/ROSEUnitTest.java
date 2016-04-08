package comp3350.rose;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.junit.*;

import android.content.Context;
import android.app.ListActivity;
import android.util.Log;

import java.util.ArrayList;

import comp3350.rose.Controller.DBInterface;
import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;
import comp3350.rose.Database.RecipeDatabase;
import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;

import dalvik.annotation.TestTargetClass;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ROSEUnitTest {
    static Context con;
    static StubDB stub;
    static ArrayList<Recipe> temp_recipes;
    static ArrayList<String> temp_recipeDisplay;
    static int temp_recipePosition;
    static Recipe temp_Recipe;
    static String temp_string;
    static int temp_int;

    @BeforeClass
    public static void setUpClass() throws Exception {
        con = MyApplication.getAppContext();
        stub = StubDB.getInstance(con);


        temp_recipes = stub.getList();
        temp_recipeDisplay = new ArrayList<>();

        temp_recipePosition = 0;

    }

    @Test
    protected void initTest(Bundle savedInstanceState) {
        init start = new init();

        ArrayList<Recipe> recipes = stub.getList();
        ArrayList<String> recipeDisplay = new ArrayList<>();

        assertEquals("Recipes were not loaded from the stub database correctly.", temp_recipes, recipes);
        assertEquals("Resipe display list not loaded correctly.", temp_recipeDisplay, recipeDisplay);

    }

    @Test
    protected void DetailsTest(Bundle savedInstanceState) {
        Details det = new Details();

        Recipe clickedRecipe = ((MyApplication)det.getApplication()).getSortedRecipes().get(det.recipePosition);
        ArrayList<String> recipeDetails = new ArrayList<>();

        assertEquals("Clicked Recipe is not a valid Recipe.", temp_Recipe, clickedRecipe);
        assertEquals("Recipe Details not in valid String ArrayList format.", temp_recipeDisplay, recipeDetails);

    }

    @Test
    protected void RecipeTest(Bundle savedInstanceState) {
        Details det = new Details();
        Recipe example = ((MyApplication)det.getApplication()).getSortedRecipes().get(det.recipePosition);

        String name = example.getName();
        String mealType = example.getMealType();
        String mainIngredient = example.getMainIngredient();
        int rating = example.getRating();
        String description = example.getDescription();
        ArrayList<String> ingredients = example.getIngredients();
        ArrayList<String> directions = example.getDirections();
        int cooktime = example.getCooktime();
        String notes = example.getNotes();

        assertEquals("Name is not a valid String.", name, temp_string);
        assertEquals("Meal Type is not a valid String.", mealType, temp_string);
        assertEquals("Main Ingredient is not a valid String.", mainIngredient, temp_string);
        assertEquals("Description is not a valid string.", description, temp_string);
        assertEquals("Notes is not a valid String.", notes, temp_string);

        assertEquals("Rating is not a valid integer.", rating, temp_int);
        assertEquals("Cook Time is not a valid integer.", cooktime, temp_int);

        assertEquals("Ingredients is not a valid ArrayList.", ingredients, temp_recipeDisplay);
        assertEquals("Directions is not a valid ArrayList.", directions, temp_recipeDisplay);

    }

    @Test
    protected void ShoppingListTest(Bundle savedInstanceState) {
        ShoppingList list = new ShoppingList();
        ArrayList<String> shoppingDisplay = new ArrayList<>();

        assertEquals("Shopping List display list not loaded correctly.", temp_recipeDisplay, shoppingDisplay);

    }

    @Test
    protected void EditTest(Bundle savedInstanceState) {
        Edit changer = new Edit();

        Recipe recipeToModify = changer.recipeToModify;

        assertEquals("Chosen Recipe is not a valid Recipe.", temp_Recipe, recipeToModify);


    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // No Cleanup Necessary
    }

}

