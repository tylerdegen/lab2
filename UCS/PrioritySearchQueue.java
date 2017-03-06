import java.lang.*;
import java.util.*;

/**
 * A priorty search queue: puts out SearchNodes in order of increasing priority (cost)
 */
public class PrioritySearchQueue implements SearchQueue {
    private TreeSet mySet;

    /**
     * Create a new FifoSearchQueue
     */
    public PrioritySearchQueue() {
	mySet=new TreeSet();
    }

    /**
     * Create a new FifoSearchQueue
     */
    public void insert(SearchNode sn) {
	mySet.add(sn);
    }
    public void insertBM(SearchNode bmsn) {
	mySet.add(bmsn);
    }


    /**
     * Get the size of the queue
     * @return an integer size
     */
    public int size() {
	return mySet.size();
    }

    /**
     * Get the next SearchNode
     * @return a SearchNode from the "top" of the queue.
     */
    public SearchNode getNext() {
	if (mySet.size()==0) {
	    return null;
	} else {
	    Object o=mySet.first();
	    mySet.remove(o);
	    return (SearchNode)o;
	}
    }
    
    public BasicMapSearchNode getNextBM() {
	if (mySet.size()==0) {
	    return null;
	} else {
	    Object o=mySet.first();
	    mySet.remove(o);
	    return (BasicMapSearchNode)o;
	}
    }

    /**
     * Example code: insert 5 items into the queue and pull them out again
     */
    public static void main(String[] args) {
	// as an example, add five elements to the queue and empty
	// the queue in order

	// outputs nodes in priority order (low cost to high cost)
	// example: vowels before consonants

	PrioritySearchQueue Q=new PrioritySearchQueue();
	BasicMapSearchNode bsn=new BasicMapSearchNode();
	bsn.priority=1;
	bsn.nodeName="A";
	Q.insert(bsn);
	
	bsn=new BasicMapSearchNode();
	bsn.priority=2;
	bsn.nodeName="B";
	Q.insert(bsn);

	bsn=new BasicMapSearchNode();
	bsn.priority=2;
	bsn.nodeName="C";
	Q.insert(bsn);

	bsn=new BasicMapSearchNode();
	bsn.priority=2;
	bsn.nodeName="D";
	Q.insert(bsn);

	bsn=new BasicMapSearchNode();
	bsn.priority=1;
	bsn.nodeName="E";
	Q.insert(bsn);

	while(Q.size()>0 ) {
	    bsn=(BasicMapSearchNode)Q.getNext();
	    System.out.println("Node "+bsn.nodeName+" has priority "+bsn.priority);
	}
    }
	
	

}	    
	
	    
	    
	    
	
    
	    
