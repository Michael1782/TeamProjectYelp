
/**
 * Write a description of class Reviews here.
 *
 * @Henry Duong, Michael St Angelo, Brandon Fournier
 * @version December 2019
 */
public class Reviews
{
    // instance variables - replace the example below with your own
    private int id;
    private int rating;
    private String body;
    private String author;
    
    /**
     * Constructor for objects of class Reviews
     */
    public Reviews(int id, String author, int rating, String body)
    {
        this.id = id;
        this.rating = rating;
        this.body = body;
        this.author = author;
    }

    public String getBody(){
        return body;
    }
    
    public int getRating(){
        return rating;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public int getId(){
        return id;
    }
}
