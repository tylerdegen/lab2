import java.lang.*;
import java.util.*;

/**
 * A sample implementation of a SearchNode
 */
public class BasicMapSearchNode extends SearchNode {
    // public float priority defined in SearchNode
    /**
     * the name of the node
     */
    public String nodeName;
	
	//state of node
	public DfsMarsTraveller dmt;

    /**
     * construct a new node
     */
    public BasicMapSearchNode() {
		
	this.priority=0;
	this.nodeName = null;
	this.dmt = null;
    }
	
	public void set(float pri, String name, DfsMarsTraveller d){
		this.priority = pri;
		this.nodeName = name;
		this.dmt = d;
	}

    /**
     * compare this SearchNode to another
     * @return an integer, -1, 0, or 1
     *
     * Returns -1 if this node has lower cost (priority), 1 if this node has higher cost (priority), otherwise returns the comparison of nodeName strings (same names imply the same node 
     */
    public int compareTo(Object s) {
	BasicMapSearchNode sn=(BasicMapSearchNode)s;
	if (priority<sn.priority) {
	    return -1;
	} else if (priority==sn.priority) {
	    return nodeName.compareTo(sn.nodeName);
	} else {
	    return 1;
	}
    }
	
}
