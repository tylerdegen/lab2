import java.lang.*;
import java.util.*;

/**
 * MarsPlace: a class that stores information about places on Mars
 *
 * @author Eric Fosler-Lussier
 * @version 1.0
 */
public class MarsPlace {
    private String myName;
    private float myXcoord;
    private float myYcoord;
    private String[] myAdjacent;
    private float[] myDistances;
    private SamplePercept myPercept;
    private Hashtable myHash; // facilitate adjacency lookup

    /**
     * Create a sample percept from a string
     * @param line A String containing the integer percept
     */
    public MarsPlace(String line) {
	StringTokenizer strtok=new StringTokenizer(line,",");
	myName=strtok.nextToken();
	myPercept=new SamplePercept(strtok.nextToken());
	myXcoord=Float.parseFloat(strtok.nextToken());
	myYcoord=Float.parseFloat(strtok.nextToken());

	int lim=strtok.countTokens()/2;
	myAdjacent=new String[lim];
	myDistances=new float[lim];
	myHash=new Hashtable();

	int i=0;
	while(strtok.hasMoreTokens()) {
	    myAdjacent[i]=strtok.nextToken();
	    myHash.put(myAdjacent[i],new Integer(i));
	    myDistances[i]=Float.parseFloat(strtok.nextToken());
	    i++;
	}
    }

    /**
     * Get the name of this place
     * @return The string value of the name
     */
    public String name() {
	return myName;
    }

    /**
     * Get the name of adjacent places
     * @return The string values of the adjacent places
     */
    public String[] adjacent() {
	return myAdjacent;
    }

    /**
     * Get the x-coordinate of this place
     * @return A float with the x-coordinate
     */
    public float xcoord() {
	return myXcoord;
    }


    /**
     * Get the y-coordinate of this place
     * @return A float with the y-coordinate
     */
    public float ycoord() {
	return myYcoord;
    }

    /**
     * Get the distance to an adjacent place
     * @return The distance to the place, -1 if not adjacent.
     */
    public float distanceTo(String adjacent) {
	Integer i=(Integer)myHash.get(adjacent);
	if (i==null) {
	    return -1;
	} else {
	    return myDistances[i.intValue()];
	}
    }

    /**
     * Get the soil sample percept for this place
     * @return a SamplePercept with the percept
     */
    public SamplePercept getSamplePercept() {
	return myPercept;
    }

    /**
     * test routines
     */
    public static void main(String[] args) {
	MarsPlace A=new MarsPlace("A,1,1,1,B,3,C,4");
	MarsPlace B=new MarsPlace("B,2,1,4,A,3,C,5");
	MarsPlace C=new MarsPlace("C,2,5,1,A,4,B,5");

	System.out.println("Path between A and B is "+
			   A.distanceTo("B")+
			   " long.");

	System.out.println("Path between B and A is "+
			   B.distanceTo("A")+
			   " long.");

	System.out.println("Path between A and C is "+
			   A.distanceTo("C")+
			   " long.");
    }

}
