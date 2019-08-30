package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class GraphTraversalUtil {
	private static HashMap<Integer, Integer> visitedList = new HashMap<>();
	private static int UNVISITED = 0;
	private static int CONNECTED = 1, VISITED = 1;

	/**
	 * List Breadth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	matrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
	 */
	public static Integer[] bfsList(int index, int[][] adjList) {
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> processed = new LinkedList<>();

		resetVisitedList();
		addToVisited(index);
		queue.push(index);
		
		while (!queue.isEmpty()) {
			int unvisited = findListUnvisited((int) queue.getLast(), adjList);

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
	 * Matrix Breadth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	matrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
	 */
	public static Integer[] bfsMatrix(int index, int[][] matrix) {
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> processed = new LinkedList<>();

		resetVisitedList();
		addToVisited(index);
		queue.push(index);
		
		while (!queue.isEmpty()) {
			int unvisited = findMatrixUnvisited((int) queue.getLast(), matrix);

			if (unvisited == -1) 
				processed.offer(queue.pollLast());
			else {
				addToVisited(unvisited);
				queue.push(unvisited);
			}
		}
    	
		return processed.toArray(new Integer[processed.size()]);
    }
	
    public static Integer[] dfsList(int index, int[][] adjList) {
    	Stack<Integer> stack = new Stack<>();
    	LinkedList<Integer> processed = new LinkedList<>();

    	resetVisitedList();
    	addToVisited(index);
    	stack.push(index);
    	processed.offer(index);
    	
    	while (!stack.isEmpty()) {
    		int unvisited = findListUnvisited(stack.peek(), adjList);
    		
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
    
    /**
     * Matrix Depth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	matrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
     */
    public static Integer[] dfsMatrix(int index, int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> processed = new LinkedList<>();

        resetVisitedList();
        addToVisited(index);
        stack.push(index);
        processed.offer(index);
        
        while (!stack.isEmpty()) {
        	int unvisited = findMatrixUnvisited(stack.peek(), matrix);
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
    
	/**
	 * @desc	check if the specified vertex is in visited list
	 * @param 	vertex index
	 * @return	T/F
	 */
	public static boolean hasVisited(int index) {
		return visitedList.containsKey(index);
	}
	
    private static void resetVisitedList() {
    	visitedList.clear();
    }
    
    // mark the index as visited once done to avoid cycle
	private static void addToVisited(int index) {
		visitedList.put(index, VISITED);
	}

	/**
	 * @desc	find the immediate adjacent from the adjacent list
	 * @param 	index
	 * @param 	adjList
	 * @return
	 */
	private static int findListUnvisited(int index, int[][] adjList) {
		int[] adjacents = adjList[index];
		for (int adj: adjacents) 
			if (!hasVisited(adj)) 
				return adj;
		
		return -1;
	}
	
	// find the immediate connected neighbor that has not been visited
	private static int findMatrixUnvisited(int index, int[][] matrix) {
		int[] neighbors = matrix[index];
		for (int adj = 0; adj < neighbors.length; adj++) 
			if (neighbors[adj] == CONNECTED && !hasVisited(adj)) 
				return adj;
		
		return -1;
	}
}
