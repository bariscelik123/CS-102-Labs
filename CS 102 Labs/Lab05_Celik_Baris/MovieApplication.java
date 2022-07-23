import java.io.FileNotFoundException;

/**
 * @(#)MovieApplication.java
 *
 *
 * @author 
 * @version 1.00 2022/7/16
 */

public class MovieApplication {
    
    public static void main( String[] args) throws FileNotFoundException{
        MovieGUI window = new MovieGUI("MOVIE LIST", "movies.txt");
        window.setVisible(true);
	}
}
