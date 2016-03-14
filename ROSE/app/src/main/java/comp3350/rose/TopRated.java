package comp3350.rose;

import java.util.Comparator;

public class TopRated implements Comparator<comp3350.rose.model.Recipe> {

    public int compare(comp3350.rose.model.Recipe r1, comp3350.rose.model.Recipe r2){
        if(r1.getRating() <  r2.getRating()) return -1;
        if(r1.getRating() == r2.getRating()) return 0;
        return 1;
    }
}
