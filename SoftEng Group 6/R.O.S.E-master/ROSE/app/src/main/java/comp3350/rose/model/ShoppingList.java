package comp3350.rose.model;

/**
 * Created by JiqingDai on 2016-03-10.
 */

public class ShoppingList {
    //TODO add model
    //table name
    public static final String TABLE = "ShoppingList";
    //lables
    public static final String KEY_sID = "ShoppingListID";
    public static final String KEY_name = "ShoppingList_Name";
    //public static final String KEY_AMOUNT = "Amount";
    //public static final String KEY_UNIT = "Unit";

    //attributes
    static int sID_counter = 1;
    private int sID;
    private String name;
//    private int amount;
//    private String unit;

    public ShoppingList(){
        //Null Constructor
        sID ++;
        name = null;
       // amount = null;
       // unit = null;
    }

    public ShoppingList(String name/*,String amount, String unit*/){
        //basic Constructor
        this.name = name;
        //this.amount = amount;
        //this.unit = unit;
        sID = sID++;
    }

    public ShoppingList(int sID, String name/*,String amount, String unit*/){
        //basic Constructor for Edit call
        this.name = name;
        //this.amount = amount;
        //this.unit = unit;
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getsID() { return sID; }

    public boolean equals(ShoppingList compareShopping)
    {
        boolean result = false;
        if(this.getsID() == compareShopping.getsID())
            result = true;
        return result;
    }

    public void print() {
        System.out.format("Name: \t\t\t %s", name + "\n");
        System.out.println();
    }



}
