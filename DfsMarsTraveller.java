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
	public String history;
	
	public DfsMarsTraveller(String datafile, String startPlace){
		this.has1 = false;
		this.has2 = false;
		this.has3 = false;
		this.M = new MarsMap(datafile);
		this.location = M.getPlace(startPlace);
		this.q = new LifoSearchQueue();
		this.history = "";
	}
	
	public float cost(MarsPlace m1, MarsPlace m2){
		float distance = this.M.getDistance(m1, m2);
		float sum = has1 ? 1 : 0;
		sum += has2 ? 1 : 0;
		sum += has3 ? 1 : 0;
		return distance + 100 * (3 - sum);
	}
	
	public void updateLoc(String loc){
		this.location = this.M.getPlace(loc);
	}
	
	public boolean check(){
		SamplePercept s = location.getSamplePercept();
		int sval = s.value();
		if (!has1 && sval == 1){
			this.has1 = true;
		}
		if(!has2 && sval == 2){
			this.has2 = true;
		}
		if (!has3 && sval == 3){
			this.has3 = true;
		}
		return has1 && has2 && has3;
	}
	
	public void run(){
		//String[] locations = this.location.adjacent();
		//add the first round of neighbors onto the queue
		/*
		for (String loc: locations){
			BasicMapSearchNode current = new BasicMapSearchNode();
			current.set(this.cost(this.location, this.M.getPlace(loc)), loc, this);
			this.q.insert(current);
			System.out.println(loc);
		}
		BasicMapSearchNode next = new BasicMapSearchNode();
		next = this.q.getNextBM();
		updateLoc(next.nodeName);
		System.out.println(this.location.name() + this.has2);
		check();
		System.out.println(this.has2);
		*/
		//while this.check() is false
		int limit = 0;
		while( !this.check() && limit < 20){
			//add neighbors onto queue
			String[] locations = this.location.adjacent();
			for (String loc: locations){
				BasicMapSearchNode current = new BasicMapSearchNode();
				current.set(this.cost(this.location, this.M.getPlace(loc)), loc, this);
				this.q.insert(current);
				//System.out.println(loc);
			}
			BasicMapSearchNode next = new BasicMapSearchNode();
			next = this.q.getNextBM();
			updateLoc(next.nodeName);
			System.out.println(this.location.name() + this.has2);
			limit++;
		}
		if (!this.check()){
			System.out.println("Couldn't find all three given limit");
		}
		//use DFS to find way to base
		else{
		
		}
		
	}

	//test implementation of Traveller
	public static void main(String args[]) {
		
		
		String startFlag = "-s";//args[0];
		String startPoint = "A";//args[1];
		String readFile = "hw2-data1.txt";//args[2];
		
		DfsMarsTraveller dmt = new DfsMarsTraveller(readFile, startPoint);
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
		dmt.run();
	}
}
