
package comp3350.rose.Business;

/**
 * Created by Bryce on 3/10/2016.
 *
 * This Class is specifically used to change the repository being used. Making it an extension
 * of the application class allows it to be accessed throughout the app.
 */
import android.app.Application;
import android.support.v4.app.INotificationSideChannel;
import android.content.Context;

import java.util.ArrayList;

import comp3350.rose.Controller.DBSLInterface;
import comp3350.rose.Database.RecipeDatabase;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.Database.ShoppingListDatabase;
import comp3350.rose.Database.dbSLHelper;
import comp3350.rose.Stub.StubDB;
import comp3350.rose.Stub.StubSLDB;
import comp3350.rose.model.Recipe;
import comp3350.rose.model.ShoppingList;

public class MyApplication extends Application {
    //Used to Change the repository type for the entire application
    private ArrayList<Recipe> sortedRecipes = new ArrayList<>();

    public ArrayList<Recipe> getSortedRecipes(){ return sortedRecipes; }

    public void setSortedRecipes(ArrayList<Recipe> recipes){
        sortedRecipes = recipes;
    }

    public void addToSortedRecipes(Recipe newRecipe){ sortedRecipes.add(newRecipe); }

    public DBInterface getRepository(Context context) {
        //DBInterface repository = RecipeDatabase.getInstance(context);
        DBInterface repository = StubDB.getInstance(context);
        return repository;
    }

    public DBSLInterface getSLRepository(Context context) {
//        DBSLInterface repository = ShoppingListDatabase.getInstance(context);
        DBSLInterface repository = StubSLDB.getInstance(context);
        return repository;
    }


}