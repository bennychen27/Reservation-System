import java.util.Scanner;

/**
 * Derived from Reservable. Represents a request to reserve a boat by customer for a given time slot
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 *
 */
public class Boat extends ReservableItem{	
	
	/**
	 * Constructor that takes text file as input and prints out boat type, calls main class reservableitem constructor
	 * 
	 * @param inFile
	 */
	public Boat(Scanner inFile){
		
		super(inFile);
		System.out.println("Adding Boat type: " + getId());
		
	}
	
	/**
	 * Overrided method that takes reservation object and returns an int 1 or -1 based on if the boat at a given time slot is available or not
	 * 
	 * @param res reservation
	 * @return int +1 or -1
	 */
	@Override
	public int getFitnessValue(Reservation res){
		
		//if boat type is available at reservation time slot, return 1
		if(getReservations()[res.getTime()] == null){
			
			return 1;
			
		}
		
		//else not available, return -1
		else{
			
			return -1;
			
		}
	}
	
}
