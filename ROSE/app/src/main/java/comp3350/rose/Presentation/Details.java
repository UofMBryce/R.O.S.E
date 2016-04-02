package comp3350.rose.Presentation;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import comp3350.rose.Controller.MenuInterface;
import comp3350.rose.R;
import comp3350.rose.model.Recipe;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.Business.MyApplication;
import comp3350.rose.Stub.StubMenu;

import java.util.ArrayList;

public class Details extends ListActivity {
    int recipePosition = 0;
    ListView lv;
    Recipe clickedRecipe;
    int menuPos = 0;
    MenuInterface menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        menu = ((MyApplication)this.getApplication()).getMenu(this);
        refreshList();

        String[] menuOptions = new String[]{"Add to...", "Breakfast", "Lunch", "Supper"};
        Spinner menuSpinner = (Spinner) findViewById(R.id.menuSpinner);
        ArrayAdapter<String> menuadapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, menuOptions);
        menuSpinner.setAdapter(menuadapter);
        menuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                menuPos = parent.getSelectedItemPosition();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
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
        clickedRecipe = ((MyApplication)this.getApplication()).getSortedRecipes().get(recipePosition); //use sorted list
        ArrayList<String> recipeDetails = new ArrayList<>();
        recipeDetails.add(clickedRecipe.getName());
        recipeDetails.add(clickedRecipe.getDescription());
        recipeDetails.add("----------Ingredients:");
        for(int i=0; i<clickedRecipe.getIngredients().size(); i++){
            recipeDetails.add(clickedRecipe.getIngredients().get(i));
        }
        recipeDetails.add("----------Instructions:");
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

    public void addMenu(View view){
        if(menuPos == 0)
        {
            Toast.makeText(getApplicationContext(), "Select a Meal Type", Toast.LENGTH_LONG).show();
        }
        else if(menuPos == 1)
        {
            menu.addBreakfast(clickedRecipe.getName());
            Toast.makeText(getApplicationContext(), "Added Breakfast", Toast.LENGTH_LONG).show();
        }
        else if(menuPos == 2)
        {
            menu.addLunch(clickedRecipe.getName());
            Toast.makeText(getApplicationContext(), "Added Lunch", Toast.LENGTH_LONG).show();
        }
        else if(menuPos == 3)
        {
            menu.addSupper(clickedRecipe.getName());
            Toast.makeText(getApplicationContext(), "Added Supper", Toast.LENGTH_LONG).show();
        }
    }
}
