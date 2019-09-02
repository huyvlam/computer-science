package demo;

import graph.*;
import java.util.HashMap;

public class GraphDemo {
	public static void main(String[] args) {
		String[] vertices = {"A", "B", "C", "D"};
//		int[][] matrix = new int[][] {
//			{0, 0, 0, 1, 1, 0, 0, 0},
//			{0, 0, 0, 0, 1, 0, 0, 0},
//			{0, 0, 0, 0, 0, 1, 0, 0},
//			{0, 0, 0, 0, 0, 0, 1, 0},
//			{0, 0, 0, 0, 0, 0, 1, 0},
//			{0, 0, 0, 0, 0, 0, 0, 1},
//			{0, 0, 0, 0, 0, 0, 0, 1},
//			{0, 0, 0, 0, 0, 0, 0, 0}
//		};
		int[][] matrix = new int[][] {
			{0,1,1,0},
			{0,0,1,0},
			{0,0,0,1},
			{0,1,0,0}
		};
		
		System.out.println("Cell" + 0 + 1);
		System.out.println(MatrixUtil.countConnectedCell(0, 1, matrix));
		System.out.println("Cell" + 0 + 3);
		System.out.println(MatrixUtil.countConnectedCell(0, 3, matrix));
		System.out.println("Cell" + 1 + 2);
		System.out.println(MatrixUtil.countConnectedCell(1, 2, matrix));
		System.out.println("Cell" + 3 + 1);
		System.out.println(MatrixUtil.countConnectedCell(3, 1, matrix));
		System.out.println("Island");
		System.out.println(MatrixUtil.countIsland(matrix));
		
//		GraphDisplay graph = new GraphDisplay(vertices.length);
//		graph.fillMatrix(matrix);
//		graph.fillVertices(vertices);
//		graph.printMatrix();
//		graph.printTopology();
//		graph.printMatrix();
//
//		String vertex = "B";

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
