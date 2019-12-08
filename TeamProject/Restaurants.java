
/**
 * Write a description of class Restaurants here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurants //implements Comparable<Restaurants>
{
    // instance variables - replace the example below with your own
    private String priceRange;
    private String location;
    private String food;
    private String name;
    private int id;
    private ReviewsList listOfReviews;
    
    // Arraylist of reviews
    /**
     * Constructor for objects of class Restaurants
     */
    public Restaurants(int i, String rn, String ft, String l, String p)
    {
        id = i;
        name = rn; 
        food = ft;
        location = l;
        priceRange = p;
        
        listOfReviews = new ReviewsList();
        
    }
    
    public int getId(){
        return id;
    }
    
    public String getRestaurantName()
    {
        return name;
    }
    
    public String getFoodType()
    {
        return food;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getPriceRange()
    {
        return priceRange;
    }
    
    public void setReviews(Reviews a){
        listOfReviews.addReviews(a);
    }
    
    public ReviewsList getReviews(){
        return listOfReviews;
    }
    
    public String toString()
    {
        String info1, info2, info3, info4, output;
        info1 = String.format("Name: %s%n", name);
        info2 = String.format("Type of Food: %s%n", food);
        info3 = String.format("Location: %s%n", location);
        info4 = String.format("Price Range: %s%n", priceRange);
        output = info1 + info2 + info3 + info4;
        return output;
    }
    
    
    /*
    public int compareTo (Restaurants other)
    {
        if(this.getRestaurantName().equals(other.getRestaurantName())){
            return this.name - other.name;
        }
    }
    */
}