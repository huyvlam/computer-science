package demo;

import graph.*;
import java.util.HashMap;

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
		
		GraphDisplay graph = new GraphDisplay(vertices.length);
		graph.fillMatrix(matrix);
		graph.fillVertices(vertices);
		graph.printMatrix();
		graph.printTopology();

		String vertex = "B";

//		graph.printBFSTraverse(vertex);
//		System.out.println();
//		graph.printDFSTraverse(vertex);
//		System.out.println();
		
//		graph.printBFSConnectedComponents();
//		System.out.println();
//		graph.printDFSConnectedComponents();
//		System.out.println();
//
//		graph.printBFSMinimumEdges();
//		System.out.println();
//		graph.printDFSMinimumEdges();
//		System.out.println();
//		
//		graph.printDFSConnectivity();
//		System.out.println();
//		graph.printBFSConnectivity();
//		System.out.println();
	}
}
