import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * The Rally class stores information about a rally
 * 
 * @author S.D.Wheeler
 * @version 04/03/2013
 * 
 */

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
	 * 1/1/13.
	 * 
	 * @param id
	 *            it is the responsibility of the client to ensure that id is a
	 *            unique number.
	 * @param ven
	 *            is the String representation of the venue.
	 * @param days
	 *            is the number of days rally is running.
	 * @param fc
	 *            is the fee code for the rally.
	 * @param maxp
	 *            is the maximum number of people allowed to enter the rally.
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

	/**
	 * returns date from GregorianCalendar class as set of 3 ints d/m/yyyy.
	 * 
	 * @return value returned is startDate as a Gregorian Calendar date.
	 */
	public String getStartDate() {
		return (startDate.get(5) + "/" + startDate.get(2) + "/" + startDate
				.get(1));
	}

	/**
	 * allows date to be set using the GregorianCalendar class.
	 * 
	 * @param date
	 *            this stores the day into the GregorianCalendar fields
	 *            array[5].
	 * @param month
	 *            this stores the month into the GregorianCalendar fields
	 *            array[2].
	 * @param year
	 *            this stores the year into the GregorianCalendar fields
	 *            array[1].
	 */
	public void setStartDate(int date, int month, int year) {
		startDate.set(year, month, date);
	}

	/**
	 * returns the Rally Code as a String.
	 * 
	 * @return value returned is rallyCode as a String.
	 * 
	 */
	public String getRallyCode() {
		return rallyCode;
	}

	/**
	 * returns the Venue as a String.
	 * 
	 * @return value returned is venue as a String.
	 * 
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * returns the fullFee as a double.
	 * 
	 * @return value returned is fullFee as a double.
	 * 
	 */
	public double getFullFee() {
		return fullFee;
	}

	/**
	 * allows the fee codes to be changed.
	 * 
	 * @param fCode
	 *            this selects the element from the array that needs updating.
	 * @param price
	 *            this is the price value, the element in the array needs
	 *            updating too.
	 * 
	 */
	public void changeFee(int fCode, double price) {
		feeArray[fCode] = price;
	}

	/**
	 * returns the details of the Rally as a String.
	 * 
	 * @return value returned is all the details in regards to the Rally as a
	 *         String.
	 * 
	 */
	public String getDetails() {
		return "Rally Code: " + getRallyCode() + ", Venue: " + getVenue()
				+ ", Start Date: " + getStartDate() + ", Full Fee: £"
				+ getFullFee() + ", Fee Code: " + feeCode + ", No of Days: "
				+ noOfDays + ", Maximum number of people: " + placesAvailable;
	}

	/**
	 * allows the rider to be booked onto the rally. also adds the correct full
	 * fee dependent on rider type, to the rally total.
	 * 
	 * @param ride
	 *            this selects the rider to be added to the rally.
	 */
	public void book(Rider ride) {
		if (!isFull()) {
			competitors.put(ride.getIdNo(), ride);
			System.out.println("Rider " + ride.getName()
					+ " is now booked on this Rally(" + rallyCode + ")!");
			if (ride.getType().equals("junior")
					|| ride.getType().equals("youth")) {
				rallyTotal = rallyTotal + (fullFee / 2);
			} else {
				rallyTotal = rallyTotal + fullFee;
			}
		} else {
			System.out.println("Rider " + ride.getName()
					+ " can not be booked on this Rally(" + rallyCode
					+ "), as it is already full!");
		}
	}

	/**
	 * allows the rider to leave the rally.
	 * 
	 * @param ride
	 *            this selects the rider to be removed from the rally.
	 */
	public void leave(Rider ride) {
		if (competitors.containsKey(ride.getIdNo())) {
			competitors.remove(ride.getIdNo());
			System.out.println("Rider " + ride.getName()
					+ " is no longer booked on this Rally(" + rallyCode + ")!");
		} else {
			System.out.println("Rider " + ride.getName()
					+ " isn't booked on this Rally, so could not remove!");
		}
	}

	/**
	 * returns whether the Rally is full as a boolean.
	 * 
	 * @return value returned is whether the Rally is full as a boolean.
	 * 
	 */
	public boolean isFull() {
		return competitors.size() == placesAvailable;
	}

	/**
	 * returns if a rider is on the Rally as a boolean.
	 * 
	 * @param ride
	 *            this selects the rider to be checked for in the rally.
	 * 
	 * @return value returned is whether the rider is on the Rally as a boolean.
	 * 
	 */
	public boolean hasBooked(Rider ride) {
		return competitors.containsKey(ride.getIdNo());
	}

	/**
	 * returns all of the riders that are on the Rally as a String.
	 * 
	 * @return value returned is a list of all the riders that are on the Rally
	 *         as a String.
	 * 
	 */
	public String getRidersOnRally() {
		String str = "";
		Collection<Rider> coll = competitors.values();
		for (Rider ride : coll) {
			str += ride + "\n";
		}
		return str;
	}

	/**
	 * returns the amount the Rally has been paid as a double.
	 * 
	 * @return value returned is the amount the Rally has been paid as a double.
	 * 
	 */
	public double getMoneyPaid() {
		return rallyTotal;
	}

	/**
	 * returns the full details of the Rally including all riders and amount
	 * taken as a String.
	 * 
	 * @return value returned is all the full details in regards to the Rally
	 *         including all riders and amount taken as a String.
	 * 
	 */
	public String getAsString() {
		return "Details of Rally:\n\n" + getDetails()
				+ "\n\nNumber of competitors booked: " + competitors.size()
				+ "\n\nRaider Details on Rally:\n" + getRidersOnRally()
				+ "\nTotal amount Rally has taken: £" + getMoneyPaid() + "\n";
	}
}
