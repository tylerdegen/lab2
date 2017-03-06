There are a large number of sample classes for this homework.  
You can
look up the information in the doc directory for each class.  
Here's a
rundown of each class and what it does.


Mars Domain Information:

MarsMap: a data structure that reads in the data file and constructs a
	 number of MarsPlace objects.  Also has a convenience function
	 getDistance which will tell you the distance between two
	 adjacent places.


MarsPlace: a data structure about an individual place on the map.  You can
	 get the names of adjacent places, the distance to adjacent objects,
	 the SamplePercept associated with the place, the name of the place
	 and the x and y coordinates of the place.


Queues:

SearchQueue: gives the interface for any search queue.  You can insert a 
	 SearchNode into the queue, get the next one off the queue, or
	 get the size of the queue.  The classes LifoSearchQueue,
	 FifoSearchQueue, and PrioritySearchQueue implement this interface.

	 
FifoSearchQueue: first-in-first-out queue
	 
LifoSearchQueue: last-in-first-out queue
	 
PrioritySearchQueue: gets the next SearchNode with the lowest
	    priority cost (i.e., lower is better here)

SearchNode: The bare-bones implementation needed to make a SearchQueue
	 work; it has a member priority, and a compareTo function.


BasicMapSearchNode: An example of how to extend the SearchNode to have
         a node name associated with the node.  In practice, you'll need
	 to keep more information than this in a SearchNode; this is just an
	 example of how to do it.
