package comp3350.rose.Business;

/**
 * Created by Bryce on 3/10/2016.
 *
 * This Class is specifically used to change the repository being used. Making it an extension
 * of the application class allows it to be accessed throughout the app.
 */
import android.app.Application;
import android.support.v4.app.INotificationSideChannel;
import android.content.Context;

import comp3350.rose.Database.RecipeDatabase;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.Stub.StubDB;

public class MyApplication extends Application {
    //Used to Change the repository type for the entire application

    public DBInterface getRepository(Context context) {
        //DBInterface repository = RecipeDatabase.getInstance(context);
        DBInterface repository = StubDB.getInstance(context);
        return repository;
    }


}
