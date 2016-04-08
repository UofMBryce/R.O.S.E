package comp3350.rose.Presentation;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.Controller.MenuInterface;
import comp3350.rose.Database.MenuDatabase;
import comp3350.rose.R;
import comp3350.rose.Stub.StubMenu;
import comp3350.rose.model.Recipe;

public class MenuViewer extends ListActivity {

    MenuInterface menu;
    ListView lv;
    String[] items = new String[] {"Breakfast", "Lunch", "Supper"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_viewer);
        refreshList();
    }

    @Override
    protected void onResume() { //TODO Flesh this out more
        //Same as the DetaiLView mode
        super.onResume();
        refreshList();
    }

    private void refreshList() {//TODO Flesh this out more
        //Same as the DetailView mode
        menu = ((MyApplication)this.getApplication()).getMenu(this);

        if(menu.hasBreakfast()) {
            items[0] = menu.getList()[0];
        }
        if(menu.hasLunch()){
            items[1] = menu.getList()[1];
        }
        if(menu.hasSupper()){
            items[2] = menu.getList()[2];
        }
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);
        lv = this.getListView();
        lv.setAdapter(listAdapter);
    }

    public void clearList(View view){
        menu = ((MyApplication)this.getApplication()).getMenu(this);
        menu.deleteRecipes();
        refreshList();
        recreate();
    }
}