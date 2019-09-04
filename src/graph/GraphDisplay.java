package graph;

import java.util.Iterator;
import java.util.LinkedList;

import adjacent.*;

public class GraphDisplay extends Graph {
	public GraphDisplay(int size) {
		super(size);
    }
	
    public void printBFSTraverse(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = adjList.bfsTraverse(index);

		System.out.println("- BFS Adjacent List -");
		if (visited == null) 
			System.out.print(vertName + " has no connection");
		else {
			for (int vertex: visited) {
				vertices.printVertex(vertex);
				System.out.print(" ");
			}			
		}
		System.out.println();
	}
    
    public void printDFSTraverse(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = adjList.dfsTraverse(index);

		System.out.println("- DFS Adjacent List -");
		if (visited == null) 
			System.out.print(vertName + " has no connection");
		else {
			for (int vertex: visited) {
				vertices.printVertex(vertex);
				System.out.print(" ");
			}
		}
		System.out.println();
	}

    public void printList() {
    	System.out.println("- Adjacent List -");
    	for (int row = 0; row < size; row++) {
    		vertices.printVertex(row);
    		System.out.print(" - ");
    		LinkedList neighbors = adjList.list[row];
    		
    		if (neighbors != null) {
    			Iterator iter = neighbors.listIterator();

    			while (iter.hasNext()) {
    				Edge edge = (Edge) iter.next();
    				vertices.printVertex(edge.destination);
    				System.out.print("(" + edge.weight + ") ");
    			}
    			System.out.println();
    		}
    	}
    	System.out.println();
    }
}
