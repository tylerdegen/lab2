import java.lang.*;
import java.util.*;

/**
 * All SearchQueues implement three functions: insert, size, and getNext.
 */
public interface SearchQueue {
    /**
     * Insert a SearchNode into the queue
     * @param sn the SearchNode to be inserted
     */
    public void insert(SearchNode sn);
    /**
     * Get the size of the queue
     * @return an integer size
     */
    public int size();
    /**
     * Get the next SearchNode
     * @return a SearchNode from the "top" of the queue.
     */
    public SearchNode getNext();
}	    
	
	    
	    
	    
	
    
	    
