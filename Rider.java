/**
 * The Rider class stores information about a rider 
 * @author A.A.Marczyk 
 * @version 27/02/2013
 * 
 */
public class Rider                                
{
    // fields
    public int idNumber;                           
    private String name;  
    private String type;  
    private int points;

     
    /**
    * Creates a Rider with a unique id number and a name initialised from 
    * parameter values, 
    * pre-condition : ty == "Junior" || ty == "Youth" ||ty == "Adult" || ty == "Senior"
    * @param id it is the responsibility of the client to ensure that id is a unique number
    * @param n is the String representation of the rider's name
    * @param ty is the type of rider. "Junior", "Youth", "Adult", "Senior"
    */ 
    public Rider (int id, String n, String ty)    
    {
        idNumber = id;                              
        name = n;
        points = 0;
        type = ty.toLowerCase(); //!!!!notice this
    }
    
    
    /**
    * allows a riders points to be incremented
    * @param pts is the number by which a rider's points will be incremented
    */ 
    public void incrementPoints (int pts)
    {
        points = points + pts;                                
    }

    /**
    * allows a riders points to be decremented
    * @param pts is the number by which a rider's points will be incremented
    */ 
    public void decrementPoints (int pts)
    {
        points = points - pts;                                
    }    
    /**
    * returns rider id as an int
    * @return value returned is rider id as an int
    */                                                       
    public int getIdNo ()                           
    {
        return idNumber;                           
    }   

    /**
    * returns rider name as a String
    * @return value returned is rider name as a String
    */ 
    public String getName ()
    {
        return name;                                
    }
    
    /**
    * returns rider's points total as an int
    * @return value returned is rider points as an int
    */ 
    public int getPoints ()
    {
        return points;                                
    }
    
    /**
    * returns rider's ridership type as a String
    * @return value returned is ridership type as a String
    */ 
    public String getType ()
    {
        return type;                                
    }
    
    /** returns true if rider is a junior, else false
     * @return true if rider is a junior, else false
     */
    public boolean isJunior()
    {
        return type.equals("junior");
    }

    /**
    * Returns a String represnetation of the rider
    * @return returns a String representation of the rider, including the id number,name,type and points
    */
    public String toString()
    {
        return ("\n" + idNumber + "  " + name + "\n    Membership Type: " + type 
            + "  Total points : " + points );
    } 
    
    /**
    * Returns true if the parameter is the same as the rider's id number
    * @param number is the value to be compared with the rider's id
    * @return returns true if the rider's id number is the same as that of the parameter,
    * false otherwise
    */
    public boolean isSameID(int number)
    {
        return number == idNumber ;
    }
}
   