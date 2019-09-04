package adjacent;

import java.util.LinkedList;

public class AdjMatrix extends AdjMatrixBase {
	public AdjMatrix(int size) {
		this.size = size;
		matrix = new int[size][size];
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

    	for (int row = 0; row < matrix.length; row++) 
    		for (int col = 0; col < matrix[row].length; col++) 
    			if (matrix[row][col] >= Vertex.CONNECTED) {
    				for (int vertex = 0; vertex < matrix.length; vertex++) 
    					if (matrix[vertex][row] >= Vertex.CONNECTED) 
    						matrix[vertex][col] = matrix[vertex][row];
    				
    				break;
    			}
    }
    
    /**
     * @desc	1. pivot row up by one at the specified index
     * 			2. pivot column left by one at the specified index
     * 			3. decrement size to mark the out of bound index as deleted
     */
    public void deleteVertex(int index) {
    	// if deleted is the last element -> no need to pivot, just decrement the size
    	if (!isLast(index)) {
        	pivotLeft(index);
        	pivotUp(index);
    	}
    	size--;
    }
    
    /**
     * @desc	1. pivot the matrix one row up starting at the specified vertex
     * 			2. place the deleted row at the end
     * @param 	vertex index to delete
     * @param 	adjMatrix is where the vertex is removed from
     */
    private void pivotUp(int index) {
    	int[] deleted = matrix[index];
        for (int row = index; row < size; row++) 
        	matrix[row] = matrix[(row + 1) % size];
        
        matrix[size - 1] = deleted;
    }
    
    /**
     * @desc	1. pivot the matrix one column over to the left starting at the specified vertex 
     * 			2. place the deleted col at the end
     * @param 	vertex index to delete
     * @param 	adjMatrix is where the vertex is removed from
     */
    private void pivotLeft(int index) {
		for (int row = 0; row < size; row++) {
			int deleted = matrix[row][index];

			for (int col = index; col < size - 1; col++)
    			matrix[row][col] = matrix[row][col + 1];

			matrix[row][size - 1] = deleted;
		}
    }
}
