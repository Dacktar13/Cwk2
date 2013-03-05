/**
 * The Rally class stores information about a rally
 * 
 * @author S.D.Wheeler
 * @version 04/03/2013
 * 
 */

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Rally {

	// Fields
	private String rallyCode;
	private String venue;
	private Calendar startDate;
	private int noOfDays;
	private int feeCode;
	private int placesAvailable;
	private double[] feeArray = { 0, 10, 15.50, 17.75, 20 };
	private double fullFee;
	private HashMap<Integer, Rider> competitors = new HashMap<Integer, Rider>();
	private double rallyTotal;

	/**
	 * Creates a Rally with a unique id, venue, fee code, no of days and the max
	 * number of people allowed from parameter values, and sets start date to
	 * 1/1/13
	 * 
	 * @param id
	 *            it is the responsibility of the client to ensure that id is a
	 *            unique number
	 * @param ven
	 *            is the String representation of the venue
	 * @param days
	 *            is the number of days rally is running
	 * @param fc
	 *            is the fee code for the rally
	 * @param maxp
	 *            is the maximum number of people allowed to enter the rally
	 */
	public Rally(String id, String ven, int days, int fc, int maxp) {

		rallyCode = id;
		venue = ven;
		startDate = new GregorianCalendar(2013, 01, 01);
		feeCode = fc;
		noOfDays = days;
		placesAvailable = maxp;
		if (noOfDays > 1) {
			fullFee = ((noOfDays - 1) * 25) + feeArray[feeCode];
		} else {
			fullFee = feeArray[feeCode];
		}
		if (fullFee > 0) {
			fullFee = fullFee * 1.2;
		}

	}

	public String getStartDate() {
		return (startDate.get(5) + "/" + startDate.get(2) + "/" + startDate
				.get(1));
	}

	public void setStartDate(int date, int month, int year) {
		startDate.set(year, month, date);
	}

	public String getRallyCode() {
		return rallyCode;
	}

	public String getVenue() {
		return venue;
	}

	public double getFullFee() {
		return fullFee;
	}

	public void changeFee(int fCode, double price) {
		feeArray[fCode] = price;
	}

	public String getDetails() {
		return "Rally Code: " + getRallyCode() + ", Venue: " + getVenue()
				+ ", Start Date: " + getStartDate() + ", Full Fee: £"
				+ getFullFee() + ", Fee Code: " + feeCode + ", No of Days: "
				+ noOfDays + ", Maximum number of people: " + placesAvailable;
	}

	public void book(Rider ride) {
		if (!isFull()) {
			competitors.put(ride.getIdNo(), ride);
			System.out.println("Rider " + ride.getName()
					+ " is now booked on this Rally!");
			if (ride.getType().equals("junior")
					|| ride.getType().equals("youth")) {
				rallyTotal = rallyTotal + (fullFee / 2);
			} else {
				rallyTotal = rallyTotal + fullFee;
			}
		} else {
			System.out
					.println("Rider "
							+ ride.getName()
							+ " can not be booked on this Rally, as it is already full!");
		}
	}

	public void leave(Rider ride) {
		if (competitors.containsKey(ride.getIdNo())) {
			competitors.remove(ride.getIdNo());
			System.out.println("Rider " + ride.getName()
					+ " is no longer booked on this Rally!");
		} else {
			System.out.println("Rider " + ride.getName()
					+ " isn't booked on this Rally, so could not remove!");
		}
	}

	public boolean isFull() {
		return competitors.size() == placesAvailable;
	}

	public boolean hasBooked(Rider ride) {
		return competitors.containsKey(ride.getIdNo());
	}

	public String getRidersOnRally() {
		String str = "";
		Collection<Rider> coll = competitors.values();
		for (Rider ride : coll) {
			str += ride + "\n";
		}
		return str;
	}

	public double getMoneyPaid() {
		return rallyTotal;
	}

	public String getAsString() {
		return "Details of Rally:\n\n" + getDetails()
				+ "\n\nNumber of competitors booked: " + competitors.size()
				+ "\n\nRaider Details on Rally:" + getRidersOnRally()
				+ "\nTotal amount Rally has taken: £" + getMoneyPaid();
	}
}
