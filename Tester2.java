
/**
 * Write a description of class Tester2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester2
{
	// Creates 5 riders
		private RiderV2 ri1 = new RiderV2("Seth", RiderV2.Type.SENIOR);
		private RiderV2 ri2 = new RiderV2("Jasper", RiderV2.Type.JUNIOR);
		private RiderV2 ri3 = new RiderV2("Claire",RiderV2.Type.ADULT);
		private RiderV2 ri4 = new RiderV2("Jack", RiderV2.Type.YOUTH);
		private RiderV2 ri5 = new RiderV2("Logan", RiderV2.Type.YOUTH);
		
		public Tester2()
		{
			// Increment Points and print Riders amount.
			System.out
			.println("ri1 should gain 5 points and should be on a total of 5!");
			ri1.incrementPoints(5);
			System.out.println (ri1.getPoints());
			System.out
			.println("ri2 should gain 15 points and should be on a total of 15!");
			ri2.incrementPoints(15);
			System.out.println (ri2.getPoints());
			System.out
			.println("ri3 should gain 25 points and should be on a total of 25!");
			ri3.incrementPoints(25);
			System.out.println (ri3.getPoints());
			System.out
			.println("ri4 should gain 35 points and should be on a total of 35!");
			ri4.incrementPoints(35);
			System.out.println (ri4.getPoints());
			System.out
			.println("ri5 should gain 45 points and should be on a total of 45!");
			ri5.incrementPoints(45);
			System.out.println (ri5.getPoints());
			System.out
			.println("ri5 should remove 35 points and should be on a total of 10!");
			ri5.decrementPoints(35);
			System.out.println (ri5.getPoints());
			
			// runs test to getIdNo, getName, getType with 2 different results, check if 
			// Junior with both true and false results, rider to String, and check ID is 
			// 104 with both true and false results.
			
			System.out.println("Should return the ID of ri1!");
			System.out.println (ri1.getIdNo());
			System.out.println("Should return the Name of ri2!");
			System.out.println (ri2.getName());
			System.out.println("Should return the Type of ri2!");
			System.out.println (ri2.getType());
			System.out.println("Should return the Type of ri3!");
			System.out.println (ri3.getType());
			System.out.println("Should return True if ri2 is Type == JUNIOR! (Should be True!)");
			System.out.println (ri2.isJunior());
			System.out.println("Should return True if ri3 is Type == JUNIOR! (Should be False!)");
			System.out.println (ri3.isJunior());
			System.out.println("Should return all the details of ri4!");
			System.out.println (ri4.toString());
			System.out.println("Should return True if ri4 has ID 104! (Should be False!)");
			System.out.println (ri4.isSameID(104));
			System.out.println("Should return True if ri5 has ID 104! (Should be True!)");
			System.out.println (ri5.isSameID(104));
		}

}
