package comp3350.rose.Controller;

/**
 * Created by JiqingDai on 3/10/2016.
 */
import comp3350.rose.model.ShoppingList;
import java.util.ArrayList;

public interface DBSLInterface{
    public void addShoppingList(ShoppingList shoppinglist);
    public void deleteShoppingList(ShoppingList shoppinglist);
    public void editShoppingList(ShoppingList shoppinglist);
    public ArrayList<ShoppingList> getShoppingList();
}
