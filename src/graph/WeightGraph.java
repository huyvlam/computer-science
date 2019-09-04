package graph;

import java.util.PriorityQueue;

import adjacent.WeightMatrix;
import adjacent.Vertex;
import adjacent.Vertices;

public class WeightGraph {
	public int size;
	public WeightMatrix adjMatrix;
	public Vertices vertices;
	
	public WeightGraph(int size) {
		this.size = size;
		vertices = new Vertices(size);
		adjMatrix = new WeightMatrix(size);
	}

	public void fillMatrix(int[][] matrix) {
		for (int row = 0; row < size; row++) 
			for (int col = 0; col < size; col++) 
				if (matrix[row][col] >= Vertex.CONNECTED) 
					adjMatrix.addEdge(row, col, matrix[row][col]);
	}
	
    public void fillVertices(String[] vertList) {
    	for (int i = 0; i < vertList.length; i++) 
    		vertices.addVertex(vertList[i], i);
    }
}

