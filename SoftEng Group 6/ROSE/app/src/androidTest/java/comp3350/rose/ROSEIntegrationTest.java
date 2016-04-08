package comp3350.rose;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.junit.*;

import android.content.Context;
import android.app.ListActivity;
import android.util.Log;

import java.util.ArrayList;

import comp3350.rose.Controller.DBInterface;
import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;
import comp3350.rose.Database.RecipeDatabase;
import comp3350.rose.Business.MyApplication;
import comp3350.rose.Controller.DBInterface;
import comp3350.rose.model.Recipe;
import comp3350.rose.Stub.StubDB;

import dalvik.annotation.TestTargetClass;
import static org.junit.Assert.*;

/**
 * To work on Integration tests, switch the Test Artifact in the Build Variants view.
 */
public class ROSEIntegrationTest {
    static Context con;
    static StubDB stub;
    static RecipeDatabase db;
    static ArrayList<Recipe> dataB;
    static ArrayList<Recipe> stubby;

    @BeforeClass
    public static void setUpClass() throws Exception {
        con = MyApplication.getAppContext();
        stub = StubDB.getInstance(con);

        db = RecipeDatabase.getInstance(con);

        dataB = db.getList();
        stubby = stub.getList();
    }

    @Test
    protected void IntegrationTest(Bundle savedInstanceState) {

        assertEquals("Recipes loaded from Database are not the same as those loaded from Stub.", dataB, stubby);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // No Cleanup Necessary
    }


}
