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

    /**
     * construct a new node
     */
    public BasicMapSearchNode() {
	priority=0;
	nodeName=null;
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
