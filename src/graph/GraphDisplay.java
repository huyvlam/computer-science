package graph;

public class GraphDisplay extends Graph {
	public GraphDisplay(int size) {
		super(size);
    }
	
    public void printBFSTraverse(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = matrix.bfsTraverse(index);

		System.out.println("- BFS Traverse -");
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
		Integer[] visited = matrix.dfsTraverse(index);

		System.out.println("- DFS Traverse -");
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
    
    public void printTopology() {
    	String[] adjacents = topology();
    	
    	System.out.println("- Topological sort -");
    	for (int i = 0; i < adjacents.length; i++) {
    		System.out.print(adjacents[i]);
    		if (i < adjacents.length - 1) 
    			System.out.print("-");
    	}
    	System.out.println();
    }

    public void printBFSConnectedComponents() {
        Integer[][] components = matrix.bfsConnectedComponents();
        
        if (components.length == 0)
            System.out.println("- No connected component -");
        else {
            System.out.println("- BFS Connected Components [undirected graph] -");
            
            for (int i = 0; i < components.length; i++) {
                for (int vertex: components[i]) {
                    vertices.printVertex(vertex);
                    System.out.print(" ");
                }

                if (i < components.length - 1) 
                	System.out.println();            	
            }        
            System.out.println();
        }
    }

    public void printDFSConnectedComponents() {
        Integer[][] components = matrix.dfsConnectedComponents();
        
        if (components.length == 0)
            System.out.println("- No connected component -");
        else {
            System.out.println("- DFS Connected Components [undirected graph] -");
            
            for (int i = 0; i < components.length; i++) {
                for (int vertex: components[i]) {
                	vertices.printVertex(vertex);
                    System.out.print(" ");
                }

                if (i < components.length - 1) 
                	System.out.println();            	
            }        
            System.out.println();
        }
    }

    public void printBFSMinimumEdges() {
        Edge[] edges = matrix.bfsMinimumEdges();
        
        if (edges == null) 
            System.out.println("- No minimum span tree -");
        else {
            System.out.println("- BFS Minimum Edges [unweighed MST] -");
            for (Edge edge: edges) {
            	vertices.printVertex(edge.source);
            	System.out.print("-");
            	vertices.printVertex(edge.destination);
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public void printDFSMinimumEdges() {
        Edge[] edges = matrix.dfsMinimumEdges();
        
        if (edges == null) 
            System.out.println("- No minimum span tree -");
        else {
            System.out.println("- DFS Minimum Edges [unweighed MST] -");
            for (Edge edge: edges) {
            	vertices.printVertex(edge.source);
            	System.out.print("-");
            	vertices.printVertex(edge.destination);
                System.out.print(" ");
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
    			System.out.print(matrix.root[row][col]);

    			if (col < size - 1) 
    				System.out.print(", ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    public void printBFSConnectivity() {
    	Integer[][] table = matrix.bfsConnectivityTable();

        System.out.println("- BFS Connectivity Grid -");
        for (int row = 0; row < table.length; row++) {
        	if (table[row] != null) {
            	for (int col = 0; col < table[row].length; col++) {
            		vertices.printVertex(table[row][col]);
            		
            		if (col < table[row].length - 1) 
            			System.out.print("-");
            	}
            	System.out.println();
        	}
        }
    }
    
    public void printDFSConnectivity() {
    	Integer[][] table = matrix.dfsConnectivityTable();

        System.out.println("- DFS Connectivity Grid -");
        for (int row = 0; row < table.length; row++) {
        	if (table[row] != null) {
            	for (int col = 0; col < table[row].length; col++) {
            		vertices.printVertex(table[row][col]);
            		
            		if (col < table[row].length - 1) 
            			System.out.print("-");
            	}
            	System.out.println();
        	}
        }
    }
}
