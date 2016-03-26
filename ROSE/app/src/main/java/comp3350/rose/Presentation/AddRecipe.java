package comp3350.rose.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.R;
import comp3350.rose.model.Recipe;

public class AddRecipe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
    }

    protected void onResume(){
        super.onResume();
    }

    public void addIngredientsButton(View view){
        startActivity(new Intent(this, AddIngredients.class));
    }

    public void addInstructionsButton(View view){
        startActivity(new Intent(this, AddInstructions.class));
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
        myRecipe.setNotes(recipeNotes);

        // obtain access to DB and insert recipe
        DBInterface repository = ((MyApplication)this.getApplication()).getRepository(this);
        repository.addRecipe(myRecipe);
        finish();
    }

    public void CancelButton(View view){
        finish();
    }
}
