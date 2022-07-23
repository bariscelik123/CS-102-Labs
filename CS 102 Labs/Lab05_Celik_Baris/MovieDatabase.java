/**
 * @(#)MovieDatabase.java
 *
 *
 * @author 
 * @version 1.00 2022/7/16
 */

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	
    public MovieDatabase( String filename ) throws FileNotFoundException {
    	movieList = new ArrayList<Movie>();
    	loadMovies( filename );
    	JOptionPane.showMessageDialog( null, movieList.size() + " movies added...");
    }
    public void loadMovies( String fileName ) throws FileNotFoundException{
        Scanner file = new Scanner(new File(fileName));
        
        while (file.hasNext()) {
            String line = file.nextLine();
            String[] arr = new String[4];
            arr = line.split(",");

            String movieName = arr[0];
            int year = Integer.parseInt(arr[2]) ;
            String category = arr[1];
            double length = Double.parseDouble(arr[3]);
            Movie movie = new Movie(movieName, category, length, year);
            movieList.add(movie);
        }
    	
    	System.out.println("movies in total: " + movieList.size());

        for (Movie m: movieList) {
            System.out.println(m.getMovieName());
        }

    }
    public ArrayList<Movie> searchMovies( String category, int year ){
        ArrayList<Movie> matchingFilms = new ArrayList<Movie>();
            for (int i = 0; i < movieList.size(); i++) {
                Movie moviex = movieList.get(i);

                if (moviex.getCategory() == category && moviex.getYear() == year) {
                    matchingFilms.add(moviex);
                }
            } 
            System.out.println(matchingFilms.size());
    return matchingFilms;
    	
    }
    public ArrayList<Integer> getYears(){
        ArrayList<Integer> years = new ArrayList<Integer>();
        for (int i = 0; i < movieList.size(); i++) {
            Movie moviey = movieList.get(i);
                if (!years.contains(moviey.getYear())){
                    years.add(moviey.getYear());
                }
        }
        Collections.sort(years);
        return years;
    }
    public ArrayList<String> getCategories(){
        ArrayList<String> categories = new ArrayList<String>();
        for (int i = 0; i < movieList.size(); i++) {
            Movie moviec = movieList.get(i);
                if(!categories.contains(moviec.getCategory())){
                    categories.add(moviec.getCategory());
                }
        }
        Collections.sort(categories);
        return categories;
    	
    }
}