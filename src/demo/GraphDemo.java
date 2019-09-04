package demo;

import graph.*;

public class GraphDemo {
	public static void main(String[] args) {
		String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H"};
		int[][] matrix = new int[][] {
			{0, 0, 0, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		demoListGraph(vertices, matrix);
		demoMatrixGraph(vertices, matrix);
		demoWeightGraph();
	}
	
	public static void demoWeightGraph() {
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
		
		graph.adjMatrix.allPairsLightestPath();
		graph.printMatrix();		
	}
	
	public static void demoListGraph(String[] vertices, int[][] matrix) {
		GraphDisplay listGraph = new GraphDisplay(vertices.length);
		listGraph.fillVertices(vertices);
		listGraph.fillList(matrix);
		listGraph.printList();
		System.out.println();

		String vertex = "E";

		listGraph.printBFSTraverse(vertex);
		System.out.println();
		listGraph.printDFSTraverse(vertex);
		System.out.println();
	}

	public static void demoMatrixGraph(String[] vertices, int[][] matrix) {				
		MatrixGraphDisplay matrixGraph = new MatrixGraphDisplay(vertices.length);
		matrixGraph.fillVertices(vertices);
		matrixGraph.fillMatrix(matrix);
		matrixGraph.printMatrix();

		String vertex = "E";

		matrixGraph.printBFSTraverse(vertex);
		System.out.println();
		matrixGraph.printDFSTraverse(vertex);
		System.out.println();
		
		matrixGraph.printBFSConnectedComponents();
		System.out.println();
		matrixGraph.printDFSConnectedComponents();
		System.out.println();

		matrixGraph.printBFSMinimumEdges();
		System.out.println();
		matrixGraph.printDFSMinimumEdges();
		System.out.println();
		
		matrixGraph.printBFSConnectivity();
		System.out.println();
		matrixGraph.printDFSConnectivity();
		System.out.println();

		matrixGraph.printTopology();
		System.out.println();
	}
}
