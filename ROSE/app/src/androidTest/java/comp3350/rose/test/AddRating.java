package comp3350.rose.test;

import comp3350.rose.Presentation.init;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class AddRating extends ActivityInstrumentationTestCase2<init> {
  	private Solo solo;
	private static final String MEAL = "Spaghetti & Meatsauce";

	public AddRating() {
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
  
	public void testAddRating() {
        //Wait for activity: 'comp3350.rose.Presentation.init'
		solo.waitForActivity(comp3350.rose.Presentation.init.class, 2000);
        //Click on RECIPES
		solo.clickOnView(solo.getView(comp3350.rose.R.id.recipe_button));
        //Wait for activity: 'comp3350.rose.Presentation.ViewRecipes'
		assertTrue("comp3350.rose.Presentation.ViewRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.ViewRecipes.class));
        //Set default small timeout to 15172 milliseconds
		Timeout.setSmallTimeout(15172);
        //Scroll to Spaghetti & Meatsauce
		android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
		solo.scrollListToLine(listView0, 0);
        //Click on Spaghetti & Meatsauce
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350.rose.Presentation.Details'
		assertTrue("comp3350.rose.Presentation.Details is not found!", solo.waitForActivity(comp3350.rose.Presentation.Details.class));
        //Click on comp3350.rose.R.id.ratingSpinner
		solo.clickOnView(solo.getView(comp3350.rose.R.id.ratingSpinner));
        //Click on android.R$id.text1
		solo.clickOnView(solo.getView(android.R.id.text1, 26));
        //Click on Add Rating
		solo.clickOnView(solo.getView(comp3350.rose.R.id.addRating));
        //Press menu back key
		solo.goBack();
        //Click on SORT
		solo.clickOnView(solo.getView(comp3350.rose.R.id.button5));
        //Wait for activity: 'comp3350.rose.Presentation.SortRecipes'
		assertTrue("comp3350.rose.Presentation.SortRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.SortRecipes.class));
        //Click on ANY
		solo.clickOnView(solo.getView(comp3350.rose.R.id.mealtypespinner));
        //Click on Supper
		solo.clickOnView(solo.getView(android.R.id.text1, 16));
        //Click on ANY
		solo.clickOnView(solo.getView(comp3350.rose.R.id.ingredientspinner));
        //Click on Beef
		solo.clickOnView(solo.getView(android.R.id.text1, 15));
        //Click on DEFAULT
		solo.clickOnView(solo.getView(comp3350.rose.R.id.sortspinner));
        //Click on Top Rated
		solo.clickOnView(solo.getView(android.R.id.text1, 15));
        //Click on FIND RECIPES
		solo.clickOnView(solo.getView(comp3350.rose.R.id.button4));
		boolean isThere = solo.searchText(MEAL);
		assertTrue("Recipe Found", isThere);
	}
}
