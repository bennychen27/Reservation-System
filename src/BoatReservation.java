import java.util.ArrayList;
import java.util.List;

/**
 * BoatReservation is derived from Reservation. Represents a request for a boat at a specific time slot given a list of preferences by customer
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 *
 */
public class BoatReservation extends Reservation{
	
	private List<String> boatType = new ArrayList<>();
	
	/**
	 * Constructor takes 2 inputs, int and string, and calls reservation class constructor
	 * @param timeSlot timeslot of reservation
	 * @param customerName name of customer
	 */
	public BoatReservation(int timeSlot, String customerName){
		
		super(customerName, timeSlot);
		
	}
	
	/**
	 * Takes boatname as input and adds boatname preference to list boattype
	 * @param boatName name of boat
	 */
	public void addBoatPreference(String boatName){
		
		boatType.add(boatName);
		
	}
	
	/**
	 * Returns a list of type string of preferences of boat types
	 * @return List<String> list of preferences of boat names
	 */
	public List<String> getPreferences(){
		
		return boatType;
		
	}

}
