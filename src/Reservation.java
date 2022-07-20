
/**
 * Represents a request by the user to reserve an item, implements comparable for sorting by customer name
 * 
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 *
 */
public class Reservation implements Comparable<Reservation>{

	private String reservableItem = "";
	private String customerName = "";
	private int time;
	
	/**
	 * Constructor that takes customername and timeslot and initializes them, reservableItem is set to null
	 * @param customerName customer name
	 * @param timeSlot time slot of reservation of item
	 */
	public Reservation(String customerName, int timeSlot){
		
		this.customerName = customerName;
		this.time = timeSlot;
		reservableItem = null;
		
	}
	
	/**
	 * Return a string of custoemr name
	 * @return String name
	 */
	public String getCustomer(){
		
		return customerName;
		
	}
	
	/**
	 * Return an int of time of reservation
	 * @return int time of reservation
	 */
	public int getTime(){
		
		return time;
		
	}
	
	/**
	 * Return a string of the info of reservation
	 * @return String info
	 */
	public String toString(){
		
		return "Reservation name: " + customerName + " time: " + time + " id: " + reservableItem;
		
	}
	
	/**
	 * Takes string parameter and initializes it
	 * 
	 * @param Id name of reservable item
	 */
	public void setResourceId(String Id){
		
		reservableItem = Id;
		
	}
	
	/**
	 * Overrided method that takes a reservation other and compares it to this customer name
	 * @param other other object being compared to
	 * @return int -1, 0, 1
	 */
	@Override
	public int compareTo(Reservation other) {
		
		if(this.getCustomer().compareTo(other.getCustomer()) < 0){
			
			return -1;
			
		}
		
		if(this.getCustomer().compareTo(other.getCustomer()) == 0){
			
			return 0;
			
		}
		
		else{
			
			return 1;
			
		}
	}
}
