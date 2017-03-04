import java.io.*;
import java.lang.*;
import java.util.*;

public class DfsMarsTraveller {
	boolean has1 = false;
	boolean has2 = false;
	boolean has3 = false;
	

	//test implementation of Traveller
	public static void main(String args[]) {
		String startFlag = args[0];
		String startPoint = args[1];
		MarsMap M = new MarsMap("hw2-data1.txt");
		//MarsPlace startPlace = new MarsPlace();
		MarsPlace startPlace = M.getPlace(startPoint);
		
		String readFile = args[2];
		
		//if (startFlag != "-s" || startPoint == null ||  readFile ==""){
			//System.out.print("ERROR");
			//return;
		//}
		
		System.out.println("it works!");
		System.out.println(startFlag + startPlace.name() + readFile);
	}
}