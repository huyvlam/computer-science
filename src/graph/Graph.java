package graph;

/**
 * Unweight Directed Graph
 * @author huyster
 *
 */
public class Graph {
	public int size;
	public Matrix matrix;
	public Vertices vertices;
	
	public Graph(int size) {
		this.size = size;
		matrix = new Matrix(size);
		vertices = new Vertices(size);
	}

	public void fillMatrix(int[][] adjMatrix) {
		for (int row = 0; row < size; row++) 
			for (int col = 0; col < size; col++) 
				if (adjMatrix[row][col] >= Vertex.CONNECTED) 
					matrix.addEdge(row, col, adjMatrix[row][col]);
	}
	
    public void fillVertices(String[] vertList) {
    	for (int i = 0; i < vertList.length; i++) 
    		vertices.addVertex(vertList[i], i);
    }
    
    public String[] topology() {
    	String[] topoSort = new String[size];

    	while (size > 0) {
    		int current = matrix.findSuccessor();

    		if (current == -1) 
    			return null;
    		
    		topoSort[size - 1] = vertices.getVertex(current);
    		deleteVertex(current);
    	}
    	
    	return topoSort;
    }
    
    /**
     * @desc	1. pivot matrix row one up at the specified index
     * 			2. pivot matrix column one left at the specified index
     * 			3. pivot vertices one left at the specified index
     * @param index
     */
	private void deleteVertex(int index) {
		vertices.deleteVertex(index);
		matrix.deleteVertex(index);
		size--;
	}
}
