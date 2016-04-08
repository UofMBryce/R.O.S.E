package comp3350.rose.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.R;

public class AddIngredients extends AppCompatActivity {
    ArrayList<String> ingredientsList = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredients);
        ingredientsList = getIntent().getStringArrayListExtra("IngredientsList");

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredientsList);
        lv = (ListView)findViewById(R.id.recipeIngredientsListView);
        lv.setAdapter(myArrayAdapter);
    }

    public void addIngredient(View view){
        String recipeIngredient = ((EditText)findViewById(R.id.recipeIngredientText)).getText().toString();
        ingredientsList.add(recipeIngredient);
        refreshIngredientsList();
        ((EditText)findViewById(R.id.recipeIngredientText)).setText("");
    }

    public void clearIngredientsList(View view){
        ingredientsList.clear();
        refreshIngredientsList();
        ((EditText)findViewById(R.id.recipeIngredientText)).setText("");
    }

    public void saveIngredientsList(View view){
        Intent myIntent = new Intent();
        myIntent.putStringArrayListExtra("IngredientsResult", ingredientsList);
        setResult(RESULT_OK, myIntent);
        finish();
    }

    public void cancelIngredientsButton(View view){
        finish();
    }

    private void refreshIngredientsList(){
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredientsList);
        lv = (ListView)findViewById(R.id.recipeIngredientsListView);
        lv.setAdapter(myArrayAdapter);
    }
}
