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
import comp3350.rose.Business.MyApplication;

import java.util.ArrayList;

public class Details extends ListActivity {
    int recipePosition = 0;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Get Database object in order to get ArrayList of stored items
        DBInterface repository = ((MyApplication) this.getApplication()).getRepository(this);

        recipePosition = getIntent().getIntExtra("recipePosition", 0);
        Recipe clickedRecipe = ((MyApplication)this.getApplication()).getSortedRecipes().get(recipePosition); //use sorted list
        ArrayList<String> recipeDetails = new ArrayList<String>();
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
    protected void onResume(){ //TODO flesh this out more.
        // The idea is to update the arraylist that is displaying data on every change/add
        super.onResume();
        refreshList();
    }

    private void refreshList(){ //TODO Flesh this out more
        //I just kind of guessed on how its supposed to work. Maybe somebody with more GUI experience
        //Can make any changes that need to be done
        DBInterface repository = ((MyApplication) this.getApplication()).getRepository(this);

        recipePosition = getIntent().getIntExtra("recipePosition", 0);
        Recipe clickedRecipe = ((MyApplication)this.getApplication()).getSortedRecipes().get(recipePosition); //use sorted list
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
