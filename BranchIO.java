import java.util.Scanner;

/**
 * Declares an Branch object and a Scanner object. Outputs a menu 
 * (prepares to keep outputting the menu until user choose option -1)
 * @author Seth Wheeler 
 * @version 06/03/2013
 */

public class BranchIO {

	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args)
    {
        // declare variables
        Branch branch1 = new Branch("Hertfordshire");

        int choice = 0;
        choice = getOption();

        while (choice != 9)
        {            
            // process choice
            if (choice == 1)
            {
                //Show all Branch information
            	System.out.print(branch1.getAllBranchInfo());
            }
            if (choice == 2)
            {
                //Add rider
            	System.out.print("Please enter Rider ID!");
            	int rId = reader.nextInt();
            	
            	System.out.print("Please enter Rider Name!");
            	reader.nextLine();
            	String rName = reader.nextLine();
            	
            	System.out.print("Please enter Rider Type! (Senior, Adult, Youth, Junior)");
            	String rType = reader.nextLine();
            	
            	branch1.addRider(new Rider(rId, rName, rType));
            }
            if (choice == 3)
            {
                //Add rally
            	System.out.print("Please enter Rally ID!");
            	reader.nextLine();
            	String rId = reader.nextLine();
            	
            	System.out.print("Please enter Rally Venue!");
            	String rName = reader.nextLine();
            	
            	System.out.print("Please enter the number of days the Rally is running!");
            	int rDays = reader.nextInt();
            	
            	System.out.print("Please enter the Rally Fee Code! (0,1,2,3,4)");
            	int rFeeCode = reader.nextInt();
            	
            	System.out.print("Please enter the maximum number of Riders allowed to book on the Rally!");
            	int rPlaces = reader.nextInt();
            	
            	branch1.addRally(new Rally(rId, rName, rDays, rFeeCode, rPlaces));
            }
            if (choice == 4)
            {
                //Book a rider on a rally
            	
            	System.out.print("Please enter Rider ID!");
            	int rideId = reader.nextInt();
            	
            	System.out.print("Please enter Rally ID!");
            	reader.nextLine();
            	String rallyId = reader.nextLine();
            	         	
            	branch1.joinRally(branch1.findRider(rideId), branch1.findRally(rallyId));
            }
            if (choice == 5)
            {
                //Add points to rider
            	
            	System.out.print("Please enter Rider ID!");
            	int rId = reader.nextInt();
            	
            	System.out.print("Please enter number of points awarded!");
            	int pts = reader.nextInt();
            	
            	branch1.addRiderPoints(rId, pts);
            }

            choice = getOption();
        }
    }

    private static int getOption()
    {
        // output menu
        System.out.println("What would you like to do ?");
        System.out.println("1. Show all Branch information");
        System.out.println("2. Add rider ");
        System.out.println("3. Add rally");
        System.out.println("4. Book a rider on a rally");
        System.out.println("5. Add points to rider");                                       
        System.out.println("9. Quit");
        System.out.println("Enter your choice");
        // read choice
        return reader.nextInt();
    }
	
}
