package demo;

import graph.*;
import java.util.HashMap;

public class GraphDemo {
	public static void main(String[] args) {
		String[] vertices = {"An", "Bao", "Cam", "Duong", "Em"};
		int[][] matrix = new int[][] {
			{0, 1, 0, 1, 0},
			{1, 0, 1, 0, 0},
			{0, 1, 0, 0, 0},
			{1, 0, 0, 0, 1},
			{0, 0, 0, 1, 0}
		};
		int[][] adjList = new int[][] {
			{1, 3},
			{0, 2},
			{1},
			{0,4},
			{3}
		};
		
		Graph graph = new Graph(matrix);
		graph.addVertices(vertices);
		String vertex = "Duong";

//		graph.printBFSMatrix(vertex);
//		System.out.println();
//		graph.printBFSList(vertex, adjList);
//		System.out.println();
//
//		graph.printDFSMatrix(vertex);
//		System.out.println();
//		graph.printDFSList(vertex, adjList);
//		System.out.println();
//		
//		graph.printBFSConnectedComponents();
//		System.out.println();
//		graph.printDFSConnectedComponents();
//		System.out.println();
//
//		graph.printBFSMinimumEdges();
//		System.out.println();
//		graph.printDFSMinimumEdges();
//		System.out.println();
		
		graph.printDFSConnectivity();
		System.out.println();
		graph.printBFSConnectivity();
		System.out.println();
	}
}
