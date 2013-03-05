/**
 * The Branch class stores information about a branch
 * 
 * @author S.D.Wheeler
 * @version 04/03/2013
 * 
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Branch {

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

	public void addRider(Rider ride) {
		allRiders.put(ride.getIdNo(), ride);
		System.out.println("Rider " + ride.getName()
				+ " is now booked at this Branch!");
	}

	public void addRally(Rally ral) {
		allRallies.put(ral.getRallyCode(), ral);
		allVenues.add(ral.getVenue());
		System.out.println("Rally " + ral.getRallyCode()
				+ " is now booked at this Branch!");
	}

	public void joinRally(Rider ride, Rally ral) {
		ral.book(ride);
	}

	public void leaveRally(Rider ride, Rally ral) {
		ral.leave(ride);
		System.out.println("Rider " + ride.getName()
				+ " is now no longer booked on Rally " + ral.getRallyCode()
				+ "!");
	}

	public boolean isRally(String rCode) {
		return allRallies.containsKey(rCode);
	}

	public Rally findRally(String rCode) {
		return allRallies.get(rCode);
	}

	public Rider findRider(int rId) {
		return allRiders.get(rId);
	}

	public void addRiderPoints(int rId, int pts) {
		if (findRider(rId) != null) {
			findRider(rId).incrementPoints(pts);
			System.out.println("Rider " + findRider(rId).getName()
					+ " is now on " + findRider(rId).getPoints() + " points!");
		}
	}

	public String getAllRiders() {
		String str = "";
		Collection<Rider> coll = allRiders.values();
		for (Rider ride : coll) {
			str += ride + "\n";
		}
		return str;
	}

	public String getAllRallies() {
		String str = "";
		Collection<Rally> coll = allRallies.values();
		for (Rally ral : coll) {
			str += ral.getAsString() + "\n";
		}
		return str;
	}

	public String getAllVenues() {
		return allVenues.toString();
	}

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

	public String getAllBranchInfo() {
		return "Branch: " + branchName + "\nRiders: " + getAllRiders()
				+ "\nRallies: " + getAllRallies() + "\nVentues: "
				+ getAllVenues();
	}

}
