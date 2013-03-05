/**
 * Write a description of class Tester here.
 * 
 * @author (S.D.Wheeler)
 * @version (04/03/2013)
 */
public class Tester {
	// instance variables - replace the example below with your own
	private Rider ri1 = new Rider(1, "Seth", "Senior");
	private Rider ri2 = new Rider(2, "Jasper", "Junior");
	private Rider ri3 = new Rider(3, "Claire", "Adult");
	private Rider ri4 = new Rider(4, "Jack", "Youth");
	private Rider ri5 = new Rider(4, "Logan", "Youth");
	private Rally ra1 = new Rally("HT1", "Hatfield House", 5, 2, 4);
	private Rally ra2 = new Rally("ST1", "Stevenage Football Stadium", 2, 1, 3);
	private Rally ra3 = new Rally("KW1", "Knebworth House", 3, 4, 6);
	private Branch br1 = new Branch("Hertfordshire");

	/**
	 * Constructor for objects of class Tester
	 */
	public Tester() {
		br1.addRally(ra1);
		br1.addRally(ra2);
		br1.addRally(ra3);

		br1.addRider(ri1);
		br1.addRider(ri2);
		br1.addRider(ri3);
		br1.addRider(ri4);
		br1.addRider(ri5);

		br1.joinRally(ri1, ra1);
		br1.joinRally(ri2, ra1);
		br1.joinRally(ri3, ra1);
		br1.joinRally(ri4, ra1);
		br1.joinRally(ri5, ra1);
		br1.joinRally(ri1, ra2);
		br1.joinRally(ri5, ra2);
		br1.joinRally(ri2, ra3);
		br1.joinRally(ri3, ra3);
		br1.joinRally(ri4, ra3);
		br1.leaveRally(ri3, ra3);

		br1.addRiderPoints(1, 14);
		br1.addRiderPoints(3, 9);

		System.out.print(br1.getContenders(10));
		System.out.print(br1.getAllBranchInfo());

	}

}