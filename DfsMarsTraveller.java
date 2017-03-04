import java.io.*;
import java.lang.*;
import java.util.*;

public class DfsMarsTraveller {
	public boolean has1;
	public boolean has2;
	public boolean has3;
	public MarsMap M;
	public MarsPlace startPlace;
	
	public DfsMarsTraveller(String datafile){
		has1 = false;
		has2 = false;
		has3 = false;
		M = new MarsMap(datafile);
	}

	//test implementation of Traveller
	public static void main(String args[]) {
		
		String startFlag = args[0];
		String startPoint = args[1];
		String readFile = args[2];
		
		DfsMarsTraveller dmt = new DfsMarsTraveller("hw2-data1.txt");
		MarsPlace startPlace = dmt.M.getPlace(startPoint);
		
		
		
		//if (startFlag != "-s" || startPoint == null ||  readFile ==""){
			//System.out.print("ERROR");
			//return;
		//}
		
		System.out.println("it works!");
		System.out.println(startFlag + startPlace.name() + readFile);
	}
}