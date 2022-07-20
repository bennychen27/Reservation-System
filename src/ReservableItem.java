import java.util.*;

/**
 * ReservableItem class is an abstract class that is a part of the base system that contains 3 classes, this class represents an item that can be reserved
 * Has one abstract method
 * 
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 *
 */
public abstract class ReservableItem{
	
	protected String id = "";  
	public static final int TIME_SLOTS = 10;
	private Reservation[] reservations = new Reservation[TIME_SLOTS]; //array of type reservation holds 10 elements
	
	/**
	 * Constructor that takes a text file and creates an array of 10 with null elements meaning currently available 
	 * @param fileIn
	 */
	public ReservableItem(Scanner fileIn){
		
		id = fileIn.nextLine();
		
	}
	
	/**
	 * Returns string of id of item
	 * @return string of name of item
	 */
	public String getId(){
		
		return id;
		
	}
	
	/**
	 * Absttract method returns an int of the fitness value of reservation
	 * @param res reservation object
	 * @return int number value
	 */
	public abstract int getFitnessValue(Reservation res);
	
	/**
	 * Returns an array of type reservation of a list of reservations
	 * @return reservation[] array
	 */
	public Reservation[] getReservations(){
		
		return reservations;
		
	}

}
