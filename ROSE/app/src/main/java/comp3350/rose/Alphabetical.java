package comp3350.rose;

import java.util.Comparator;

import comp3350.rose.model.*;

public class Alphabetical implements Comparator<comp3350.rose.model.Recipe> {

    public int compare(comp3350.rose.model.Recipe r1, comp3350.rose.model.Recipe r2){
        return r1.getName().compareTo(r2.getName());
    }
}
