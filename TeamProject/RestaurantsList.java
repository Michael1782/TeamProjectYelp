import java.util.*;

/**
 * Write a description of class RestaurantsList here.
 *
 * @author Henry Duong, Brandon Fournier, Michael St Angelo
 * @version 2019
 */
public class RestaurantsList
{
    // instance variables - replace the example below with your own
    private ArrayList<Restaurants> restList;
    
    /**
     * Constructor for objects of class RestaurantsList
     */
    public RestaurantsList()
    {
        restList = new ArrayList<Restaurants>();
    }
    
    public void addRestaurant(Restaurants nRest){
        restList.add(nRest);
    }
    
    public void addReview(int index, Reviews nReview){
        restList.get(index).setReviews(nReview);
    }
    
    public String searchLocations(String location){
        
        String result = "";
        
        for(int i = 0; i < restList.size(); i++){
            if(location.equals(restList.get(i).getLocation())){
                result += restList.get(i).toString() + " \n";
            }
        }
        
        if(result.equals("")){
            result = "There is no restaurants that matches that criteria.";
        }
        return result;
        
    }
    
    public String searchName(String name){
        
        String result = "";
        
        for(int i = 0; i < restList.size(); i++){
            if(name.equals(restList.get(i).getRestaurantName())){
                result += restList.get(i).toString() + " \n";
            }
        }
        
        if(result.equals("")){
            result = "There is no restaurants that matches that criteria.";
        }
        return result;
        
    }
    
    //To use with the reviews database
     public int searchNameForId(String name){
        
        int result = 0;
        
        for(int i = 0; i < restList.size(); i++){
            if(name.equals(restList.get(i).getRestaurantName())){
                result = restList.get(i).getId();
            }
        }
        
        return result;
        
    }
    
    public String searchFoodType(String foodtype){
        
        String result = "";
        
        for(int i = 0; i < restList.size(); i++){
            if(foodtype.equals(restList.get(i).getFoodType())){
                result += restList.get(i).toString() + " \n";
            }
        }
        
        if(result.equals("")){
            result = "There is no restaurants that matches that criteria.";
        }
        return result;
        
    }
    
    public String searchPrice(String price){
        
        String result = "";
        
        for(int i = 0; i < restList.size(); i++){
            if(price.equals(restList.get(i).getPriceRange())){
                result += restList.get(i).toString() + " \n";
            }
        }
        
        if(result.equals("")){
            result = "There is no restaurants that matches that criteria.";
        }
        return result;
        
    }
    
     public int searchId(int id){
        int result = 0;
        for(int i = 0; i < restList.size(); i++){
            if(id == restList.get(i).getId()){
                result = i;
                break;
            }
        }

        return result;
        
    }
    
    public void listAll(){
        for(int i = 0; i < restList.size(); i++){
            System.out.println(restList.get(i).toString());
        }
    }
    
    public String getMenu(Scanner sc){
        
        String x = "";
        
        System.out.println("Search Restaurants by \n" +
               "1. By Name \n" +
               "2. By Price \n" +
               "3. By Food Type \n" +
               "4. By Location \n" +
               "5. Quit \n" + 
               "Please enter a option: \n");
        x = sc.nextLine();
        
        return x;
        
    }
    
    

}
