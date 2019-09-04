package weightgraph;

import graph.Graph;
import graph.Matrix;
import graph.Vertex;
import graph.Vertices;

import java.util.PriorityQueue;

import graph.Edge;

public class WeightGraph {
	public int size;
	public WeightMatrix matrix;
	public Vertices vertices;

	public WeightGraph(int size) {
		this.size = size;
		matrix = new WeightMatrix(size);
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
}

