package demo;

import weightgraph.*;

public class WeightGraphDemo {
	public static void main(String[] args) {
		String[] vertices = {"A","B","C","D"};
		int[][] matrix = {
				{0,0,0,0},
				{70,0,0,10},
				{30,0,0,0},
				{0,0,20,0}
		};
		
		WeightGraphDisplay graph = new WeightGraphDisplay(vertices.length);
		graph.fillMatrix(matrix);
		graph.fillVertices(vertices);
		graph.printMatrix();

		graph.printMinimumEdges();
		System.out.println();

		graph.printLightestPath("A");
		System.out.println();
		
		graph.matrix.allPairsLightestPath();
		graph.printMatrix();
	}
}
