import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The Branch class stores information about a branch
 * 
 * @author S.D.Wheeler
 * @version 04/03/2013
 * 
 */

public class Branch {

	// Fields
	private String branchName;
	private HashMap<String, Rally> allRallies = new HashMap<String, Rally>();
	private HashMap<Integer, Rider> allRiders = new HashMap<Integer, Rider>();
	private HashSet<String> allVenues = new HashSet<String>();

	/**
	 * Creates a Branch with a unique id number and a name initialised from
	 * parameter values,
	 * 
	 * @param n
	 *            is the String representation of the branche's name
	 */
	public Branch(String n) {
		branchName = n;
	}

	/**
	 * allows a Rider to be added to the branch.
	 * 
	 * @param ride
	 *            this selects the rider to be added to the branch.
	 */
	public void addRider(Rider ride) {
		allRiders.put(ride.getIdNo(), ride);
		System.out.println("Rider " + ride.getName()
				+ " is now booked at this Branch!");
	}

	/**
	 * allows a Rally to be added to the branch.
	 * 
	 * @param ral
	 *            this selects the rally to be added to the branch.
	 */
	public void addRally(Rally ral) {
		allRallies.put(ral.getRallyCode(), ral);
		allVenues.add(ral.getVenue());
		System.out.println("Rally " + ral.getRallyCode()
				+ " is now booked at this Branch!");
	}

	/**
	 * allows the rider to be booked onto a particular rally.
	 * 
	 * @param ride
	 *            this selects the rider to be booked onto the rally.
	 * @param ral
	 *            this selects the rally the rider is to be booked onto.
	 */
	public void joinRally(Rider ride, Rally ral) {
		ral.book(ride);
	}

	/**
	 * allows the rider to leave a particular rally.
	 * 
	 * @param ride
	 *            this selects the rider to be removed from the rally.
	 * @param ral
	 *            this selects the rally the rider is to be removed from.
	 */
	public void leaveRally(Rider ride, Rally ral) {
		ral.leave(ride);
	}

	/**
	 * returns whether the Rally is contained in the allRallies collection as a
	 * boolean.
	 * 
	 * @param rCode
	 *            this selects the rally to be searched for.
	 * 
	 * @return value returned is whether the Rally is contained in the
	 *         allRallies collection as a boolean.
	 * 
	 */
	public boolean isRally(String rCode) {
		return allRallies.containsKey(rCode);
	} // does not get used???????

	/**
	 * returns the Rally if it is contained in the allRallies collection as a
	 * Rally object.
	 * 
	 * @param rCode
	 *            this selects the rally to be searched for.
	 * 
	 * @return value returned is the Rally, if it is contained in the allRallies
	 *         collection as a Rally object.
	 * 
	 */
	public Rally findRally(String rCode) {
		return allRallies.get(rCode);
	}

	/**
	 * returns the Rider if it is contained in the allRiders collection as a
	 * Rider object.
	 * 
	 * @param rId
	 *            this selects the rider to be searched for.
	 * 
	 * @return value returned is the rider, if it is contained in the allRiders
	 *         collection as a Rider object.
	 * 
	 */
	public Rider findRider(int rId) {
		return allRiders.get(rId);
	}

	/**
	 * allows the rider to gain points for partaking in a rally.
	 * 
	 * @param rId
	 *            this selects the rider to add the points too.
	 * @param pts
	 *            this is the value to be added to the riders points.
	 */
	public void addRiderPoints(int rId, int pts) {
		if (findRider(rId) != null) {
			findRider(rId).incrementPoints(pts);
			System.out.println("Rider " + findRider(rId).getName()
					+ " is now on " + findRider(rId).getPoints() + " points!");
		}
	}

	/**
	 * returns all of the riders that are at the branch as a String.
	 * 
	 * @return value returned is a list of all the riders that are at the branch
	 *         as a String.
	 * 
	 */
	public String getAllRiders() {
		String str = "";
		Collection<Rider> coll = allRiders.values();
		for (Rider ride : coll) {
			str += ride + "\n";
		}
		return str;
	}

	/**
	 * returns all of the rallies that are at the branch as a String.
	 * 
	 * @return value returned is a list of all the rallies that are at the
	 *         branch as a String.
	 * 
	 */
	public String getAllRallies() {
		String str = "";
		Collection<Rally> coll = allRallies.values();
		for (Rally ral : coll) {
			str += ral.getAsString() + "\n";
		}
		return str;
	}

	/**
	 * returns all of the venues that are at the branch as a String.
	 * 
	 * @return value returned is a set of all the venues that are at the branch
	 *         as a String.
	 * 
	 */
	public String getAllVenues() {
		return allVenues.toString();
	}

	/**
	 * returns all of the riders that are at the branch who's points are greater
	 * than the designated amount as a String.
	 * 
	 * @param pts
	 *            this is the value to be added to the riders points.
	 * 
	 * @return value returned is a list of all the riders that are at the branch
	 *         who's points are greater than the designated amount as a String.
	 * 
	 */
	public String getContenders(int pts) {
		String str = "";
		Collection<Rider> coll = allRiders.values();
		for (Rider ride : coll) {
			if (ride.getPoints() >= pts) {
				str += ride + "\n";
			}
		}
		return str;
	}

	/**
	 * returns the full details of the Branch including all the riders, all the
	 * rallies and each rider booked and the list of venues, as a String.
	 * 
	 * @return value returned is the full details of the Branch including all
	 *         the riders, all the rallies and each rider booked and the list of
	 *         venues, as a String.
	 * 
	 */
	public String getAllBranchInfo() {
		return "Branch: " + branchName + "\n\nRiders:\n" + getAllRiders()
				+ "\nRallies:\n" + getAllRallies() + "\nList of ventues: "
				+ getAllVenues();
	}

}
