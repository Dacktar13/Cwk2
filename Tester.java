
/**
 * Write a description of class Tester here.
 * 
 * @author (S.D.Wheeler) 
 * @version (04/03/2013)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private Rider ri1 = new Rider(1, "Seth", "Senior");
    private Rider ri2 = new Rider(2, "Jasper", "Junior");
    private Rider ri3 = new Rider(3, "Claire", "Adult");
    private Rider ri4 = new Rider(4, "Jack", "Youth");
    private Rally ra1 = new Rally("HT1", "Hatfield House", 5, 2, 4);

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        ra1.book(ri1);
        ra1.book(ri2);
        ra1.book(ri3);
        ra1.book(ri4);
        System.out.print(ra1.getRidersOnRally());
    }

}