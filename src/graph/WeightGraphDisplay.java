package graph;

import graph.*;

import java.util.Arrays;

import adjacent.Edge;
import adjacent.Path;

public class WeightGraphDisplay extends WeightGraph {
	public WeightGraphDisplay(int size) {
		super(size);
	}
	
	public void printLightestPath(String vertName) {
		int index = vertices.findIndex(vertName);
		Path[] paths = adjMatrix.lightestPath(index);
		
		System.out.println("- Lightest Path [single source] -");
		for (int i = 0; i < paths.length; i++) {
			vertices.printVertex(i);
			System.out.print("=" + paths[i].weight + "(");
			vertices.printVertex(paths[i].layover);
			System.out.print(") ");
		}

		System.out.println();
	}
	
	public void printMinimumEdges() {
        Edge[] edges = adjMatrix.minimumEdges();
        
        if (edges == null) 
            System.out.println("- No minimum span tree -");
        else {
            System.out.println("- Minimum Edges [weighed MST] -");
            for (Edge edge: edges) {
            	vertices.printVertex(edge.source);
            	System.out.print("-");
            	vertices.printVertex(edge.destination);
                System.out.print("(" + edge.weight + ")");
            }
        }
        System.out.println();
	}

    public void printMatrix() {
    	System.out.println("- Matrix -");
    	for (int row = 0; row < size; row++) {
    		vertices.printVertex(row);
    		System.out.print(" - ");

    		for (int col = 0; col < size; col++) {
    			System.out.print(adjMatrix.matrix[row][col]);

    			if (col < size - 1) 
    				System.out.print(", ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
