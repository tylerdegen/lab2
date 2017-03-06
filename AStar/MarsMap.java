import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * MarsMap: a class that stores a set of MarsPlaces
 *
 * @author Eric Fosler-Lussier
 * @version 1.0
 */
public class MarsMap {
    private Hashtable myHash; // facilitate adjacency lookup

    /**
     * Create a map from a file
     * @param line A String containing the file name
     */
    public MarsMap(String filename) {
	BufferedReader myFile=null;
	try {
            myFile=new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            System.err.println("Ooops!  I can't seem to load the file \""+filename+"\", do you have the file in the correct place?");
            System.exit(1);
        }
        initialize(myFile);
    }

    /**
     * Create a map from standard input
     */
    public MarsMap() {
	BufferedReader myFile=null;
	try {
            myFile=new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.err.println("Ooops!  I can't seem to read the file on the standard input!");
            System.exit(1);
        }
        initialize(myFile);
    }

    private void initialize(BufferedReader myFile) {
	String line;
	myHash=new Hashtable();

	try {
	    while((line=myFile.readLine())!=null) {
		MarsPlace p=new MarsPlace(line);
		myHash.put(p.name(),p);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.err.println("Oops!  Badly formatted file!");
	    System.exit(1);
	}
    }

    /**
     * Get the MarsPlace associated with a name
     * @param place a String with the name of the place
     * @return a MarsPlace object (null if place is not on map)
     */
    public MarsPlace getPlace(String place) {
	return (MarsPlace)myHash.get(place);
    }

    /**
     * Get the distance between two place names (if adjacent)
     * @param place1 a String with the name of place 1
     * @param place2 a String with the name of place 2
     * @return float distance, -1 if place1 and place2 are not adjacent
     */
    public float getDistance(String place1, String place2) {
	MarsPlace mp1=getPlace(place1);
	if (mp1==null) {
	    return -1;
	}
	return mp1.distanceTo(place2);
    }


    /**
     * Get the distance between two place names (if adjacent)
     * @param place1 a MarsPlace 
     * @param place2 a MarsPlace
     * @return float distance, -1 if place1 and place2 are not adjacent
     */
    public float getDistance(MarsPlace place1, MarsPlace place2) {
	if (place1==null || place2==null) {
	    return -1;
	}
	return place1.distanceTo(place2.name());
    }




    /**
     * test routines
     */
    public static void main(String[] args) {
	MarsMap M=new MarsMap();
	
	System.out.println("Path between A and B is "+
			   M.getDistance("A","B")+
			   " long.");
    

	System.out.println("Path between B and A is "+
			   M.getDistance("B","A")+
			   " long.");


	System.out.println("Path between A and C is "+
			   M.getDistance("A","C")+
			   " long.");
    }
}
