package comp3350.rose.Controller;

import java.util.ArrayList;

import comp3350.rose.model.Recipe;

/**
 * Created by Bryce on 3/30/2016.
 */
public interface MenuInterface {
    public void addBreakfast(String name);
    public boolean hasBreakfast();
    public void addLunch(String name);
    public boolean hasLunch();
    public void addSupper(String name);
    public boolean hasSupper();
    public void deleteRecipes();
    public String[] getList();
}
