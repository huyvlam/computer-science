package graph;

public class GraphDisplay extends Graph {
	public GraphDisplay(int size) {
		super(size);
    }
	
    public void printBFSTraverse(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = matrix.bfsTraverse(index);
		System.out.println("- BFS Matrix -");

		for (int vertex: visited) {
			vertices.printName(vertex);
			System.out.print(" ");
		}
		
		System.out.println();
	}
    
    public void printDFSTraverse(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = matrix.dfsTraverse(index);
		System.out.println("- DFS Matrix -");

		for (int vertex: visited) {
			vertices.printName(vertex);
			System.out.print(" ");
		}
		
		System.out.println();
	}
    
    public void printTopology() {
    	String[] adjacents = topology();
    	for (String vertName: adjacents) 
    		System.out.println(vertName + "-");
    }

    public void printBFSConnectedComponents() {
        Integer[][] components = matrix.bfsConnectedComponents();
        
        if (components.length == 0)
            System.out.println("- No connected component -");
        else {
            System.out.println("- BFS Connected Components [undirected graph] -");
            
            for (int i = 0; i < components.length; i++) {
                for (int vertex: components[i]) {
                    vertices.printName(vertex);
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
                	vertices.printName(vertex);
                    System.out.print(" ");
                }

                if (i < components.length - 1) 
                	System.out.println();            	
            }        
            System.out.println();
        }
    }

    public void printBFSMinimumEdges() {
        String[] edges = matrix.bfsMinimumEdges();
        
        if (edges == null) 
            System.out.println("- No minimum span tree -");
        else {
            System.out.println("- BFS Minimum Span Tree [minimum edges] -");
            for (String edge: edges) {
            	String[] adjacents = edge.split("-");
            	vertices.printName(Integer.parseInt(adjacents[0]));
            	System.out.print("-");
            	vertices.printName(Integer.parseInt(adjacents[1]));
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public void printDFSMinimumEdges() {
        String[] edges = matrix.dfsMinimumEdges();
        
        if (edges == null) 
            System.out.println("- No minimum span tree -");
        else {
            System.out.println("- DFS Minimum Span Tree [minimum edges] -");
            for (String edge: edges) {
            	String[] adjacents = edge.split("-");
            	vertices.printName(Integer.parseInt(adjacents[0]));
            	System.out.print("-");
            	vertices.printName(Integer.parseInt(adjacents[1]));
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public void printMatrix() {
    	System.out.println("- Matrix -");
    	for (int row = 0; row < size; row++) {
    		vertices.printName(row);
    		System.out.print(" - ");

    		for (int col = 0; col < size; col++) {
    			if (col == row || !matrix.isEdge(row, col)) 
    				System.out.print("x");
    			else 
    				vertices.printName(col);

    			if (col < size - 1) 
    				System.out.print(", ");
    		}
    		System.out.println();
    	}
    			
    }
    
    public void printBFSConnectivity() {
    	Integer[][] grid = matrix.bfsConnectivityGrid();

        System.out.println("- Connectivity Grid -");
        for (Integer[] connectivity: grid) {
        	for (int vertex: connectivity) {
        		vertices.printName(vertex);
        		System.out.print("-");
        	}
            System.out.println();
        }
    }
    
    public void printDFSConnectivity() {
    	Integer[][] grid = matrix.dfsConnectivityGrid();

        System.out.println("- Connectivity Grid -");
        for (Integer[] connectivity: grid) {
        	for (int vertex: connectivity) {
        		vertices.printName(vertex);
        		System.out.print("-");
        	}
            System.out.println();
        }
    }
}
