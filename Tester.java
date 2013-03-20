/**
 * This class tests the Branch class.
 * 
 * @author S.D.Wheeler
 * @version 04/03/2013
 * 
 */
public class Tester {
	// instance variables

	// Creates 5 riders
	private Rider ri1 = new Rider(1, "Seth", "Senior"); // Adds rider1
	private Rider ri2 = new Rider(2, "Jasper", "Junior");
	private Rider ri3 = new Rider(3, "Claire", "Adult");
	private Rider ri4 = new Rider(4, "Jack", "Youth");
	private Rider ri5 = new Rider(5, "Logan", "Youth");
	// creates 4 rallies
	private Rally ra1 = new Rally("HT1", "Hatfield House", 5, 2, 4);
	private Rally ra2 = new Rally("ST1", "Stevenage Football Stadium", 2, 1, 3);
	private Rally ra3 = new Rally("KW1", "Knebworth House", 3, 4, 6);
	private Rally ra4 = new Rally("HT2", "Hatfield House", 1, 0, 10);
	// creates 1 branch
	private Branch br1 = new Branch("Hertfordshire");

	/**
	 * Constructor for objects of class Tester
	 */
	public Tester() {
		// adds the 4 rallies to the branch
		System.out.println("ra1 should be added to the branch!");
		br1.addRally(ra1);
		System.out.println("ra2 should be added to the branch!");
		br1.addRally(ra2);
		System.out.println("ra3 should be added to the branch!");
		br1.addRally(ra3);
		System.out.println("ra4 should be added to the branch!");
		br1.addRally(ra4);

		// adds the 5 riders to the branch
		System.out.println("ri1 should be added to the branch!");
		br1.addRider(ri1);
		System.out.println("ri2 should be added to the branch!");
		br1.addRider(ri2);
		System.out.println("ri3 should be added to the branch!");
		br1.addRider(ri3);
		System.out.println("ri4 should be added to the branch!");
		br1.addRider(ri4);
		System.out.println("ri5 should be added to the branch!");
		br1.addRider(ri5);

		// joins riders to rallies
		System.out.println("ri1 should be added to ra1!");
		br1.joinRally(ri1, ra1);
		System.out.println("ri2 should be added to ra1!");
		br1.joinRally(ri2, ra1);
		System.out.println("ri3 should be added to ra1!");
		br1.joinRally(ri3, ra1);
		System.out.println("ri4 should be added to ra1!");
		br1.joinRally(ri4, ra1);
		System.out
				.println("ri5 should be added to ra1! This should fail due to rally being full!");
		br1.joinRally(ri5, ra1);
		System.out.println("ri1 should be added to ra2!");
		br1.joinRally(ri1, ra2);
		System.out.println("ri5 should be added to ra2!");
		br1.joinRally(ri5, ra2);
		System.out
				.println("ri5 should be added to ra2! This should fail due to rider already being on this rally!");
		br1.joinRally(ri5, ra2);
		System.out.println("ri1 should be added to ra1!");
		br1.joinRally(ri2, ra3);
		System.out.println("ri1 should be added to ra1!");
		br1.joinRally(ri3, ra3);
		System.out.println("ri1 should be added to ra1!");
		br1.joinRally(ri4, ra3);
		
		// leaves riders from rally
		System.out.println("ri1 should be removed from ra1!");
		br1.leaveRally(ri3, ra3);

		// adds points to riders
		System.out
				.println("ri1 should gain 14 points and should be on a total of 14!");
		br1.addRiderPoints(1, 14);
		System.out
				.println("ri3 should gain 9 points and should be on a total of 9!");
		br1.addRiderPoints(3, 9);

		// prints reports
		System.out
				.println("System should list all riders that have more than 10 points!");
		System.out.print(br1.getContenders(10));
		System.out.println("\nSystem should print out details about branch.");
		System.out
				.println("Branch name, list of riders, list of rallies and the riders");
		System.out
				.println("booked on each, and a list of 3 venues that should have no duplicates!\n");
		System.out.print(br1.getAllBranchInfo());

	}

}