package comp3350.rose;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBSLInterface;
import comp3350.rose.model.ShoppingList;

public class SLDetails extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        DBSLInterface repository = ((MyApplication)this.getApplication()).getSLRepository(this);


        ArrayList<ShoppingList> shoppingLists = repository.getShoppingList();
        ArrayList<String> shoppingDisplay = new ArrayList<String>();
        for (int i = 0; i < shoppingLists.size(); i++) {
            shoppingDisplay.add(shoppingLists.get(i).getName());
        }
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingDisplay);
        ListView lv = this.getListView();
        lv.setAdapter(myArrayAdapter);
    }

    public void addButton(View view){
        Intent myIntent = new Intent(this, Edit.class);
        myIntent.putExtra("editType", 3); //3 corresponds to add to shopping list
        startActivity(myIntent);
    }
}
