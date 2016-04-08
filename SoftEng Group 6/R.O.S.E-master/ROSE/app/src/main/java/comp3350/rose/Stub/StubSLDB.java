package comp3350.rose.Stub;

/**
 * Created by JiqingDai on 2016-03-13.
 */

import android.content.Context;
import java.util.ArrayList;
import comp3350.rose.Controller.DBSLInterface;
import comp3350.rose.model.ShoppingList;

public class StubSLDB implements DBSLInterface{
    private static StubSLDB sInstance;
    private static Context sContext;

    //Makes it singleton
    public static synchronized StubSLDB getInstance(Context context){
        if(sInstance == null){
            sInstance = new StubSLDB(context.getApplicationContext());
        }
        return sInstance;
    }

    private StubSLDB(Context context){
        sContext = context;
        this.initializeShoppingLists();

    }

    static ArrayList<ShoppingList> shoppingLists = new ArrayList<>(); //Stores the Recipe Objects for outside access



    public void initializeShoppingLists(){
//-----------------------------------------------------------------------------------------------------------------------------------

        ShoppingList sl1 = new ShoppingList(1, "Carrots");
        ShoppingList sl2 = new ShoppingList(2, "Butter");
        ShoppingList sl3 = new ShoppingList(3, "Bacon");
        ShoppingList sl4 = new ShoppingList(4, "Jello");

//--------------------------------------------------------------------------------------------------------------------------------------
        this.addShoppingList(sl1);
        this.addShoppingList(sl2);
        this.addShoppingList(sl3);
        this.addShoppingList(sl4);
    }

    public void addShoppingList(ShoppingList shoppingList){
        shoppingLists.add(shoppingList);
        String result;
        //result = "Add Completed";
        //Result in place for possible future implementation
    }

    public void editShoppingList(ShoppingList newShoppingList){
        int x;
        boolean flag = false;
        String result;

        for(x = 0; x < shoppingLists.size(); x++)
        {
            if(shoppingLists.get(x).equals(newShoppingList)) {
                shoppingLists.set(x, newShoppingList);
                flag = true;
            }
        }
//        if(flag)
//            result = "Update Completed";
//        else
//            result = "Update Failed";
        //Result in place for possible future implementation

    }

    public void deleteShoppingList(ShoppingList shoppingList){
        int x;
        boolean flag = false;
        String result;

        for(x = 0; x < shoppingLists.size(); x++)
        {
            if(shoppingLists.get(x).equals(shoppingList)) {
                shoppingLists.remove(x);
                flag = true;
            }
        }
//        if(flag)
//            result = "Deletion Completed";
//        else
//            result = "Deletion Failed";
        //Result in place for possible future implementation

    }
    @Override
    public ArrayList<ShoppingList> getShoppingList() {
        return shoppingLists;
    }

}