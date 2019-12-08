import java.util.Scanner;
/**
 * Write a description of class RestaurantSuggestTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RestaurantSuggestTester
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String menuAnswer = "", answer = "";
        
        Login lg = new Login();
        RestaurantData newData = new RestaurantData(null,null);
        RestaurantsList rest = newData.getList();
        
        while(!answer.equals("3")){
            answer = lg.getLoginMenu(sc);
            if(answer.equals("1")){
                System.out.println("Would you like to: \n" +
                    "1. Add a new Restaurant\n" +
                    "2. Search for a restaurant\n" +
                    "3. Show All Restaurants\n" +
                    "4. Add a Review\n" +
                    "5. Quit\n");
                    
                String another = sc.nextLine();
                switch(another){
                    case "1":
                        newData.makeRestaurant(sc);
                        rest = newData.getList();
                        break;
                    case "2":
                        searchOptions(rest,sc);
                        break;
                    case "3":
                        System.out.println("Here are all current Restaurants: ");
                        rest.listAll();
                        break;
                    case "4":
                        newData.makeReview(sc);
                        rest = newData.getList();
                    case "5":
                        System.out.println("Program ending");
                        System.exit(0);
                    default:
                        System.out.println("Choose another option");
                        break;
                }
            }
            if(answer.equals("2")){
                
                searchOptions(rest, sc);
                
           }
        }
    }
    
    // Search option menu
    private static void searchOptions(RestaurantsList rest, Scanner sc){
        String menuAnswer = "";
        menuAnswer = rest.getMenu(sc);
      
            switch(menuAnswer){
                    case "1":
                        System.out.println("Please enter the name of the Restaurant: ");
                        menuAnswer = sc.nextLine();
                        
                        System.out.println("Here are your results: \n" 
                                + rest.searchName(menuAnswer));
                        break;
                    case "2":
                        System.out.println("Please enter the value of the price range($,$$,$$$): ");
                        menuAnswer = sc.nextLine();
                        
                        System.out.println("Here are your results: \n" 
                                + rest.searchPrice(menuAnswer));
                        break;
                    case "3":
                        System.out.println("Please enter the type of food: ");
                        menuAnswer = sc.nextLine();
                        
                        System.out.println("Here are your results: \n" 
                                + rest.searchFoodType(menuAnswer));
                        break;
                    case "4":
                        System.out.println("Please enter the location you like to search for: ");
                        menuAnswer = sc.nextLine();
                        
                        System.out.println("Here are your results: \n" 
                                + rest.searchLocations(menuAnswer));
                        break;
                    case "5": 
                        System.out.println("Program ending");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                        break;    
                }
            }
            
    

}
