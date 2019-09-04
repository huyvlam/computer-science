package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Matrix {
	public int size;
	public int[][] root;
	private HashMap<Integer, Integer> visitedList;
	private boolean isTransitiveClosure = false;
	
	public Matrix(int size) {
		this.size = size;
		root = new int[size][size];
	}
	
	public void addEdge(int source, int dest, int weight) {
		root[source][dest] = weight;
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
	 * @param 	matrix - the 2D matrix to check
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
    
	/**
     * BFS Connected Components
     * @desc 	find all connected components in an undirected graph using BFS
     * @return 	array of array of connected vertices
     */
    public Integer[][] bfsConnectedComponents() {
        LinkedList<Integer[]> components = new LinkedList<>();
        initVisitedList();
        
        for (int vertex = 0; vertex < size; vertex++) 
        	if (!hasVisited(vertex)) {
        		Integer[] processed = bfsTraverse(vertex);

        		if (processed != null || processed.length >= 2) 
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
        initVisitedList();

        for (int vertex = 0; vertex < size; vertex++) 
        	if (!hasVisited(vertex)) {
        		Integer[] processed = dfsTraverse(vertex);

        		if (processed != null || processed.length >= 2) 
        			components.offer(processed);
        	}

        return components.toArray(new Integer[components.size()][]);
    }

    /**
     * BFS Minimum Span Tree
     * @desc 	find the minimum number of edges that connect all vertices in a connected graph
     * @return 	a list of edges or null
     */
    public Edge[] bfsMinimumEdges() {
    	Integer[] processed = bfsTraverse(0);
    	LinkedList<Edge> edges = new LinkedList<>();

    	// if only 1 vertex is found then there's no edge (i.e. should contain at least 2 vertices)
    	if (processed == null || processed.length <= 1)
    		return null;

        for (int i = 0; i < processed.length - 1; i++) 
        	edges.offer(new Edge(i, processed[i + 1], 0));
        
        return edges.toArray(new Edge[edges.size()]);
    }

    /**
     * DFS Minimum Span Tree
     * @desc 	find the minimum number of edges that connect all vertices in a connected graph
     * @return 	a list of edges or null
     */
    public Edge[] dfsMinimumEdges() {
    	Integer[] processed = dfsTraverse(0);
    	LinkedList<Edge> edges = new LinkedList<>();

    	// if only 1 vertex is found then there's no edge (i.e. should contain at least 2 vertices)
    	if (processed == null || processed.length <= 1)
    		return null;

        for (int i = 0; i < processed.length - 1; i++) 
        	edges.offer(new Edge(i, processed[i + 1], 0));
        
        return edges.toArray(new Edge[edges.size()]);
    }

    /**
     * BFS Connectivity Grid
     * @desc 	check each vertex for its connection in a directed graph
     * @return 	a table of connections for each vertex
     */
    public Integer[][] bfsConnectivityTable() {
        Integer[][] table = new Integer[size][size];
        for (int i = 0; i < size; i++) 
        	table[i] = bfsTraverse(i);
                
        return table;
    }

    /**
     * DFS Connectivity Grid
     * @desc check each vertex for its connection in a directed graph
     * @return a table of connections for each vertex
     */
    public Integer[][] dfsConnectivityTable() {
        Integer[][] table = new Integer[size][size];
        for (int i = 0; i < size; i++) 
        	table[i] = dfsTraverse(i);

        return table;
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

    	for (int row = 0; row < root.length; row++) 
    		for (int col = 0; col < root[row].length; col++) 
    			if (root[row][col] >= Vertex.CONNECTED) {
    				for (int vertex = 0; vertex < root.length; vertex++) 
    					if (root[vertex][row] >= Vertex.CONNECTED) 
    						root[vertex][col] = root[vertex][row];
    				
    				break;
    			}
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

    /**
     * @desc	1. pivot row up by one at the specified index
     * 			2. pivot column left by one at the specified index
     * 			3. decrement size to mark the out of bound index as deleted
     */
    public void deleteVertex(int index) {
    	// if deleted is the last element -> no need to pivot, just decrement the size
    	if (!lastIndex(index)) {
        	pivotLeft(index);
        	pivotUp(index);
    	}
    	size--;
    }
    
    /**
     * @desc	1. pivot the matrix one row up starting at the specified vertex
     * 			2. place the deleted row at the end
     * @param 	vertex index to delete
     * @param 	matrix is where the vertex is removed from
     */
    private void pivotUp(int index) {
    	int[] deleted = root[index];
        for (int row = index; row < size; row++) 
        	root[row] = root[(row + 1) % size];
        
        root[size - 1] = deleted;
    }
    
    /**
     * @desc	1. pivot the matrix one column over to the left starting at the specified vertex 
     * 			2. place the deleted col at the end
     * @param 	vertex index to delete
     * @param 	matrix is where the vertex is removed from
     */
    private void pivotLeft(int index) {
		for (int row = 0; row < size; row++) {
			int deleted = root[row][index];

			for (int col = index; col < size - 1; col++)
    			root[row][col] = root[row][col + 1];

			root[row][size - 1] = deleted;
		}
    }
    
    public boolean hasSuccessor(int index) {
    	for (int neighbor: root[index]) 
    		if (neighbor == 1) 
    			return true;
    	
    	return false;
    }
    
    public boolean isEdge(int vertA, int vertB) {
    	return root[vertA][vertB] >= Vertex.CONNECTED;
    }
    
    public boolean hasVisited(int index) {
    	return visitedList.containsKey(index);
    }
	
    private void initVisitedList() {
    	visitedList = new HashMap<>();
    }
    
    // mark the index as visited once done to avoid cycle
	private void addToVisited(int index) {
		visitedList.put(index, Vertex.VISITED);
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

		int[] neighbors = root[index];
		for (int adj = 0; adj < size; adj++) 
			if (neighbors[adj] >= Vertex.CONNECTED && !hasVisited(adj)) 
				return adj;
		
		return -1;
	}
	
	private boolean lastIndex(int index) {
		return index == size - 1;
	}
}
