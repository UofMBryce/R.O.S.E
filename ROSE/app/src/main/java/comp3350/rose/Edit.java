package comp3350.rose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    int recipePosition = 0;
    int editType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int editType = getIntent().getIntExtra("editType", 0);
        //editType == 1  will be add recipe
        //editType == 2  will be modify recipe
        //editType == 3  will be add to shopping list

        if(editType == 1){ // Add Recipe
            Toast.makeText(getApplicationContext(), "Add recipe not yet implemented!", Toast.LENGTH_LONG).show();
        }
        else if(editType == 2){ //Modify Recipe
            int recipePosition = getIntent().getIntExtra("recipePosition", 0);
            Recipe recipeToModify = StubDB.getRecipes().get(recipePosition);

            Toast.makeText(getApplicationContext(), "Modify recipe not yet implemented!", Toast.LENGTH_LONG).show();

        }else if(editType == 3){ // Add to Shopping List
            Toast.makeText(getApplicationContext(), "Add to shopping list not yet implemented!", Toast.LENGTH_LONG).show();

        }



    }
}
