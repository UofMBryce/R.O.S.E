package comp3350.rose.test;

import comp3350.rose.Presentation.init;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class MenuViewTest1 extends ActivityInstrumentationTestCase2<init> {
  	private Solo solo;
    private static final String MEAL = "Turkey Sandwhich";

    public MenuViewTest1() {
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
  
	public void testAddtoMenu() {
        //Wait for activity: 'comp3350.rose.Presentation.init'
		solo.waitForActivity(comp3350.rose.Presentation.init.class, 2000);
        //Set default small timeout to 10064 milliseconds
		Timeout.setSmallTimeout(10064);
        //Click on RECIPES
		solo.clickOnView(solo.getView(comp3350.rose.R.id.recipe_button));
        //Wait for activity: 'comp3350.rose.Presentation.ViewRecipes'
		assertTrue("comp3350.rose.Presentation.ViewRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.ViewRecipes.class));
        //Click on Turkey Sandwhich
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Wait for activity: 'comp3350.rose.Presentation.Details'
		assertTrue("comp3350.rose.Presentation.Details is not found!", solo.waitForActivity(comp3350.rose.Presentation.Details.class));
        //Click on Add to...
		solo.clickOnView(solo.getView(comp3350.rose.R.id.menuSpinner));
        //Click on Lunch
		solo.clickOnView(solo.getView(android.R.id.text1, 23));
        //Click on Add to Menu
		solo.clickOnView(solo.getView(comp3350.rose.R.id.addMenu));
        //Set default small timeout to 14363 milliseconds
		Timeout.setSmallTimeout(14363);
        //Press menu back key
		solo.goBack();
        //Press menu back key
		solo.goBack();
        //Click on MENU
		solo.clickOnView(solo.getView(comp3350.rose.R.id.menu_button));
        //Wait for activity: 'comp3350.rose.Presentation.MenuViewer'
		assertTrue("comp3350.rose.Presentation.MenuViewer is not found!", solo.waitForActivity(comp3350.rose.Presentation.MenuViewer.class));
        boolean inSlot = solo.searchText(MEAL);
		assertTrue("Recipe Found", inSlot);
	}

    public void testClearMenu() {
        //Wait for activity: 'comp3350.rose.Presentation.init'
        solo.waitForActivity(comp3350.rose.Presentation.init.class, 2000);
        //Click on RECIPES
        solo.clickOnView(solo.getView(comp3350.rose.R.id.recipe_button));
        //Wait for activity: 'comp3350.rose.Presentation.ViewRecipes'
        assertTrue("comp3350.rose.Presentation.ViewRecipes is not found!", solo.waitForActivity(comp3350.rose.Presentation.ViewRecipes.class));
        //Click on Turkey Sandwhich
        solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Wait for activity: 'comp3350.rose.Presentation.Details'
        assertTrue("comp3350.rose.Presentation.Details is not found!", solo.waitForActivity(comp3350.rose.Presentation.Details.class));
        //Click on Add to...
        solo.clickOnView(solo.getView(comp3350.rose.R.id.menuSpinner));
        //Click on Lunch
        solo.clickOnView(solo.getView(android.R.id.text1, 23));
        //Click on Add to Menu
        solo.clickOnView(solo.getView(comp3350.rose.R.id.addMenu));
        //Press menu back key
        solo.goBack();
        //Press menu back key
        solo.goBack();
        //Click on MENU
        solo.clickOnView(solo.getView(comp3350.rose.R.id.menu_button));
        //Wait for activity: 'comp3350.rose.Presentation.MenuViewer'
        assertTrue("comp3350.rose.Presentation.MenuViewer is not found!", solo.waitForActivity(comp3350.rose.Presentation.MenuViewer.class));
        //Click on Clear List
        solo.clickOnView(solo.getView(comp3350.rose.R.id.button6));
        //Wait for activity: 'comp3350.rose.Presentation.MenuViewer'
        assertTrue("comp3350.rose.Presentation.MenuViewer is not found!", solo.waitForActivity(comp3350.rose.Presentation.MenuViewer.class));
        boolean inSlot = solo.searchText(MEAL);
        assertFalse("Recipe still in menu", inSlot);
    }

}
