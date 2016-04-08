package comp3350.rose.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comp3350.rose.R;

public class init extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    public void menuButton(View view){
        Intent myIntent = new Intent(this, MenuViewer.class);
        startActivity(myIntent);
    }

    public void viewRecipesButton(View view){
        Intent myIntent = new Intent(this, ViewRecipes.class);
        myIntent.putExtra("ViewType", 1);
        startActivity(myIntent);
    }

    public void viewShoppingListButton(View view){
        Intent myIntent = new Intent(this, SLDetails.class);
        startActivity(myIntent);
    }

    public void searchButton(View view){
        Intent myIntent = new Intent(this, ViewRecipes.class);
        EditText searchField = (EditText) findViewById(R.id.search_field);
        String input = searchField.getText().toString();
        if (input.compareTo("") != 0) {
            myIntent.putExtra("ViewType", 2);
            myIntent.putExtra("SearchField", input);
        }
        else {
            myIntent.putExtra("ViewType", 1);
        }
        startActivity(myIntent);
    }

}
