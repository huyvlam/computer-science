package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class AdjacentList {
	private int size;
	private int[][] root;
	private HashMap<Integer, Integer> visitedList = new HashMap<>();
	private boolean isTransitiveClosure = false;

	public AdjacentList(int size) {
		this.size = size;
		root = new int[size][size];
	}

	/**
	 * List Breadth First Search
	 * @param 	index - starting point where traverse begin
	 * @param 	matrix - the 2D matrix to check
	 * @return	list of connected vertex that was visited
	 */
	public Integer[] bfsTraverse(int index, int[][] adjList) {
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> processed = new LinkedList<>();

		resetVisitedList();
		addToVisited(index);
		queue.push(index);
		
		while (!queue.isEmpty()) {
			int unvisited = findUnvisited((int) queue.getLast(), adjList);

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
    public Integer[] dfsTraverse(int index, int[][] adjList) {
    	Stack<Integer> stack = new Stack<>();
    	LinkedList<Integer> processed = new LinkedList<>();

    	resetVisitedList();
    	addToVisited(index);
    	stack.push(index);
    	processed.offer(index);
    	
    	while (!stack.isEmpty()) {
    		int unvisited = findUnvisited(stack.peek(), adjList);
    		
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

    public boolean hasVisited(int index) {
    	return visitedList.containsKey(index);
    }
	
    private void resetVisitedList() {
    	visitedList.clear();
    }
    
    // mark the index as visited once done to avoid cycle
	private void addToVisited(int index) {
		visitedList.put(index, Vertex.VISITED);
	}

	/**
	 * @desc	find the immediate adjacent from the adjacent list
	 * @param 	index
	 * @param 	adjList
	 * @return
	 */
	private int findUnvisited(int index, int[][] adjList) {
		int[] adjacents = adjList[index];
		for (int adj: adjacents) 
			if (!hasVisited(adj)) 
				return adj;
		
		return -1;
	}
}
