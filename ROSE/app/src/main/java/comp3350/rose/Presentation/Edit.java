package comp3350.rose.Presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.Controller.DBSLInterface;
import comp3350.rose.R;
import comp3350.rose.model.Recipe;
import comp3350.rose.model.ShoppingList;

public class Edit extends AppCompatActivity {
    int recipePosition = 0;
    int editType = 0;
    int rID = 0;

    Recipe recipeToModify;
    String name = "";
    String description = "";
    ArrayList<String> ingredients = new ArrayList<String>();
    ArrayList<String> instructions = new ArrayList<String>();

    int changePosition;
    int ingredSID = 0, instruSID = 0;
    String input = "";

    int sID = -1;
    ShoppingList shoppingListToAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        //Get Database in order to acess the arraylist
        DBInterface repository = ((MyApplication) this.getApplication()).getRepository(this);
        final DBSLInterface slRepository = ((MyApplication) this.getApplication()).getSLRepository(this);

        editType = getIntent().getIntExtra("editType", 0);
         if(editType == 2){ //Modify Recipe
            recipePosition = getIntent().getIntExtra("recipePosition", 0);
            Recipe recipeToModify = ((MyApplication) this.getApplication()).getSortedRecipes().get(recipePosition);
            rID = recipeToModify.getrID();
            ArrayList<String> recipeDetails = new ArrayList<>();
            recipeDetails.add(recipeToModify.getName());
            recipeDetails.add(recipeToModify.getDescription());
            recipeDetails.add("----------Ingredients:");
            for(int i=0; i<recipeToModify.getIngredients().size(); i++){
                recipeDetails.add(recipeToModify.getIngredients().get(i));
            }
            recipeDetails.add("----------Instructions:");
            for(int i=0; i<recipeToModify.getDirections().size(); i++){
                recipeDetails.add(recipeToModify.getDirections().get(i));
            }

            ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDetails);
            ListView lv = (ListView) findViewById(R.id.editListField);
            lv.setAdapter(myArrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ListView lv = (ListView) findViewById(R.id.editListField);
                    EditText editField = (EditText) findViewById(R.id.editField);
                    changePosition = position;

                    for (int i = 0; i < lv.getAdapter().getCount(); i++) {
                        if (lv.getItemAtPosition(i).toString().contentEquals("----------Ingredients:")) {
                            ingredSID = i;
                        }
                        if (lv.getItemAtPosition(i).toString().contentEquals("----------Instructions:")) {
                            instruSID = i;
                        }
                    }

                    if (lv.getItemIdAtPosition(position) != ingredSID &&
                            lv.getItemIdAtPosition(position) != instruSID) {
                        editField.setText(lv.getItemAtPosition(position).toString());
                        input = editField.getText().toString();
                    }
                }
            });
//            Toast.makeText(getApplicationContext(), "Modify recipe not yet implemented!", Toast.LENGTH_LONG).show();

        }else if(editType == 3){ // Add to Shopping List
//            Toast.makeText(getApplicationContext(), "Add to shopping list not yet implemented!", Toast.LENGTH_LONG).show();
            ArrayList<ShoppingList> shoppingLists = slRepository.getShoppingList();
            ArrayList<String> shoppingDisplay = new ArrayList<String>();
            for (int i = 0; i < shoppingLists.size(); i++) {
                shoppingDisplay.add(shoppingLists.get(i).getName());
            }
            ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingDisplay);
            ListView lv = (ListView) findViewById(R.id.editListField);
            lv.setAdapter(myArrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ListView lv = (ListView) findViewById(R.id.editListField);
                    EditText editField = (EditText) findViewById(R.id.editField);
                    changePosition = position;

                    ArrayList<ShoppingList> shoppingLists = slRepository.getShoppingList();
                    sID = shoppingLists.get(changePosition).getsID();
                    editField.setText(lv.getItemAtPosition(position).toString());
                }
            });
        }
    }

    public void saveClick(View view) {
        if (editType == 2) {
            ListView lv = (ListView) findViewById(R.id.editListField);
            EditText editField = (EditText) findViewById(R.id.editField);
            input = editField.getText().toString();
          if(input.length() == 0){
              Toast.makeText(getApplicationContext(), "Please correctly choose a field and replace its contents.", Toast.LENGTH_LONG).show();
          }else{
              if (changePosition == 0) {
                 changeName(lv);
              } else if (changePosition == 1) {
                 changeDesc(lv);
              } else if (changePosition > ingredSID && changePosition < instruSID) {
                changeIng(lv);
              } else if (changePosition > instruSID) {
                 changeIns(lv);
              }
              submitRecipe();
              finish();
          }
        }
        else if (editType == 3) {
            editShopList();
            finish();
        }
    }

    public void editShopList(){
        EditText editField = (EditText) findViewById(R.id.editField);
        input = editField.getText().toString();
        name = input;

        //get Database object to perform update method
        DBSLInterface repository = ((MyApplication) this.getApplication()).getSLRepository(this);

        if ( sID == -1 ) {
            shoppingListToAdd = new ShoppingList(name);
            repository.addShoppingList(shoppingListToAdd);
        }
        else {
            shoppingListToAdd = new ShoppingList(sID, name);
            repository.editShoppingList(shoppingListToAdd);
        }
        Toast.makeText(getApplicationContext(), "Update to database", Toast.LENGTH_LONG).show();
    }
    public void submitRecipe(){
        DBInterface repository = ((MyApplication) this.getApplication()).getRepository(this);

        recipeToModify = new Recipe(rID, name, description, ingredients, instructions);
        repository.editRecipe(recipeToModify);
        Toast.makeText(getApplicationContext(), "Update to database", Toast.LENGTH_LONG).show();
    }
    public void changeName(ListView lv){
        name = input;
        description = lv.getAdapter().getItem(1).toString();
        for (int i = ingredSID + 1; i < instruSID; i++) {
            ingredients.add(lv.getAdapter().getItem(i).toString());
        }
        for (int i = instruSID + 1; i < lv.getAdapter().getCount(); i++) {
            instructions.add(lv.getAdapter().getItem(i).toString());
        }
    }
    public void changeDesc(ListView lv){
        name = lv.getAdapter().getItem(0).toString();
        description = input;
        for (int i = ingredSID + 1; i < instruSID; i++) {
            ingredients.add(lv.getAdapter().getItem(i).toString());
        }
        for (int i = instruSID + 1; i < lv.getAdapter().getCount(); i++) {
            instructions.add(lv.getAdapter().getItem(i).toString());
        }
    }
    public void changeIng(ListView lv){
        name = lv.getAdapter().getItem(0).toString();
        description = lv.getAdapter().getItem(1).toString();
        for (int i = ingredSID + 1; i < instruSID; i++) {
            if (i == changePosition) {
                ingredients.add(input);
            } else {
                ingredients.add(lv.getAdapter().getItem(i).toString());
            }
        }
        for (int i = instruSID + 1; i < lv.getAdapter().getCount(); i++) {
            instructions.add(lv.getAdapter().getItem(i).toString());
        }
    }
    public void changeIns(ListView lv){
        name = lv.getAdapter().getItem(0).toString();
        description = lv.getAdapter().getItem(1).toString();
        for (int i = ingredSID + 1; i < instruSID; i++) {
            ingredients.add(lv.getAdapter().getItem(i).toString());
        }
        for (int i = instruSID + 1; i < lv.getAdapter().getCount(); i++) {
            if (i == changePosition) {
                instructions.add(input);
            } else {
                instructions.add(lv.getAdapter().getItem(i).toString());
            }
        }
    }

}
