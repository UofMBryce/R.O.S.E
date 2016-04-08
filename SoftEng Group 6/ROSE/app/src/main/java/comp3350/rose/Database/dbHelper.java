package comp3350.rose.Database;

/**
 * Created by Bryce on 3/9/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import comp3350.rose.model.Recipe;
import comp3350.rose.model.ShoppingList;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ROSE.db";

    public dbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //Creates the Recipe Table which stores recipes
        String CREATE_TABLE_RECIPES = "CREATE TABLE " + Recipe.TABLE  +
                "(" + Recipe.KEY_rID + " INTEGER PRIMARY KEY, " +
                Recipe.KEY_name + " TEXT, " +
                Recipe.KEY_mealtype + " TEXT, " +
                Recipe.KEY_mainingredient + " TEXT, " +
                Recipe.KEY_description + " TEXT, " +
                Recipe.KEY_ingredients + " TEXT, " +
                Recipe.KEY_directions + " TEXT, " +
                Recipe.KEY_notes + " TEXT, " +
                Recipe.KEY_rating + " INTEGER, " +
                Recipe.KEY_cooktime + " INTEGER )";
        db.execSQL(CREATE_TABLE_RECIPES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Recipes" );
        db.execSQL("DROP TABLE IF EXISTS Menu" );
        onCreate(db);
    }
}
