package comp3350.rose.model;

/**
 * Created by Bryce on 3/7/2016.
 */

import java.util.ArrayList;

public class Recipe {

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
    {//Full Constructor
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

    public void setIngredients(ArrayList<String> ing) {
        this.ingredients = ing;
    }

    public ArrayList<String> getDirections(){
        return directions;
    }

    public void setDirections(ArrayList<String> dir){
        this.directions = dir;
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
