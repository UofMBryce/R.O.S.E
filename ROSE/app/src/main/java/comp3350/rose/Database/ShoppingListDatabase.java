package comp3350.rose.Database;

/**
 * Created by JiqingDai on 2016-03-10.
 */

import android.app.Activity;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import comp3350.rose.model.Recipe;
import comp3350.rose.model.ShoppingList;
import comp3350.rose.Database.dbSLHelper;
import comp3350.rose.Controller.DBSLInterface;

public class ShoppingListDatabase extends Activity implements DBSLInterface{
    private dbSLHelper Helper;
    private static ShoppingListDatabase sInstance;
    private static Context sContext;

    //Makes it singleton
    public static synchronized ShoppingListDatabase getInstance(Context context){
        if(sInstance == null){
            sInstance = new ShoppingListDatabase(context.getApplicationContext());
        }
        return sInstance;
    }

    private ShoppingListDatabase(Context context){
        Helper = new dbSLHelper(context);
        sContext = context;
        this.initializeDB();

    }

    @Override
    public void addShoppingList(ShoppingList sl)
    {
        SQLiteDatabase db = Helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ShoppingList.KEY_sID, sl.getsID());
        values.put(ShoppingList.KEY_name, sl.getName());

        db.insert(ShoppingList.TABLE, null, values);

        db.close();
    }

    @Override
    public void editShoppingList(ShoppingList sl)
    {
        SQLiteDatabase db = Helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ShoppingList.KEY_sID, sl.getsID());
        values.put(ShoppingList.KEY_name, sl.getName());


        int x = db.update(ShoppingList.TABLE, values, ShoppingList.KEY_sID + " = ?", new String[]{String.valueOf(sl.getsID())});
        db.close();
    }

    @Override
    public void deleteShoppingList(ShoppingList sl)
    {
        SQLiteDatabase db = Helper.getWritableDatabase();

        db.delete(ShoppingList.TABLE, ShoppingList.KEY_sID + " = ", new String[]{String.valueOf(sl.getsID())});
        db.close();
    }


    public ArrayList<ShoppingList> getList()
    {//Returns ArrayList for listview activities
        ArrayList<ShoppingList> result = new ArrayList<>();

        SQLiteDatabase db = Helper.getReadableDatabase();

        String selectQuery = ("SELECT * FROM " + ShoppingList.TABLE);

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                //Get Values for ShoppingList Object
                int sID = cursor.getInt(cursor.getColumnIndex(ShoppingList.KEY_sID));
                String name = cursor.getString(cursor.getColumnIndex(ShoppingList.KEY_name));

                //Create new shoppinglist from Row
                ShoppingList tempShoppingList = new ShoppingList(sID, name);
                //Add the shoppinglist to the ArrayList
                result.add(tempShoppingList);

            }while (cursor.moveToNext());
        }
        //Return the populated ArrayList for use
        return result;
    }


    //Fill Database wil initial values on first startup
    //not final solution; learning how to store a populated sql file on device and copy over
    private void initializeDB()
    {
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


}
