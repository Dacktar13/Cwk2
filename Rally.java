import java.util.Calendar;
import java.util.GregorianCalendar;

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
	private int noOFDays;
	private int feeCode;
	private int placesAvailable;

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
	public Rally (String id, String ven, int days, int fc, int maxp)    
	    {
	        rallyCode = id;                              
	        venue = ven;
	        startDate = new GregorianCalendar();
	        startDate.set(2013, 1, 1);
	        feeCode = fc;
	        noOFDays = days;
	        placesAvailable = maxp; 
	    }
}
