package adjacent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;

public abstract class AdjListBase {
	public int size;
	public LinkedList<Edge>[] list;
	public HashMap<Integer, Integer> visitedList = new HashMap<>();
	public boolean isTransitiveClosure = false;

	/**
	 * List Breadth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	matrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
	 */
	public Integer[] bfsTraverse(int index) {
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> processed = new LinkedList<>();

		resetVisitedList();
		addToVisited(index);
		queue.push(index);
		
		while (!queue.isEmpty()) {
			int unvisited = findUnvisited((int) queue.getLast());

			if (unvisited == -1) 
				processed.offer(queue.pollLast());
			else {
				addToVisited(unvisited);
				queue.push(unvisited);
			}
		}
		
		return processed.toArray(new Integer[processed.size()]);
	}

    /**
     * List Depth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	matrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
     */
    public Integer[] dfsTraverse(int index) {
    	Stack<Integer> stack = new Stack<>();
    	LinkedList<Integer> processed = new LinkedList<>();

    	resetVisitedList();
    	addToVisited(index);
    	stack.push(index);
    	processed.offer(index);
    	
    	while (!stack.isEmpty()) {
    		int unvisited = findUnvisited(stack.peek());
    		
    		if (unvisited == -1) 
    			stack.pop();
    		else {
    			addToVisited(unvisited);
    			stack.push(unvisited);
    			processed.offer(unvisited);
    		}
    	}
    	
    	return processed.toArray(new Integer[stack.size()]);
    }
    
	public void addEdge(int source, int dest, int weight) {
		if (list[source] == null) 
			list[source] = new LinkedList<Edge>();

		list[source].offer(new Edge(source, dest, weight));
	}

	public boolean isEdge(int source, int dest) {
    	Iterator iter = list[source].listIterator();
    	
    	while (iter.hasNext()) {
    		Edge edge = (Edge) iter.next();
    		if (edge.destination == dest) 
    			return true;
    	}
    	return false;
    }
	
    public boolean isLast(int index) {
		return index == size - 1;
	}

    public void initVisitedList() {
    	visitedList = new HashMap<>();
    }

    public void resetVisitedList() {
    	visitedList.clear();
    }

    // mark the index as visited once done to avoid cycle
	public void addToVisited(int index) {
		visitedList.put(index, Vertex.VISITED);
	}

	public boolean hasVisited(int index) {
    	return visitedList.containsKey(index);
    }

	/**
	 * @desc	find the immediate adjacent from the adjacent list
	 * @param 	index
	 * @param 	adjList
	 * @return
	 */
	public int findUnvisited(int index) {
		LinkedList neighbors = list[index];
		
		if (neighbors != null) {
			Iterator iter = list[index].listIterator();		

			while (iter.hasNext()) {
				Edge next = (Edge) iter.next();

				if (!hasVisited(next.destination)) 
					return next.destination;
			}			
		}

		return -1;
	}
}
