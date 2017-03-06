import java.io.*;
import java.lang.*;
import java.util.*;

public class UcsMarsTraveller {
	public boolean has1;
	public boolean has2;
	public boolean has3;
	public MarsMap M;
	public MarsPlace location;
	public PrioritySearchQueue q;
	public String history;
	public float totalDistance;
	public float totalCost;
	public int nodesEnq;
	public int nodesCons;
	
	public UcsMarsTraveller(String datafile, String startPlace){
		this.has1 = false;
		this.has2 = false;
		this.has3 = false;
		this.M = new MarsMap(datafile);
		this.location = M.getPlace(startPlace);
		this.q = new PrioritySearchQueue();
		this.history = "";
		this.totalDistance = 0;
		this.totalCost = 0;
		this.nodesEnq = 0;
		this.nodesCons = 0;
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
			//System.out.println("Found 1 at " + this.location.name());
			this.has1 = true;
		}
		if(!has2 && sval == 2){
			//System.out.println("Found 2 at " + this.location.name());
			this.has2 = true;
		}
		if (!has3 && sval == 3){
			//System.out.println("Found 3 at " + this.location.name());
			this.has3 = true;
		}
		return has1 && has2 && has3;
	}
	public boolean[] packHas(){
		boolean[] ret = {has1, has2, has3};
		return ret;
	}
	
	public void printStatus(){
			System.out.println("Sequence of states: " + this.history);
			System.out.println("Distance in km: " + this.totalDistance);
			System.out.println("Total number of nodes enqueued: " + this.nodesEnq);
			System.out.println("Total number of nodes considered: " + this.nodesCons);
			System.out.println("Total cost: " + this.totalCost);
			System.out.print("\n\n");
	}
	
	public void run(){

		//while this.check() is false
		this.history += this.location.name();
		while( !this.check() ){
			//add neighbors onto queue
			String[] locations = this.location.adjacent();
			for (String loc: locations){
				BasicMapSearchNode current = new BasicMapSearchNode();
				current.set(this.totalCost + this.cost(this.location, this.M.getPlace(loc)), loc, this.history + loc, this.packHas());
				this.q.insert(current);
				this.nodesEnq++;
			}
			BasicMapSearchNode next = new BasicMapSearchNode();
			next = this.q.getNextBM();
			this.nodesCons++;
			//no -- cost was already generated in current, use from next
			//this.totalCost += this.cost(this.location, this.M.getPlace(next.nodeName);
			this.totalCost = next.priority;
			this.totalDistance += this.M.getDistance(this.location.name(), next.nodeName);
			this.history = next.history;
			this.has1 = next.has[0];
			this.has2 = next.has[1];
			this.has3 = next.has[2];
			updateLoc(next.nodeName);
			//System.out.println(this.location.name() + this.has2);
			
			//this.history += this.location.name();
		}
		if (!this.check()){
			System.out.println("Couldn't find all three given limit");
			this.printStatus();
		}
		//use DFS to find way to base
		else{
			System.out.println("Found all three samples! Returning to base.");
			System.out.println(this.location.name());
			this.printStatus();
			
			//this.printStatus();
			//reset queue
			this.q = new PrioritySearchQueue();
			
			//System.out.println(this.history);
			String visited = "";
			while (!this.location.name().equals("base")){
				String[] locations = this.location.adjacent();
				for (String loc: locations){
					BasicMapSearchNode current = new BasicMapSearchNode();
					current.set(this.cost(this.location, this.M.getPlace(loc)), loc, this.history + loc, this.packHas());
					this.q.insert(current);
					this.nodesEnq++;
					//System.out.println(loc);
				}
				BasicMapSearchNode next = new BasicMapSearchNode();
				next = this.q.getNextBM();
				//while these nodes are visited, pop them off
				while (visited.indexOf(next.nodeName) != -1){
					next = this.q.getNextBM();
					this.nodesCons++;
				}
				this.totalDistance += this.M.getDistance(this.location.name(), next.nodeName);
				this.history = next.history;
				this.has1 = next.has[0];
				this.has2 = next.has[1];
				this.has3 = next.has[2];
				updateLoc(next.nodeName);
				visited += next.nodeName;
				//System.out.println(this.location.name());
			
			}
			System.out.println("Returned to base! Success!");
			this.printStatus();
			
		}
		
	}

	//test implementation of Traveller
	public static void main(String args[]) {
		
		/*
		String startFlag = "-s";//args[0];
		String startPoint = "A";//args[1];
		String readFile = "hw2-data1.txt";//args[2];
		*/
		String startFlag = args[0];
		String startPoint = args[1];
		String readFile = args[2];
		
		UcsMarsTraveller umt = new UcsMarsTraveller(readFile, startPoint);
		//dmt.location = dmt.M.getPlace(startPoint);
		float test = umt.cost(umt.location, umt.M.getPlace("B"));
		
		//if (startFlag != "-s" || startPoint == null ||  readFile ==""){
			//System.out.print("ERROR");
			//return;
		//}
		
		//SearchNode current = new BasicMapSearchNode(test, "A", dmt);
		BasicMapSearchNode current = new BasicMapSearchNode();
		current.set(test, startPoint, startPoint, umt.packHas());
		current.priority = test;
		umt.q.insert(current);
		umt.nodesEnq++;
		umt.nodesCons++;
		
		//System.out.println("it works!");
		//System.out.println(startFlag + dmt.location.name() + readFile + test);
		umt.run();
	}
}
