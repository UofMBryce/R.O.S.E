package comp3350.rose.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import comp3350.rose.R;

public class init extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    public void menuButton(View view){
        Toast.makeText(getApplicationContext(), "Currently in Development.", Toast.LENGTH_LONG).show();
    }

    public void viewRecipesButton(View view){
        Intent myIntent = new Intent(this, ViewRecipes.class);
        startActivity(myIntent);
    }

    public void viewShoppingListButton(View view){
        Intent myIntent = new Intent(this, SLDetails.class);
        startActivity(myIntent);
    }

}
