package comp3350.rose.Stub;

import android.content.Context;

import java.util.ArrayList;

import comp3350.rose.model.Recipe;
import comp3350.rose.Controller.MenuInterface;

/**
 * Created by Bryce on 3/30/2016.
 */
public class StubMenu implements MenuInterface{
    private static StubMenu sInstance;
    private static Context sContext;

    //Makes it singleton
    public static synchronized StubMenu getInstance(Context context){
        if(sInstance == null){
            sInstance = new StubMenu(context.getApplicationContext());
        }
        return sInstance;
    }

    private StubMenu(Context context){
        sContext = context;
    }

    static String[] recipes = new String[3]; //Stores the Recipe Objects for outside access

      public void addBreakfast(String name){
//        Recipe temp = new Recipe();
//        temp.copy(recipe);
        recipes[0] = name;
        // String result;
        //result = "Add Completed";
        //Result in place for possible future implementation
    }
    public void addLunch(String name){
//        Recipe temp = new Recipe();
//        temp.copy(recipe);
        recipes[1] = name;
        // String result;
        //result = "Add Completed";
        //Result in place for possible future implementation
    }
    public void addSupper(String name){
//        Recipe temp = new Recipe();
//        temp.copy(recipe);
        recipes[2] = name;
        // String result;
        //result = "Add Completed";
        //Result in place for possible future implementation
    }

    public void deleteRecipes(){
        int x;

        for(x = 0; x < recipes.length; x++)
        {
            recipes[x] = null;
        }
//        if(flag)
//            result = "Deletion Completed";
//        else
//            result = "Deletion Failed";
        //Result in place for possible future implementation

    }

    public boolean hasBreakfast() {
        boolean result = false;
        if(recipes[0] != null)
            result = true;
        return result;
    }
    public boolean hasLunch() {
        boolean result = false;
        if(recipes[1] != null)
            result = true;
        return result;
    }
    public boolean hasSupper() {
        boolean result = false;
        if(recipes[2] != null)
            result = true;
        return result;
    }

    public String[] getList() {
        return recipes;
    }
}
