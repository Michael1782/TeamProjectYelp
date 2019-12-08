import java.util.Scanner;
/**
 * Write a description of class LogIn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Login
{
    public Login(){
        
    }
    
    // Please make this a full fleshed menu with options for brandon from henry
    public static String getLoginMenu(Scanner sc){
        
       String x;
       
       System.out.println("Welcome to the Restaurant Suggestion Application\n" +
                    "1. Log in\n" +
                    "2. Guest\n" +
                    "3. Quit\n");
       x = sc.nextLine();
       
       return x;
        
    }
    
}
