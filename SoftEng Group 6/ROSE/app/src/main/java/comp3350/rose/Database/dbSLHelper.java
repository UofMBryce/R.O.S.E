package comp3350.rose.Database;

/**
 * Created by JiqingDai on 2016-03-10.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import comp3350.rose.model.ShoppingList;


public class dbSLHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ROSE.db";

    public dbSLHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //Creates the Recipe Table which stores recipes
        String CREATE_TABLE_SHOPPINGLISTS = "CREATE TABLE " + ShoppingList.TABLE  +
                "(" + ShoppingList.KEY_sID + " INTEGER PRIMARY KEY, " +
                ShoppingList.KEY_name + " TEXT )";
        db.execSQL(CREATE_TABLE_SHOPPINGLISTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS shoppinglists" );
        onCreate(db);
    }
}

