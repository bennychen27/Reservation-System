import java.util.*;

/**
 * Manager for Reservations. Holds arrayLists of reservations and reservables. Implemented as a generic class of type types where itemType stands for
 * reservableItem and ResType stands for Reservation
 * 
 * @author Benny Chen
 * @section CSS 143 A
 * @version 6-1-18
 */
public class ResManager<ItemType extends ReservableItem, ResType extends Reservation> {

	private List<ResType> reservationList;
	private List<ItemType> reservableList;

	/**
	 * No arg constructor, initializes reservationList and reservableList as type resType and ItemType respectively
	 */
	public ResManager(){

		reservationList = new ArrayList<ResType>();
		reservableList = new ArrayList<ItemType>();

	}

	/**
	 * addReservable method adds a reservableitem object to the arraylist reservableList
	 * @param item item added to list
	 */
	public void addReservable(ItemType item){

		reservableList.add(item);

	}

	/**
	 * makeReservation method checks each reservableitem in list and checks if available, gets fitness value and takes best one, and marks items time slot with reservation and 
	 * sets the reservation resource id with the item id, as well as adds the reservation to the reservationlist
	 * @param trialRes info in reservation object
	 * @return reservation object
	 */
	public Reservation makeReservation(ResType trialRes){

		int index = 0;

		//if trialRes is of instance RestaurantReservation
		if (trialRes instanceof RestaurantReservation) {

			//for each reservable item in reservable list
			for(ItemType i : reservableList){

				//if reversableList's fitness value at index is 0, then best fit.
				//set resource id, add to reservationlist, and mark the time slot of list with reservation trialRes
				if(reservableList.get(index).getFitnessValue(trialRes) == 0){

					trialRes.setResourceId(reservableList.get(index).getId());
					reservationList.add(trialRes);
					reservableList.get(index).getReservations()[trialRes.getTime()] = trialRes;
					return trialRes;

				}

				//else if not best fit, then takes next closest best fitness value
				else if(reservableList.get(index).getFitnessValue(trialRes) == 2){

					trialRes.setResourceId(reservableList.get(index).getId());
					reservationList.add(trialRes);
					reservableList.get(index).getReservations()[trialRes.getTime()] = trialRes;
					return trialRes;

				}

				index++;
			}

		}

		//if reservation is instanceof boatreservation
		if (trialRes instanceof BoatReservation) {
			
			//typecast trialres to boatreservation
			BoatReservation res = (BoatReservation) trialRes;

			//nested for loop through preferences of trialres and reservablelist
			for (int i = 0; i < res.getPreferences().size(); i++) {

				for (int j = 0; j < reservableList.size(); j++) {

					//if reservable list id at index j is equal to object preference at index i
					if (reservableList.get(j).getId().equals(res.getPreferences().get(i))) {

						//if reservation is available, set resource id, add to reservation list, and mark the time slot with trialres object
						if (reservableList.get(j).getFitnessValue(res) > 0) {

							trialRes.setResourceId(reservableList.get(j).getId());
							reservationList.add(trialRes);
							reservableList.get(j).getReservations()[trialRes.getTime()] = trialRes;
							return trialRes;

						}
					}
				}

			}
		}

		//else return null
		return null;
	}

	/**
	 * Method that sorts the reservations in alphabetical order of customer name using nested for loop using bubble sort algorithm
	 */
	public void sortReservations(){

		//traverse through reservationlist start index 0
		for(int i = 0; i < reservationList.size(); i++){

			//traverse through reservation list with starting index 1
			for(int k = i + 1; k < reservationList.size(); k++){

				//if reservationlist at index 0.compareto reservationlist at index 1 returns 1, then swap the elements
				if(reservationList.get(i).compareTo(reservationList.get(k)) > 0){

					ResType temp = reservationList.get(i);
					reservationList.set(i, reservationList.get(k));
					reservationList.set(k, temp);

				}
			}
		}
	}

	/**
	 * Override toString returns a string of the info on reservations
	 * 
	 * @return String reservations info
	 */
	@Override
	public String toString(){

		String retVal = "";
		for(Reservation res : reservationList){

			retVal += res + "\n";

		}

		return retVal;

	}
}
