/**
 * @(#)MenuApp.java
 * @author CS102
 * @version 1.00 2022/06/13
 */
import java.util.*;
import java.io.*;
public class MenuApp {
   	public static int MAX_CUSTOMERS = 1000;
   	
    public static void main(String[] args) throws IOException{
        
    }
    
    public static Customer[] loadCustomers(String fileName) throws IOException{
    	int custCount = 0;
    	//Create array to store Customers (at most MAX_CUSTOMERS)
    	
    	
    	//create Scanner to read from file
    	Scanner inFile = new Scanner(new File(fileName));
    	
    	//tokens in file delimited by semi-colon
    	inFile.useDelimiter(";");
    	inFile.useLocale(Locale.US);
    	
    	//while file has more data
    	while(inFile.hasNext()){
    		//read customer data
    		String customerName = inFile.next();
    		String customerSurname = inFile.next();
    		String email = inFile.next();
    		boolean diet = inFile.nextBoolean();
    		
    		/************create new Customer**************/
    		
    		
    		
    		//read number of MenuItems for Customer 
    	    int numItems = inFile.nextInt();
 	    
 	    	//read the MenuItem data from file
    	    for(int i = 0; i < numItems; i++){
    	    	String itemData = inFile.next();

    	    	String[] data = itemData.split("-");
    	    	String itemName = data[0];
    	    	String itemDescription = data[1];
    	    	int ingredients  = Integer.parseInt(data[2]);
    	    	int calories = Integer.parseInt(data[3]);
    	    	double itemCost = Double.parseDouble(data[4]);
    	    	
    	    	/************create MenuItem**************/
    	    	
    	    	
    	    	/************add MenuItem to Customer's FoodOrder**************/
    	    	
    	 
    	    }
    	    /************add Customer to array of Customers**************/
    	    
    	}
    	inFile.close();
    	
    	/************Trim empty elements from the array of Customers**************/
    	customers = Arrays.copyOf( customers, custCount);
    	
    	//return array of customers
    	
    }
    
}
