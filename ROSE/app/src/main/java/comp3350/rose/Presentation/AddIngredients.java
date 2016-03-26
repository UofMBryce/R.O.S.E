package comp3350.rose.Presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.R;

public class AddIngredients extends AppCompatActivity {
    ArrayList<String> IngredientsList = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients);

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, IngredientsList);
        lv = (ListView)findViewById(R.id.recipeIngredientsListView);
        lv.setAdapter(myArrayAdapter);
    }

    public void addIngredient(View view){
        String recipeIngredient = ((EditText)findViewById(R.id.recipeIngredientText)).getText().toString();
        IngredientsList.add(recipeIngredient);
        refreshList();
    }

    public void clearIngredientsList(View view){
        IngredientsList.clear();
        refreshList();
    }

    private void refreshList(){
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, IngredientsList);
        lv = (ListView)findViewById(R.id.recipeIngredientsListView);
        lv.setAdapter(myArrayAdapter);
    }
}
