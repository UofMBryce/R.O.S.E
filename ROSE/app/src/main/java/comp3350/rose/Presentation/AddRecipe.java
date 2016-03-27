package comp3350.rose.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.R;
import comp3350.rose.model.Recipe;

public class AddRecipe extends AppCompatActivity {
    ArrayList<String> ingredientsList = new ArrayList<>();
    ArrayList<String> instructionsList = new ArrayList<>();
    static final int ADD_INGREDIENTS_REQUEST = 1;
    static final int ADD_INSTRUCTIONS_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
    }

    public void addIngredientsButton(View view){
        Intent myIntent = new Intent(this, AddIngredients.class);
        myIntent.putStringArrayListExtra("IngredientsList", ingredientsList);
        startActivityForResult(myIntent, ADD_INGREDIENTS_REQUEST);
    }

    public void addInstructionsButton(View view){
        Intent myIntent = new Intent(this, AddInstructions.class);
        myIntent.putStringArrayListExtra("InstructionsList", instructionsList);
        startActivityForResult(myIntent, ADD_INSTRUCTIONS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == ADD_INGREDIENTS_REQUEST) {
            if (resultCode == RESULT_OK) {
                ingredientsList = data.getStringArrayListExtra("IngredientsResult");
            }
        }
        else if (requestCode == ADD_INSTRUCTIONS_REQUEST) {
            if (resultCode == RESULT_OK) {
                instructionsList = data.getStringArrayListExtra("InstructionsResult");
            }
        }
    }

    public void SaveRecipeButton (View view) {
        // obtain text inside EditText object
        String recipeName = ((EditText)findViewById(R.id.recipeNameText)).getText().toString();
        String recipeDesc = ((EditText)findViewById(R.id.recipeDescText)).getText().toString();
        String recipeMealType = ((EditText)findViewById(R.id.recipeMealTypeText)).getText().toString();
        String recipeNotes = ((EditText)findViewById(R.id.recipeNotesText)).getText().toString();

        // create new recipe object and insert new data
        Recipe myRecipe = new Recipe();
        myRecipe.setName(recipeName);
        myRecipe.setDescription(recipeDesc);
        myRecipe.setMealType(recipeMealType);
        myRecipe.setIngredients(ingredientsList);
        myRecipe.setDirections(instructionsList);
        myRecipe.setNotes(recipeNotes);

        // obtain access to DB and insert recipe
        DBInterface repository = ((MyApplication)this.getApplication()).getRepository(this);
        repository.addRecipe(myRecipe);
        finish();
    }

    public void CancelRecipesButton(View view){
        finish();
    }
}
