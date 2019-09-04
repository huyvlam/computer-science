package adjacent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public abstract class AdjMatrixBase implements AdjacentOutline {
	public int size;
	public int[][] matrix;
	public HashMap<Integer, Integer> visitedList;
	public boolean isTransitiveClosure = false;

	/**
	 * Matrix Breadth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	adjMatrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
	 */
	public Integer[] bfsTraverse(int index) {
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> processed = new LinkedList<>();
		
		if (!hasSuccessor(index)) 
			return null;

		initVisitedList();
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
     * Matrix Depth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	adjMatrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
     */
    public Integer[] dfsTraverse(int index) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> processed = new LinkedList<>();
        
        if (!hasSuccessor(index)) 
        	return null;

        initVisitedList();
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

        return processed.toArray(new Integer[processed.size()]);
    }
	
	public void addEdge(int source, int dest, int weight) {
		matrix[source][dest] = weight;
	}

	public boolean isEdge(int source, int dest) {
    	return matrix[source][dest] >= Vertex.CONNECTED;
    }
    
    public boolean hasSuccessor(int index) {
    	for (int neighbor: matrix[index]) 
    		if (neighbor == 1) 
    			return true;
    	
    	return false;
    }

    /**
     * @desc	iterate thru matrix and check each vertex for connection:
     * 			1. if no connection -> vertex has no successor -> return -1
     * 			2. if connection found -> return vertex index
     * @return
     */
    public int findSuccessor() {
    	boolean edge;

    	for (int row = 0; row < size; row++) {
    		edge = false;

    		for (int col = 0; col < size; col++) {
    			edge = isEdge(row, col);
    			
    			if (edge)
    				break;
    		}
    		
    		if (!edge) 
    			return row;    		
    	}

    	return -1;
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
	 * @desc	find the immediate adjacent that has not been visited
	 * @param index
	 * @param adjMatrix
	 * @return -1 not found | vertex index
	 */
	public int findUnvisited(int index) {
		// this ensure the index is not an element that has been pivoted to end of the list to mark as deleted
		if (index >= size) 
			return -1;

		int[] neighbors = matrix[index];
		for (int adj = 0; adj < size; adj++) 
			if (neighbors[adj] >= Vertex.CONNECTED && !hasVisited(adj)) 
				return adj;
		
		return -1;
	}
}
