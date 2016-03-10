package comp3350.rose.model;

/**
 * Created by Bryce on 3/7/2016.
 */

import java.util.ArrayList;

public class Recipe {
    //Table Name
    public static final String TABLE = "Recipes";
    //Labels
    public static final String KEY_rID = "RecipeID";
    public static final String KEY_name = "Recipe_Name";
    public static final String KEY_mealtype = "Meal_Type";
    public static final String KEY_mainingredient = "Main_Ingredient";
    public static final String KEY_rating = "Rating";
    public static final String KEY_description = "Description";
    public static final String KEY_ingredients = "Ingredients";
    public static final String KEY_directions = "Directions";
    public static final String KEY_cooktime = "Cook_Time";
    public static final String KEY_notes = "Notes";

    //Attributes
    static int rID_Counter = 1;
    private int rID;
    private String name;
    private String mealType;
    private String mainIngredient;
    private int rating;
    private String description;
    private ArrayList<String> ingredients;
    private ArrayList<String> directions;
    private int cooktime;
    private String notes;

    public Recipe()
    { //Null Constructor
        rID = rID_Counter++;
        ingredients = null;
        directions = null;
        name = null;
        description = null;
    }

    public Recipe(String name, String description, ArrayList<String> ingredients, ArrayList<String> directions)
    {//Basic Constructor
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<String>();
        for(String p : ingredients)
            this.ingredients.add(p);
        this.directions = new ArrayList<String>();
        for(String p : directions)
            this.directions.add(p);
        rID = rID_Counter++;
    }
    public Recipe(int rID, String name, String description, ArrayList<String> ingredients, ArrayList<String> directions)
    {//Basic Constructor for Edit Call
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<String>();
        for(String p : ingredients)
            this.ingredients.add(p);
        this.directions = new ArrayList<String>();
        for(String p : directions)
            this.directions.add(p);
        this.rID = rID;
    }

    public Recipe(String name, String description, ArrayList<String> ingredients, ArrayList<String> directions, String mainIngredient)
    {//Constructor with mainIngredient
        this.name = name;
        this.description = description;
        this.mainIngredient = mainIngredient;
        this.ingredients = new ArrayList<String>();
        for(String p : ingredients)
            this.ingredients.add(p);
        this.directions = new ArrayList<String>();
        for(String p : directions)
            this.directions.add(p);
        rID = rID_Counter++;
    }

    public Recipe(String name, String description, ArrayList<String> ingredients, ArrayList<String> directions, String mainIngredient, String mealType)
    {//Extra Constructor
        this.name = name;
        this.description = description;
        this.mainIngredient = mainIngredient;
        this.mealType = mealType;
        this.ingredients = new ArrayList<String>();
        for(String p : ingredients)
            this.ingredients.add(p);
        this.directions = new ArrayList<String>();
        for(String p : directions)
            this.directions.add(p);
        rID = rID_Counter++;
    }

    public Recipe(int rID, String name, String description, String mealType, String mainIngredient,
                  int rating, int cooktime, String notes, ArrayList<String> ingredients,
                  ArrayList<String> directions)
    { //Full Constructor
        this.rID = rID;
        this.name = name;
        this.description = description;
        this.mealType = mealType;
        this.mainIngredient = mainIngredient;
        this.rating = rating;
        this.cooktime = cooktime;
        this.notes = notes;
        this.ingredients = new ArrayList<String>();
        for(String p : ingredients)
            this.ingredients.add(p);
        this.directions = new ArrayList<String>();
        for(String p : directions)
            this.directions.add(p);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String ingredientString(){ //Creates a single string of ingredients for storage
        String result = "";
        int x;
        for(x=0; x < ingredients.size()-1; x++)
        {
            result += ingredients.get(x) + " - ";
        }
        result += ingredients.get(x);
        return result;

    }

    public void setIngredients(ArrayList<String> ing) {
        this.ingredients = ing;
    }

    public ArrayList<String> getDirections(){
        return directions;
    }

    public void setDirections(ArrayList<String> dir){
        this.directions = dir;
    }

    public String directionString(){ //creates a single string of directions for storage
        String result = "";
        int x;
        for(x=0; x < directions.size()-1; x++)
        {
            result += directions.get(x) + " - ";
        }
        result += directions.get(x);
        return result;

    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCooktime() {
        return cooktime;
    }

    public void setCooktime(int cooktime) {
        this.cooktime = cooktime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getrID() { return rID; }

    public boolean equals(Recipe compareRecipe)
    {
        boolean result = false;
        if(this.getrID() == compareRecipe.getrID())
            result = true;
        return result;
    }

    // TODO: Write Method
    // Leaving in for now; may not be necessary
    public void copy(Recipe newRecipe){

    }

    public void print() {
        System.out.format("Name: \t\t\t %s", name + "\n");
        System.out.format("Description: \t\t %s", description + "\n");
        if(mainIngredient != null)
            System.out.format("Main Ingredient: \t %s", mainIngredient + "\n");
        if(mealType != null)
            System.out.format("Meal Type: \t\t %s", mealType + "\n");
        System.out.println("\nIngredients \n----------");
        for(int x=0; x < ingredients.size(); x++)
        {
            System.out.println(ingredients.get(x).toString());
        }
        //System.out.println(ingredients.toString());
        System.out.println();
        System.out.println("Directions \n----------");
        for(int x=0; x < directions.size(); x++)
        {
            System.out.println((x+1) + ". " + directions.get(x).toString());
        }
        System.out.println();
    }
}
