package comp3350.rose;

import org.junit.*;

import android.content.Context;
import android.app.ListActivity;

import java.util.ArrayList;

import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;
import comp3350.rose.Database.RecipeDatabase;
import comp3350.rose.Business.MyApplication;

import static org.junit.Assert.*;

/**
* To work on Integration tests, switch the Test Artifact in the Build Variants view.
*/

public class ROSEIntegrationTest extends ListActivity {
    static MyApplication myApp = (MyApplication)new init().getApplication();
    static Context con;
    static StubDB stub;
    static RecipeDatabase db;
    static ArrayList<Recipe> dataB;
    static ArrayList<Recipe> stubby;

    @BeforeClass
    public static void setUpClass() throws Exception {
        con = myApp.getBaseContext();

        // Get Stub Database
        stub = StubDB.getInstance(con);
        // Get Database
        db = RecipeDatabase.getInstance(con);

        // Get ArrayList of Recipes from Regular and Stub Databases
        dataB = db.getList();
        stubby = stub.getList();
    }

    @Test
    protected void IntegrationTest() {

        for(int i=0; i<dataB.size(); i++) {
            assertSame("A Recipe loaded from the Database is not the same as a Recipe loaded from the Stub.", dataB.get(i), stubby.get(i));
        }

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // No Cleanup Necessary
    }

}
