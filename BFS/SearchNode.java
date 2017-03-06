import java.lang.*;
import java.util.*;

/**
 * This class describes basic mechanisms needed for a SearchNode.  You
 * will need to extend classes from this one and implement compareTo
 * in those classes (see BasicMapSearchNode.java for an example.
 */
public abstract class SearchNode implements Comparable {
    /**
     * A cost for comparing SearchNodes
     */
    public float priority;
    /**
     * Compare another SearchNode to this one.
     * @return -1 if this node has lower cost (priority), 0 if same, or 1 if higher cost (priority)
     */
    abstract public int compareTo(Object o);
}
