package comp3350.rose.Controller;

/**
 * Created by Bryce on 3/7/2016.
 */
import comp3350.rose.model.Recipe;
import java.util.ArrayList;

public interface DBInterface {
    public void addRecipe(Recipe recipe);
    public void deleteRecipe(Recipe recipe);
    public void editRecipe(Recipe recipe);
    public ArrayList<Recipe> getList();
}
