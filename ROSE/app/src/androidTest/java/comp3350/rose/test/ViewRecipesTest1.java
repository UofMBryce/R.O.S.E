package comp3350.rose.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import comp3350.rose.Presentation.init;


public class ViewRecipesTest1 extends ActivityInstrumentationTestCase2<init> {
  	private Solo solo;

    public ViewRecipesTest1() {
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

	public void testViewRecipes() {
        //Wait for activity: 'comp3350.rose.Presentation.init'
		solo.waitForActivity(init.class, 2000);
        //Set default small timeout to 10064 milliseconds
		Timeout.setSmallTimeout(10064);
        //Click on RECIPES
		solo.clickOnView(solo.getView(comp3350.rose.R.id.recipe_button));
        //Wait for activity: 'comp3350.rose.Presentation.ViewRecipes'
		assertTrue("comp3350.rose.Presentation.ViewRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.ViewRecipes.class));
	}

    public void testViewRecipeDetails() {
		//Wait for activity: 'comp3350.rose.Presentation.init'
		solo.waitForActivity(init.class, 2000);
		//Set default small timeout to 10064 milliseconds
		Timeout.setSmallTimeout(10064);
		//Click on RECIPES
		solo.clickOnView(solo.getView(comp3350.rose.R.id.recipe_button));
		//Wait for activity: 'comp3350.rose.Presentation.ViewRecipes'
		assertTrue("comp3350.rose.Presentation.ViewRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.ViewRecipes.class));
		//Click on a recipe name
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
		//Wait for activity: 'comp3350.rose.Presentation.Details'
		assertTrue("comp3350.rose.Presentation.Details is not found!", solo.waitForActivity(comp3350.rose.Presentation.Details.class));

    }

}
