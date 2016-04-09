package comp3350.rose.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import comp3350.rose.Presentation.init;
import comp3350.rose.R;


public class ViewShoppingListTest1 extends ActivityInstrumentationTestCase2<init> {
  	private Solo solo;

    public ViewShoppingListTest1() {
		super(init.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}

   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}

	public void testViewShoppingList() {
        //Wait for activity: 'comp3350.rose.Presentation.init'
		solo.waitForActivity(init.class, 2000);
        //Set default small timeout to 10064 milliseconds
		Timeout.setSmallTimeout(10064);
        //Click on Shopping List
		solo.clickOnView(solo.getView(R.id.shopping_button));
        //Wait for activity: 'comp3350.rose.Presentation.SLDetails'
		assertTrue("comp3350.rose.Presentation.SLDetails is not found!", solo.waitForActivity(comp3350.rose.Presentation.SLDetails.class));
		//Press back key
		solo.goBack();
		Timeout.setSmallTimeout(10064);
		//Click on Recipes
		solo.clickOnView(solo.getView(comp3350.rose.R.id.recipe_button));
		//Wait for activity: 'comp3350.rose.Presentation.ViewRecipes'
		assertTrue("comp3350.rose.Presentation.ViewRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.ViewRecipes.class));
		//Click on Shopping List
		solo.clickOnView(solo.getView(R.id.button));
		//Wait for activity: 'comp3350.rose.Presentation.SLDetails'
		assertTrue("comp3350.rose.Presentation.SLDetails is not found!", solo.waitForActivity(comp3350.rose.Presentation.SLDetails.class));
		//Click on Manage
		solo.clickOnView(solo.getView(R.id.button2));
		//Wait for activity: 'comp3350.rose.Presentation.Edit'
		assertTrue("comp3350.rose.Presentation.EditShoppingList is not found!", solo.waitForActivity(comp3350.rose.Presentation.Edit.class));
    }

}
