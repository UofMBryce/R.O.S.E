package comp3350.rose.Database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import comp3350.rose.Controller.MenuInterface;

/**
 * Created by Bryce on 3/31/2016.
 */
public class MenuDatabase extends Activity implements MenuInterface {
    private menuHelper Helper;
    private static MenuDatabase sInstance;
    private static Context sContext;

    //Makes it singleton
    public static synchronized MenuDatabase getInstance(Context context){
        if(sInstance == null){
            sInstance = new MenuDatabase(context.getApplicationContext());
        }
        return sInstance;
    }

    private MenuDatabase(Context context){
        Helper = new menuHelper(context);
        sContext = context;
    }

    public void addBreakfast(String name)
    {
        SQLiteDatabase db = Helper.getWritableDatabase();

        db.execSQL("INSERT OR REPLACE into Menu (recipeName, mealType) values (\'" + name + "\', \'BREAKFAST\')");
        db.close();
    }
    public boolean hasBreakfast()
    {
        SQLiteDatabase db = Helper.getWritableDatabase();
        boolean result = false;
        Cursor cursor = null;
        String sql = "SELECT * from Menu where mealType = \"BREAKFAST\"";
        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0)
            result = true;
        cursor.close();
        db.close();
        return result;
    }
    public void addLunch(String name)
    {
        SQLiteDatabase db = Helper.getWritableDatabase();

        db.execSQL("INSERT OR REPLACE into Menu (recipeName, mealType) values (\'" + name + "\', \'LUNCH\')");
        db.close();
    }
    public boolean hasLunch()
    {
        SQLiteDatabase db = Helper.getWritableDatabase();
        boolean result = false;
        Cursor cursor = null;
        String sql = "SELECT * from Menu where mealType = \"LUNCH\"";
        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0)
            result = true;
        cursor.close();
        db.close();
        return result;
    }
    public void addSupper(String name)
    {
        SQLiteDatabase db = Helper.getWritableDatabase();

        db.execSQL("INSERT OR REPLACE into Menu (recipeName, mealType) values (\'" + name + "\', \'SUPPER\')");
        db.close();
    }
    public boolean hasSupper()
    {
        SQLiteDatabase db = Helper.getWritableDatabase();
        boolean result = false;
        Cursor cursor = null;
        String sql = "SELECT * from Menu where mealType = \"SUPPER\"";
        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0)
            result = true;
        cursor.close();
        db.close();
        return result;
    }
    public void deleteRecipes()
    {
        SQLiteDatabase db = Helper.getWritableDatabase();
        String sql = "DELETE FROM Menu";
        db.execSQL(sql);
        db.close();
    }
    public String[] getList()
    {
        SQLiteDatabase db = Helper.getWritableDatabase();

        String[] items = new String[3];
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT recipeName from Menu where mealType = \"BREAKFAST\"", null);
        if(cursor.moveToFirst())
        {
            items[0] = cursor.getString(cursor.getColumnIndex("recipeName"));
        }
        else
        cursor = db.rawQuery("SELECT recipeName from Menu where mealType = \"LUNCH\"", null);
        if(cursor.moveToFirst())
        {
            items[1] = cursor.getString(cursor.getColumnIndex("recipeName"));
        }
        else
        cursor = db.rawQuery("SELECT recipeName from Menu where mealType = \"SUPPER\"", null);
        if(cursor.moveToFirst())
        {
            items[2] = cursor.getString(cursor.getColumnIndex("recipeName"));
        }
        else
        cursor.close();
        db.close();

        return items;
    }
}

