package comp3350.rose.Database;

/**
 * Created by Bryce on 3/7/2016.
 */
import comp3350.rose.model.Recipe;
import java.util.ArrayList;
//import comp3350.rose.Database.dbHelper;
import android.database.sqlite.SQLiteDatabase;

public class RecipeDatabase implements DBInterface {

    public void addRecipe(Recipe recipe)
    {
    }

    public void editRecipe(Recipe recipe)
    {

    }

    public void deleteRecipe(Recipe recipe)
    {

    }

    public void updateList(ArrayList<Recipe> list)//may not be needed
    {

    }

    public ArrayList<Recipe> getList()
    {
        ArrayList<Recipe> result = new ArrayList<>();

        //create an arraylist from database entries

        return result;
    }
}
