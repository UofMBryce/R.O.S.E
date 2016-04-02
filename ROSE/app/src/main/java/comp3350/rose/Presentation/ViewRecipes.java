package comp3350.rose.Presentation;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.R;
import comp3350.rose.model.Recipe;

public class ViewRecipes extends ListActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipes);

        DBInterface repository = ((MyApplication)this.getApplication()).getRepository(this);

        ArrayList<Recipe> recipes = repository.getList();
        ((MyApplication)this.getApplication()).setSortedRecipes(recipes); //initialize sortedRecipes to full recipe list
        ArrayList<String> recipeDisplay = new ArrayList<>();
        for(int i=0; i<recipes.size(); i++) {
            recipeDisplay.add(recipes.get(i).getName());
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDisplay);
        lv = this.getListView();
        lv.setAdapter(myArrayAdapter);

    }

    @Override
    protected void onResume() { //TODO Flesh this out more
        //Same as the DetaiLView mode
        super.onResume();
        refreshList();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id){
        super.onListItemClick(l, v, pos, id);

        Intent myIntent = new Intent(this, Details.class);
        myIntent.putExtra("recipePosition", pos);
        startActivity(myIntent);
    }


    public void shoppingListButton(View view){
        startActivity(new Intent(this, SLDetails.class));
    }

    public void addRecipeButton(View view){
        startActivity(new Intent(this, AddRecipe.class));

        // Iteration 2:
        // Intent myIntent = new Intent(this, Edit.class);
        // myIntent.putExtra("editType", 1); // 1 corresponds to add recipe
        // startActivity(myIntent);
    }

    public void sortButton(View view){
        Intent myIntent = new Intent(this, SortRecipes.class);
        startActivity(myIntent);
    }

    private void refreshList(){//TODO Flesh this out more
        //Same as the DetailView mode
        //DBInterface repository = ((MyApplication)this.getApplication()).getRepository(this);

        ArrayList<Recipe> recipes = ((MyApplication)this.getApplication()).getSortedRecipes(); //refresh with sortedRecipes
        ArrayList<String> recipeDisplay = new ArrayList<>();
        for(int i=0; i<recipes.size(); i++) {
            recipeDisplay.add(recipes.get(i).getName());
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDisplay);
        lv = this.getListView();
        lv.setAdapter(myArrayAdapter);
    }

}
