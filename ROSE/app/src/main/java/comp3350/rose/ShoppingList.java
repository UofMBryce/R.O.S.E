package comp3350.rose;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.Stub.StubDB;

public class ShoppingList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        ArrayList<String> shoppingDisplay = StubDB.getShoppingList();
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
