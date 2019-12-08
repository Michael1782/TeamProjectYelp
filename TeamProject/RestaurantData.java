/**
 * Write a description of class RestaurantData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.sql.*;
import java.util.*;

public class RestaurantData
{
    RestaurantsList rList;
    private Connection conn;
    private boolean isopen;
    /**
     * Constructor for objects of class RestaurantData
     */
    public RestaurantData(String uname, String pword)
    {   
        // Attemptto connect ot the database
        // Turn off auto commit
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Restaurants.db",uname,pword);
              conn.setAutoCommit(false);
          } catch (Exception e) {conn = null;}
          isopen = (conn != null);
          
        rList = new RestaurantsList();
    }
    
    //Test whether the database is open
    public boolean isOpen() {return isopen;}
    
    // Close the database connection.
    public void close() {
          if (!isopen) return;
          try {conn.close();}
          catch (Exception e) {}
          isopen = false;
          conn = null;
    }
    
    public RestaurantsList getList(){
        updateRestaurants();
        updateReviews();
        return rList;
    }
   
    public void updateRestaurants(){
          PreparedStatement stmt = null;
          ResultSet rset = null;
          String sql, name, food, price, location;
          int id;

          // Return if the database is closed.
          if (!isopen) return;

          try {

              // Create a PreparedStatement for the query.
              sql = "SELECT * FROM Restaurants";
              stmt = conn.prepareStatement(sql);

              // Execute the query and print the result set.
              rset = stmt.executeQuery();
              while (rset.next()) {
                  id = rset.getInt(1);
                  name = rset.getString(2);
                  food = rset.getString(3);
                  location = rset.getString(4);
                  price = rset.getString(5);
            
                  Restaurants nRest = new Restaurants(id, name, food, location, price);
                  rList.addRestaurant(nRest);
              }
              stmt.close();
              conn.commit();
          } catch (Exception e) {
              System.out.printf("%s%n", e.getMessage());
              try {stmt.close();}
              catch (Exception err) {}
              try {conn.rollback();}
              catch (Exception err) {}
          }
    }
    
    // Add a new restaurant.
    public void makeRestaurant(Scanner kbd) {
          PreparedStatement stmt = null;
          ResultSet rset = null;
          String sql, name, food, price, location;
          int id = -1;
        
          // Return if the database is closed.
          if (!isopen) return;
        
          try {
        
              // Read the inputs for a new restaurant.
              System.out.print("Restaurant name? ");
              name = kbd.nextLine();
              System.out.print("Food type?  ");
              food = kbd.nextLine();
              System.out.print("Price range? ($,$$,$$$,$$$$) ");
              price = kbd.nextLine();
              System.out.print("location?  ");
              location = kbd.nextLine();
        
              // Create a PreparedStatement for the update.
              sql = "INSERT INTO Restaurants(name, food, location, price) VALUES "
                  + " (?, ?, ?, ?)";
              stmt = conn.prepareStatement(
                      sql, Statement.RETURN_GENERATED_KEYS);
              stmt.setString(1, name);
              stmt.setString(2, food);
              stmt.setString(3, location);
              stmt.setString(4, price);
              
        
              // Execute the update and retrieve the generated key.
              stmt.executeUpdate();
              rset = stmt.getGeneratedKeys();
              if (rset.next()) id = rset.getInt(1);
        
              // Display the generated key.
              if (id >= 0) {
                  Restaurants nRest = new Restaurants(id, name, food, location, price);
                  rList.addRestaurant(nRest);
                  
                  System.out.printf("Restaurant %s was created with %s food at %s that cost %s.%n",
                  name, food, location, price);
              } else {
                  System.out.printf("The Restaurant record was not created.%n");
              }
              stmt.close();
              conn.commit();
        
          } catch (Exception e) {
              System.out.printf("%s%n", e.getMessage());
              try {stmt.close();}
              catch (Exception err) {}
              try {conn.rollback();}
              catch (Exception err) {}
          }
          
          
    }
    
    public void updateReviews(){
          PreparedStatement stmt = null;
          ResultSet rset = null;
          String sql, author,  body;
          int id, rating, index =0;
          

          // Return if the database is closed.
          if (!isopen) return;

          try {

              // Create a PreparedStatement for the query.
              sql = "SELECT * FROM Reviews";
              stmt = conn.prepareStatement(sql);

              // Execute the query and print the result set.
              rset = stmt.executeQuery();
              while (rset.next()) {
                  id = rset.getInt(1);
                  author = rset.getString(2);
                  rating = rset.getInt(3);
                  body = rset.getString(4);

                  Reviews nReview = new Reviews(id, author, rating, body);
                  rList.searchId(id);
                  if(index != 0){
                      rList.addReview(index, nReview);
                  }
              }
              stmt.close();
              conn.commit();
          } catch (Exception e) {
              System.out.printf("%s%n", e.getMessage());
              try {stmt.close();}
              catch (Exception err) {}
              try {conn.rollback();}
              catch (Exception err) {}
          }
    }
    
    // Add a new review for a restaurant.
    public void makeReview(Scanner kbd) {
          PreparedStatement stmt = null;
          ResultSet rset = null;
          String sql, author, body,answer;
          int id, rating, index = 0;
        
          // Return if the database is closed.
          if (!isopen) return;
        
          try {
        
              // Read the inputs for a new restaurant.
              System.out.print("What restaurant do you want to review?");
              answer = kbd.nextLine();
              id = rList.searchNameForId(answer);
              System.out.print("User name: ");
              author = kbd.nextLine(); 
              System.out.print("Rating 1-5: ");
              rating = kbd.nextInt();
              System.out.print("Review:  ");
              body = kbd.nextLine();
             
              kbd.nextLine();
        
              // Create a PreparedStatement for the update.
              sql = "INSERT INTO Reviews(id, author, rating, body) VALUES "
                  + " (?, ?, ?, ?) ";
              stmt = conn.prepareStatement(
                      sql);
              stmt.setInt(1, id);
              stmt.setString(2, author);
              stmt.setInt(3, rating);
              stmt.setString(4, body);
              
              // Execute the update and retrieve the generated key.
              stmt.executeUpdate();
          
              Reviews nRev = new Reviews(id, author, rating, body);
              rList.addReview(id, nRev);
              System.out.printf("Review was added for %s\n", answer); 
              
              stmt.close();
              conn.commit();
        
          } catch (Exception e) {
              System.out.printf("%s%n", e.getMessage());
              try {stmt.close();}
              catch (Exception err) {}
              try {conn.rollback();}
              catch (Exception err) {}
          }
    
    }
}
