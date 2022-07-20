/**
 * This class is derived from Reservation and represents requests for a table at a specific time slot
 * Has overrided toString method of main class reservation
 * 
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 *
 */
public class RestaurantReservation extends Reservation{

	private int numSeatsNeeded = 0;
	
	/**
	 * Constructor takes 3 input and initializes them, if the timeslot in array is null then add the reservation to list
	 * @param startTime time of reservation
	 * @param numSeatsNeeded number of seats
	 * @param name customer name
	 */
	public RestaurantReservation(int numSeatsNeeded, int startTime, String name){
		
		super(name, startTime);
		this.numSeatsNeeded = numSeatsNeeded;
		
	}
	
	/**
	 * Return int of number of seats needed
	 * @return int numb of seats
	 */
	public int getNumSeatsNeeded(){
		
		return numSeatsNeeded;
		
	}	
	
	/**
	 * Overrided toString method that calls reservation toString method to print out generic reservation info + customer seats needed 
	 * @return String string of reservation info
	 * 
	 */
	@Override
	public String toString(){
		
		return super.toString() + " customer seats: " + numSeatsNeeded;
		
	}
	
}
