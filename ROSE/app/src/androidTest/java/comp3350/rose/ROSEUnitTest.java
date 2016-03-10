package comp3350.rose;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.junit.Test;

import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;

import java.util.ArrayList;

import dalvik.annotation.TestTargetClass;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ROSEUnitTest {
    @BeforeClass
    public static void setUpClass() throws Exception {
        ArrayList<Recipe> temp_recipes = StubDB.getList();
        ArrayList<String> temp_recipeDisplay = new ArrayList<>();

        int temp_recipePosition = 0;
        Recipe temp_Recipe;

        String temp_string;
        int temp_int;
    }

    @Test
    protected void initTest(Bundle savedInstanceState) {
        init(savedInstanceState);

        assertEquals("Recipes were not loaded from the stub database correctly.", temp_recipes, recipes);
        assertEquals("Resipe display list not loaded correctly.", temp_recipeDisplay, recipeDisplay);

    }

    @Test
    protected void DetailsTest(Bundle savedInstanceState) {
        Details(savedInstanceState);

        assertEquals("Clicked Recipe is not a valid Recipe.", temp_Recipe, clickedRecipe);
        assertEquals("Recipe Details not in valid String ArrayList format.", temp_recipeDisplay, recipeDetails);

    }

    @Test
    protected void RecipeTest(Bundle savedInstanceState) {
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

    @AfterClass
    public static void tearDownClass() throws Exception {
        // No Cleanup Necessary
    }

}
