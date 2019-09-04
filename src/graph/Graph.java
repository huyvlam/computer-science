package graph;

import adjacent.AdjList;
import adjacent.Vertex;
import adjacent.Vertices;

public class Graph {
	public int size;
	public AdjList adjList;
	public Vertices vertices;
	
	public Graph(int size) {
		this.size = size;
		vertices = new Vertices(size);
		adjList = new AdjList(size);
	}

	/**
	 * @desc	this method takes 
	 * @param	matrix (instead of list) so that we can add weight at any given index
	 */
	public void fillList(int[][] matrix) {
		for (int row = 0; row < size; row++) 
			for (int col = 0; col < size; col++) 
				if (matrix[row][col] >= Vertex.CONNECTED) 
					adjList.addEdge(row, col, matrix[row][col]);
	}

	public void fillVertices(String[] vertList) {
    	for (int i = 0; i < vertList.length; i++) 
    		vertices.addVertex(vertList[i], i);
    }
    
//    public String[] topology() {
//    	String[] topoSort = new String[size];
//
//    	while (size > 0) {
//    		int current = adjMatrix.findSuccessor();
//
//    		if (current == -1) 
//    			return null;
//    		
//    		topoSort[size - 1] = vertices.getVertex(current);
//    		deleteVertex(current);
//    	}
//    	
//    	return topoSort;
//    }
//    
//    /**
//     * @desc	1. pivot matrix row one up at the specified index
//     * 			2. pivot matrix column one left at the specified index
//     * 			3. pivot vertices one left at the specified index
//     * @param index
//     */
//	private void deleteVertex(int index) {
//		vertices.deleteVertex(index);
//		adjMatrix.deleteVertex(index);
//		size--;
//	}
}
