import java.io.*;
import java.lang.*;
import java.util.*;

public class DfsMarsTraveller {
	public boolean has1;
	public boolean has2;
	public boolean has3;
	public MarsMap M;
	public MarsPlace location;
	public LifoSearchQueue q;
	
	public DfsMarsTraveller(String datafile, String startPlace){
		has1 = false;
		has2 = false;
		has3 = false;
		M = new MarsMap(datafile);
		location = M.getPlace(startPlace);
		q = new LifoSearchQueue();
	}
	
	public float cost(MarsPlace m1, MarsPlace m2){
		float distance = M.getDistance(m1, m2);
		float sum = has1 ? 1 : 0;
		sum += has2 ? 1 : 0;
		sum += has3 ? 1 : 0;
		return distance + 100 * (3 - sum);
	}

	//test implementation of Traveller
	public static void main(String args[]) {
		
		String startFlag = args[0];
		String startPoint = args[1];
		String readFile = args[2];
		
		DfsMarsTraveller dmt = new DfsMarsTraveller("hw2-data1.txt", startPoint);
		//dmt.location = dmt.M.getPlace(startPoint);
		float test = dmt.cost(dmt.location, dmt.M.getPlace("B"));
		
		//if (startFlag != "-s" || startPoint == null ||  readFile ==""){
			//System.out.print("ERROR");
			//return;
		//}
		
		//SearchNode current = new BasicMapSearchNode(test, "A", dmt);
		BasicMapSearchNode current = new BasicMapSearchNode();
		current.set(test, "A", dmt);
		current.priority = test;
		dmt.q.insert(current);
		
		System.out.println("it works!");
		System.out.println(startFlag + dmt.location.name() + readFile + test);
	}
}