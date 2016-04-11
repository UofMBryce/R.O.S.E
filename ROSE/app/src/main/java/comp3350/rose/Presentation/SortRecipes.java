package comp3350.rose.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import comp3350.rose.Business.Alphabetical;
import comp3350.rose.Business.MyApplication;
import comp3350.rose.Business.TopRated;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.R;
import comp3350.rose.model.Recipe;

public class SortRecipes extends AppCompatActivity {

    int mealTypePos;
    int sortTypePos;
    int mainIngredientPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_recipes);

        String[] mealTypes = new String[]{"ANY", "Breakfast", "Lunch", "Supper"};
        String[] mainIngredients = new String[]{"ANY", "Chicken", "Beef", "Turkey", "Pork"};
        String[] sortTypes = new String[]{"DEFAULT", "Alphabetical", "Top Rated"};

        Spinner mealtypespinner = (Spinner) findViewById(R.id.mealtypespinner);
        Spinner ingredientspinner = (Spinner) findViewById(R.id.ingredientspinner);
        Spinner sortspinner = (Spinner) findViewById(R.id.sortspinner);

        ArrayAdapter<String> mealtypeadapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, mealTypes);
        ArrayAdapter<String> ingredientadapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, mainIngredients);
        ArrayAdapter<String> sortadapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, sortTypes);

        mealtypespinner.setAdapter(mealtypeadapter);
        ingredientspinner.setAdapter(ingredientadapter);
        sortspinner.setAdapter(sortadapter);

        mealtypespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mealTypePos = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ingredientspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mainIngredientPos = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sortspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sortTypePos = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<Recipe> getMealTypeList(ArrayList<Recipe> allRecipes, String mealType)
    {
        ArrayList<Recipe> mealTypeList = new ArrayList<>();

        for(int i=0; i<allRecipes.size(); i++){
            if(allRecipes.get(i).getMealType().equals(mealType)){
                mealTypeList.add(allRecipes.get(i));
            }
        }

        return mealTypeList;
    }

    private ArrayList<Recipe> getMainIngredientList(ArrayList<Recipe> allRecipes, String mainIngredient)
    {
        ArrayList<Recipe> mainIngredientList = new ArrayList<>();

        for(int i=0; i<allRecipes.size(); i++){
            if(allRecipes.get(i).getMainIngredient() != null){
                if(allRecipes.get(i).getMainIngredient().equals(mainIngredient)){
                    mainIngredientList.add(allRecipes.get(i));
                }
            }
        }

        return mainIngredientList;
    }

    private ArrayList<Recipe> getSortedList(ArrayList<Recipe> mealTypeList, ArrayList<Recipe> mainIngredientList)
    {
        ArrayList<Recipe> sortedList = new ArrayList<>();

        for(int i=0; i<mealTypeList.size(); i++){
            for (int j=0; j<mainIngredientList.size(); j++){
                if(mealTypeList.get(i).getrID() == mainIngredientList.get(j).getrID()){
                    sortedList.add(mealTypeList.get(i));
                }
            }
        }

        return sortedList;
    }

    public void findRecipesButton(View view){
        ArrayList<Recipe> mainIngredientList = new ArrayList<>();
        ArrayList<Recipe> mealTypeList = new ArrayList<>();
        ArrayList<Recipe> sortedList = new ArrayList<>();

        DBInterface repository = ((MyApplication)this.getApplication()).getRepository(this);
        ArrayList<Recipe> allRecipes = repository.getList();

        //--------------------------------------------MEAL TYPE---------------------------------
        if(mealTypePos == 0){   // ANY Meal Type
            mealTypeList = allRecipes;
        }
        if(mealTypePos == 1){  // Breakfast Meal Type
            mealTypeList = getMealTypeList(allRecipes, "Breakfast");
        }
        if(mealTypePos == 2){  // Lunch Meal Type
            mealTypeList = getMealTypeList(allRecipes, "Lunch");
        }
        if(mealTypePos == 3){  // Supper Meal Type
            mealTypeList = getMealTypeList(allRecipes, "Supper");
        }
        //------------------------------------End of Meal Type--------------------------------------

        //------------------------------------------Main Ingredient---------------------------------
        if(mainIngredientPos == 0){   // ANY Main Ingredient
            mainIngredientList = allRecipes;
        }
        if(mainIngredientPos == 1){  // Chicken
            mainIngredientList = getMainIngredientList(allRecipes, "Chicken");
        }
        if(mainIngredientPos == 2){  // Beef
            mainIngredientList = getMainIngredientList(allRecipes, "Beef");
        }
        if(mainIngredientPos == 3){  // Turkey
            mainIngredientList = getMainIngredientList(allRecipes, "Turkey");
        }
        if(mainIngredientPos == 4){  // Pork
            mainIngredientList = getMainIngredientList(allRecipes, "Pork");
        }
        //------------------------------End of Main Ingredient--------------------------------------

        //sortedList contains only recipes in both mealType and mainIngredient lists
        sortedList = getSortedList(mealTypeList, mainIngredientList);

        //----------------------------------Sort Type-----------------------------------------------
        if(sortTypePos == 0){ //DEFAULT
        }
        if(sortTypePos == 1){ //Alphabetical
            Collections.sort(sortedList, new Alphabetical());
        }
        if(sortTypePos == 2){ //Top Rated
            Collections.sort(sortedList, new TopRated());
        }
        //-----------------------------End of Sort Type---------------------------------------------

        if(sortedList.size() > 0){
            ((MyApplication) this.getApplication()).setSortedRecipes(sortedList);
            this.finish();
        }else{
            Toast.makeText(getApplicationContext(), "Sorry no results match your criteria.", Toast.LENGTH_LONG).show();
        }
    }
}
