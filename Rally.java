/**
 * The Rally class stores information about a rally
 * 
 * @author S.D.Wheeler
 * @version 04/03/2013
 * 
 */

import java.util.Calendar;
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
	private double[] feeArray = { 0, 10, 15.50, 17.75, 20};
	private double fullFee;
	private HashMap<Integer,Rider> competitors = new HashMap<Integer,Rider>();
	

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
		if (fullFee > 0)
		{
			fullFee = fullFee * 1.2;
		}
		
	}
	
	
	public String getStartDate() {
		return (startDate.get(5)+"/"+startDate.get(2)+"/"+startDate.get(1));
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
	
	public void changeFee(int fCode,double price) 
	{
		feeArray[fCode] = price;	
	}
	
	public String getDetails()
	{
		return ("Rally Code: " + getRallyCode() + ", Venue: "+ getVenue() + ", Start Date: " 
	+ getStartDate() + ", Full Fee: £" + getFullFee() + ", Fee Code: " + feeCode 
	+ ", No of Days: " + noOfDays + ", Maximum number of people: " + placesAvailable);
	}

	public void book(Int id, String person)
	{
		competitors.put(Rider.idNumber,Rider);
	}
}
