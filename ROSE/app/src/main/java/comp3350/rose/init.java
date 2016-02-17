package comp3350.rose;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class init extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        ArrayList<Recipe> recipes = StubDB.getRecipes();
        ArrayList<String> recipeDisplay = new ArrayList<>();
        for(int i=0; i<recipes.size(); i++) {
            recipeDisplay.add(recipes.get(i).getName());
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDisplay);
        ListView lv = this.getListView();
        lv.setAdapter(myArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id){
        super.onListItemClick(l, v, pos, id);

        Intent myIntent = new Intent(this, Details.class);
        myIntent.putExtra("recipePosition", pos);
        startActivity(myIntent);
    }

    public void shoppingListButton(View view){
        startActivity(new Intent(this, ShoppingList.class));
    }

    public void addRecipeButton(View view){
        Intent myIntent = new Intent(this, Edit.class);
        myIntent.putExtra("editType", 1); // 1 corresponds to add recipe
        startActivity(myIntent);
    }
}
