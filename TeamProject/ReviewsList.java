import java.util.*;

/**
 * Write a description of class ReviewsList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReviewsList
{
    // instance variables - replace the example below with your own
    private ArrayList<Reviews> listOfReviews;

    /**
     * Constructor for objects of class ReviewsList
     */
    public ReviewsList()
    {
        listOfReviews = new ArrayList<Reviews>();
    }
    
    public void addReviews(Reviews nReviews){
        listOfReviews.add(nReviews);
    }


}
