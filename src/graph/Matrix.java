package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Matrix {
	private int size;
	private int[][] grids;
	private HashMap<Integer, Integer> visitedList = new HashMap<>();
	private boolean isTransitiveClosure = false;
	
	public Matrix(int size) {
		this.size = size;
		grids = new int[size][size];
	}
	
	public void addEdge(int source, int dest) {
		grids[source][dest] = GraphConstant.CONNECTED;
	}
	
	/**
	 * Matrix Breadth First Search
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
     * Matrix Depth First Search
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

        return processed.toArray(new Integer[processed.size()]);
    }

	/**
     * BFS Connected Components
     * @desc 	find all connected components in an undirected graph using BFS
     * @return 	array of array of connected vertices
     */
    public Integer[][] bfsConnectedComponents() {
        LinkedList<Integer[]> components = new LinkedList<>();
        
        for (int vertex = 0; vertex < size; vertex++) 
        	if (!hasVisited(vertex)) {
        		Integer[] processed = bfsTraverse(vertex);

        		if (processed.length >= 2) 
        			components.offer(processed);
        	}

        return components.toArray(new Integer[components.size()][]);
    }

    /**
     * DFS Connected Components
     * @desc 	find all connected components in an undirected graph using BFS
     * @return 	array of array of connected vertices
     */
    public Integer[][] dfsConnectedComponents() {
        LinkedList<Integer[]> components = new LinkedList<>();

        for (int vertex = 0; vertex < size; vertex++) 
        	if (!hasVisited(vertex)) {
        		Integer[] processed = dfsTraverse(vertex);
        		if (processed.length >= 2) 
        			components.offer(processed);
        	}

        return components.toArray(new Integer[components.size()][]);
    }

    /**
     * BFS Minimum Span Tree
     * @desc 	find the minimum number of edges that connect all vertices in a connected graph
     * @return 	a list of edges or null
     */
    public String[] bfsMinimumEdges() {
    	Integer[] processed = bfsTraverse(0);

    	// if only 1 vertex is found then there's no edge (i.e. should contain at least 2 vertices)
    	if (processed.length <= 1)
    		return null;

        String[] edges = new String[processed.length - 1];        
        for (int i = 0; i < processed.length - 1; i++) 
        	edges[i] = i + "-" + processed[i + 1];
        
        return edges;
    }

    /**
     * DFS Minimum Span Tree
     * @desc 	find the minimum number of edges that connect all vertices in a connected graph
     * @return 	a list of edges or null
     */
    public String[] dfsMinimumEdges() {
    	Integer[] processed = dfsTraverse(0);

    	// if only 1 vertex is found then there's no edge (i.e. should contain at least 2 vertices)
    	if (processed.length <= 1)
    		return null;

        String[] edges = new String[processed.length - 1];
        for (int i = 0; i < processed.length - 1; i++) 
        	edges[i] = i + "-" + processed[i + 1];
        
        return edges;
    }

    /**
     * BFS Connectivity Grid
     * @desc 	check each vertex for its connection in a directed graph
     * @return 	a table of connections for each vertex
     */
    public Integer[][] bfsConnectivityGrid() {
        Integer[][] grid = new Integer[size][size];
        for (int i = 0; i < size; i++) 
        	grid[i] = bfsTraverse(i);
                
        return grid;
    }

    /**
     * DFS Connectivity Grid
     * @desc check each vertex for its connection in a directed graph
     * @return a table of connections for each vertex
     */
    public Integer[][] dfsConnectivityGrid() {
        Integer[][] grid = new Integer[size][size];
        for (int i = 0; i < size; i++) 
        	grid[i] = dfsTraverse(i);

        return grid;
    }

    /**
     * Transitive Closure revise the matrix to determine if 2 vertices are connected to eachother
     * @desc 	loop thru each vertex and adjacent in the matrix
     *       	examine whether two connected vertices will result in possible connection with other vertices
     *       	modify the adjacent matrix when a connection is found
     */
    public void generateTransitiveClosure() {
    	if (isTransitiveClosure) 
    		return;

    	for (int row = 0; row < grids.length; row++) 
    		for (int col = 0; col < grids[row].length; col++) 
    			if (grids[row][col] == GraphConstant.CONNECTED) {
    				for (int vertex = 0; vertex < grids.length; vertex++) 
    					if (grids[vertex][row] == GraphConstant.CONNECTED) 
    						grids[vertex][col] = GraphConstant.CONNECTED;
    				
    				break;
    			}
    }
    
    public boolean areConnected(int vertA, int vertB) {
    	return grids[vertA][vertB] >= GraphConstant.CONNECTED;
    }
    
    public int findSuccessor() {
    	boolean isEdge;

    	for (int row = 0; row < size; row++) {
    		isEdge = false;

    		for (int col = 0; col < size; col++) 
    			if (grids[row][col] == GraphConstant.CONNECTED) {
    				isEdge = true;
    				break;
    			}
    		
    		if (!isEdge) 
    			return row;    		
    	}

    	return -1;
    }
    
    public void deleteVertex(int index) {
    	pivotLeft(index);
    	pivotUp(index);
    	size--;
    }
    
    /**
     * @desc	1. pivot the matrix one row up starting at the specified vertex
     * 			2. place the deleted row at the end
     * @param 	vertex index to delete
     * @param 	matrix is where the vertex is removed from
     */
    private void pivotUp(int index) {
    	int[] deleted = grids[index];
        for (int row = index; row < size; row++) 
        	grids[row] = grids[(row + 1) % size];
        
        grids[size - 1] = deleted;
    }
    
    /**
     * @desc	1. pivot the matrix one column over to the left starting at the specified vertex 
     * 			2. place the deleted col at the end
     * @param 	vertex index to delete
     * @param 	matrix is where the vertex is removed from
     */
    private void pivotLeft(int index) {
		for (int row = 0; row < size; row++) {
			int deleted = grids[row][index];

			for (int col = index; col < size - 1; col++)
    			grids[row][col] = grids[row][col + 1];

			grids[row][size - 1] = deleted;
		}
    }
    
    /********** **********/
    public boolean hasVisited(int index) {
    	return visitedList.containsKey(index);
    }
	
    private void resetVisitedList() {
    	visitedList.clear();
    }
    
    // mark the index as visited once done to avoid cycle
	private void addToVisited(int index) {
		visitedList.put(index, GraphConstant.VISITED);
	}

	/**
	 * @desc	find the immediate adjacent that has not been visited
	 * @param index
	 * @param matrix
	 * @return -1 not found | vertex index
	 */
	private int findUnvisited(int index) {
		// this ensure the index is not an element that has been pivoted to end of the list to mark as deleted
		if (index >= size) 
			return -1;

		int[] neighbors = grids[index];
		for (int adj = 0; adj < size; adj++) 
			if (neighbors[adj] == GraphConstant.CONNECTED && !hasVisited(adj)) 
				return adj;
		
		return -1;
	}
}
