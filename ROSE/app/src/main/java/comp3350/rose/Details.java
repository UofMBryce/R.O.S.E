package comp3350.rose;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import comp3350.rose.Database.RecipeDatabase;
import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;
import comp3350.rose.Controller.DBInterface;
import java.util.ArrayList;

public class Details extends ListActivity {
    int recipePosition = 0;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //DBInterface repository = RecipeDatabase.getInstance(this);
        DBInterface repository = StubDB.getInstance(this);


        recipePosition = getIntent().getIntExtra("recipePosition", 0);
        Recipe clickedRecipe = repository.getList().get(recipePosition);
        ArrayList<String> recipeDetails = new ArrayList<>();
        recipeDetails.add(clickedRecipe.getName());
        recipeDetails.add(clickedRecipe.getDescription());
        recipeDetails.add("Ingredients:");
        for(int i=0; i<clickedRecipe.getIngredients().size(); i++){
            recipeDetails.add(clickedRecipe.getIngredients().get(i));
        }
        recipeDetails.add("Instructions:");
        for(int i=0; i<clickedRecipe.getDirections().size(); i++){
            recipeDetails.add(clickedRecipe.getDirections().get(i));
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDetails);
        lv = this.getListView();
        lv.setAdapter(myArrayAdapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        refreshList();
        Log.d("INFO", "Details onResume called");
    }

    private void refreshList(){
        //DBInterface repository = RecipeDatabase.getInstance(this);
        DBInterface repository = StubDB.getInstance(this);


        recipePosition = getIntent().getIntExtra("recipePosition", 0);
        Recipe clickedRecipe = repository.getList().get(recipePosition);
        ArrayList<String> recipeDetails = new ArrayList<>();
        recipeDetails.add(clickedRecipe.getName());
        recipeDetails.add(clickedRecipe.getDescription());
        recipeDetails.add("Ingredients:");
        for(int i=0; i<clickedRecipe.getIngredients().size(); i++){
            recipeDetails.add(clickedRecipe.getIngredients().get(i));
        }
        recipeDetails.add("Instructions:");
        for(int i=0; i<clickedRecipe.getDirections().size(); i++){
            recipeDetails.add(clickedRecipe.getDirections().get(i));
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDetails);
        lv = this.getListView();
        lv.setAdapter(myArrayAdapter);

    }

    public void editButton(View view){
        Intent myIntent = new Intent(this, Edit.class);
        myIntent.putExtra("recipePosition", recipePosition);
        myIntent.putExtra("editType", 2); // 2 corresponds to modify recipe
        startActivity(myIntent);
    }
}
