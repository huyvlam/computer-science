package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class MatrixUtil {
	private static int UNVISITED = 0;
	private static int CONNECTED = 1, VISITED = 1;

	/**
     * BFS Connected Components
     * @desc find all connected components in an undirected graph using BFS
     * @return array of array of connected vertices
     */
    public static Integer[][] bfsConnectedComponents(int[][] matrix) {
        LinkedList<Integer[]> components = new LinkedList<>();
        
        for (int i = 0; i < matrix.length; i++) 
        	if (!GraphTraversalUtil.hasVisited(i)) {
        		Integer[] processed = GraphTraversalUtil.bfsMatrix(i, matrix);

        		if (processed.length >= 2) 
        			components.offer(processed);
        	}

        return components.toArray(new Integer[components.size()][]);
    }

    /**
     * DFS Connected Components
     * @desc find all connected components in an undirected graph using BFS
     * @return array of array of connected vertices
     */
    public static Integer[][] dfsConnectedComponents(int[][] matrix) {
        LinkedList<Integer[]> components = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) 
        	if (!GraphTraversalUtil.hasVisited(i)) {
        		Integer[] processed = GraphTraversalUtil.dfsMatrix(i, matrix);
        		if (processed.length >= 2) 
        			components.offer(processed);
        	}

        return components.toArray(new Integer[components.size()][]);
    }

    /**
     * BFS Minimum Span Tree
     * @desc find the minimum number of edges that connect all vertices in a connected graph
     * @return a list of edges or null
     */
    public static String[] bfsMinimumEdges(int[][] matrix) {
    	Integer[] processed = GraphTraversalUtil.bfsMatrix(0, matrix);

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
     * @desc find the minimum number of edges that connect all vertices in a connected graph
     * @return a list of edges or null
     */
    public static String[] dfsMinimumEdges(int[][] matrix) {
    	Integer[] processed = GraphTraversalUtil.dfsMatrix(0, matrix);

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
     * @desc check each vertex for its connection in a directed graph
     * @return a table of connections for each vertex
     */
    public static Integer[][] bfsConnectivityGrid(int[][] matrix) {
        Integer[][] grid = new Integer[matrix.length][];
        for (int i = 0; i < matrix.length; i++) 
        	grid[i] = GraphTraversalUtil.bfsMatrix(i, matrix);
                
        return grid;
    }

    /**
     * DFS Connectivity Grid
     * @desc check each vertex for its connection in a directed graph
     * @return a table of connections for each vertex
     */
    public static Integer[][] dfsConnectivityGrid(int[][] matrix) {
        Integer[][] grid = new Integer[matrix.length][];
        for (int i = 0; i < matrix.length; i++) 
        	grid[i] = GraphTraversalUtil.dfsMatrix(i, matrix);
                
        return grid;
    }

    /**
     * Transitive Closure (Warshall's algorithm)
     * @desc loop thru each vertex and adjacent in the matrix
     *       examine whether two connected vertices will result in possible connection with other vertices
     *       modify the adjacent matrix when a connection is found
     */
    public static void reviseMatrix(int[][] matrix) {
    	for (int row = 0; row < matrix.length; row++) 
    		for (int col = 0; col < matrix[row].length; col++) 
    			if (matrix[row][col] == CONNECTED) {
    				for (int neighbor = 0; neighbor < matrix[row].length; neighbor++) 
    					if (matrix[neighbor][row] == CONNECTED) 
    						matrix[neighbor][col] = CONNECTED;
    				
    				break;
    			}
    }
    
    public static boolean areConnected(int vertA, int vertB, int[][] matrix) {
    	reviseMatrix(matrix);
    	return matrix[vertA][vertB] >= CONNECTED;
    }
}
