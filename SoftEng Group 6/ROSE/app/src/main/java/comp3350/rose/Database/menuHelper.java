package comp3350.rose.Database;

/**
 * Created by Bryce on 3/31/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import comp3350.rose.model.Recipe;
import comp3350.rose.model.ShoppingList;

public class menuHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ROSE.db";

    public menuHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_MENU = "CREATE TABLE Menu ( recipeName TEXT, mealType TEXT PRIMARY KEY)";
        db.execSQL(CREATE_TABLE_MENU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Menu" );
        onCreate(db);
    }
}