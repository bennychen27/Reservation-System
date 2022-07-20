import java.util.Scanner;

/**
 * Table class is derived from Reservation class and represents a request by a customer to reserve a table at a restaurant
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 *
 */
public class Table extends ReservableItem{

	private int numSeats;
	
	/**
	 * Constructor that takes text file and calls main class constructor, takes numSeats as next Int in file
	 * Calls reservableitem constructor and takes id as scanner.next and numseats as scanner.nextint
	 * @param inFile text file
	 */
	public Table(Scanner inFile){
		
		super(new Scanner(inFile.next()));
		this.numSeats = inFile.nextInt();
		
	}
	
	/**
	 * Returns an int of num of seats 
	 * @return int num seats
	 */
	public int getNumSeats(){
		
		return numSeats;
		
	}

	/**
	 * Override method that takes reservation and returns an int between difference of seats or -1 depending on the difference of number of seats at table and needed by customer reservation
	 * @return int number of remaining seats or -1 (unavailable or unable to seat)
	 * 
	 */
	@Override
	public int getFitnessValue(Reservation res) {
		
		RestaurantReservation res1 = (RestaurantReservation) res;
		
		//if reservation at time slot is available, return number difference between num seats and seats needed
		//0 means best fit
		if(getReservations()[res.getTime()] == null){
			
			return getNumSeats() - res1.getNumSeatsNeeded();
			
		}
		
		//else return -1, unavailable
		else{
			
			return -1;
			
		}
	}
}
