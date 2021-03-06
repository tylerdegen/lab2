import java.lang.*;
import java.util.*;

/**
 * A first-in-first-out search queue
 */
public class FifoSearchQueue implements SearchQueue {
    private LinkedList myList;
    
    /**
     * Create a new FifoSearchQueue
     */
    public FifoSearchQueue() {
	myList=new LinkedList();
    }

    /**
     * Insert a SearchNode into the queue
     * @param sn the SearchNode to be inserted
     */
    public void insert(SearchNode sn) {
	myList.addLast(sn);
    }
    
        public void insertBM(BasicMapSearchNode bmsn) {
    	myList.addLast(bmsn);
    }


    /**
     * Get the size of the queue
     * @return an integer size
     */
    public int size() {
	return myList.size();
    }

    /**
     * Get the next SearchNode
     * @return a SearchNode from the "top" of the queue.
     */
    public SearchNode getNext() {
	if (myList.size()==0) {
	    return null;
	} else {
	    return (SearchNode)myList.removeFirst();
	}
    }
    
    public BasicMapSearchNode getNextBM() {
    	if (myList.size() == 0){
    		return null;
    	} else {
    		return (BasicMapSearchNode)myList.removeFirst();
    	}
    }

    /**
     * Example code: insert 5 items into the queue and pull them out again
     */
    public static void main(String[] args) {
	// as an example, add five elements to the list and empty
	// the queue in order

	// priority is meaningless here

	FifoSearchQueue Q=new FifoSearchQueue();
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
	
	    
	    
	    
	
    
	    
