package comp3350.rose;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;

import java.util.ArrayList;

import dalvik.annotation.TestTargetClass;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ROSEUnitTest extends ListActivity {
    Recipe rec;
    Edit changer;
    ShoppingList shopper;

    private static MyApplication myApp = (MyApplication)new init().getApplication();
    private static DBInterface repository = myApp.getRepository(myApp);
    private static ArrayList<Recipe> temp_recipes = repository.getList();

    private static ListView RecipeListView;
    private static Recipe temp_Recipe;
    private static ListView DetailsListView;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Set Up Recipe ListView
        ArrayList<String> recDisplay = new ArrayList<>();

        for(int i=0; i<temp_recipes.size(); i++) {
            recDisplay.add(temp_recipes.get(i).getName());
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(new init(), android.R.layout.simple_list_item_1, recDisplay);

        RecipeListView = new init().getListView();
        RecipeListView.setAdapter(myArrayAdapter);

        // Set Up Recipe (First Recipe in List)
        temp_Recipe = myApp.getSortedRecipes().get(1);

        // Set Up Details ListView
        ArrayList<String> recDetails = new ArrayList<>();

        recDetails.add(temp_Recipe.getName());
        recDetails.add(temp_Recipe.getDescription());
        recDetails.add("Ingredients:");
        for(int i=0; i<temp_Recipe.getIngredients().size(); i++){
            recDetails.add(temp_Recipe.getIngredients().get(i));
        }
        recDetails.add("Instructions:");
        for(int i=0; i<temp_Recipe.getDirections().size(); i++){
            recDetails.add(temp_Recipe.getDirections().get(i));
        }

        myArrayAdapter = new ArrayAdapter<>(new Details(), android.R.layout.simple_list_item_1, recDetails);
        DetailsListView = new Details().getListView();
        DetailsListView.setAdapter(myArrayAdapter);
    }

    @Test
    protected void initTest(Bundle savedInstanceState) {
        init initializer = new init();

        ListView initListView = initializer.lv;

        assertEquals("Recipes were not loaded from the stub database to the ListView correctly.", initListView, RecipeListView);

    }

    @Test
    protected void RecipeTest() {
        String name = temp_Recipe.getName();
        String mealType = temp_Recipe.getMealType();
        String mainIngredient = temp_Recipe.getMainIngredient();
        String description = temp_Recipe.getDescription();
        String notes = temp_Recipe.getNotes();

        int rating = temp_Recipe.getRating();
        int cooktime = temp_Recipe.getCooktime();

        ArrayList<String> ingredients = temp_Recipe.getIngredients();
        ArrayList<String> directions = temp_Recipe.getDirections();

        String temp_string = "";
        int temp_int = 0;
        ArrayList<String> temp_recipeDisplayList = new ArrayList<>();

        assertEquals("Name is not a valid String.", name, temp_string);
        assertEquals("Meal Type is not a valid String.", mealType, temp_string);
        assertEquals("Main Ingredient is not a valid String.", mainIngredient, temp_string);
        assertEquals("Description is not a valid string.", description, temp_string);
        assertEquals("Notes is not a valid String.", notes, temp_string);

        assertEquals("Rating is not a valid integer.", rating, temp_int);
        assertEquals("Cook Time is not a valid integer.", cooktime, temp_int);

        assertEquals("Ingredients is not a valid ArrayList.", ingredients, temp_recipeDisplayList);
        assertEquals("Directions is not a valid ArrayList.", directions, temp_recipeDisplayList);
    }

    @Test
    protected void DetailsTest(Bundle savedInstanceState) {
        Details dets = new Details();

        ListView detListView = dets.lv;
        int detRecipePos = dets.recipePosition;

        int temp_Pos = 0;

        assertEquals("Clicked Recipe Position is not a valid Recipe Position.", detRecipePos, temp_Pos);
        assertEquals("Recipe Details were not loaded from the Recipe to the ListView correctly.", detListView, DetailsListView);

    }

    @Test
    protected void EditTest() {

        

    }

    @After
    public static void tearDownClass() throws Exception {
        // No Cleanup Necessary
    }

}
