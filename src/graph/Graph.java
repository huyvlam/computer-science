package graph;

public class Graph {
	private int[][] matrix;
	private Vertices vertices;

	public Graph(int[][] matrix) {
		this.matrix = matrix;
		vertices = new Vertices(matrix.length);
    }
	
    public void addVertices(String[] vertList) {
    	for (String vertex: vertList) 
    		vertices.addName(vertex);
    }
    
    public void printBFSList(String vertName, int[][] adjList) {
    	int index = vertices.findIndex(vertName);
    	Integer[] visited = GraphTraversalUtil.bfsList(index, adjList);
		System.out.println("- BFS Adjacent List -");

		for (int vertex: visited) {
			vertices.printName(vertex);
			System.out.print(" ");
		}
		
		System.out.println();
    }
    
    public void printDFSList(String vertName, int[][] adjList) {
    	int index = vertices.findIndex(vertName);
    	Integer[] visited = GraphTraversalUtil.dfsList(index, adjList);
		System.out.println("- DFS Adjacent List -");

		for (int vertex: visited) {
			vertices.printName(vertex);
			System.out.print(" ");
		}
		
		System.out.println();
    }
    
    public void printBFSMatrix(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = GraphTraversalUtil.bfsMatrix(index, matrix);
		System.out.println("- BFS Matrix -");

		for (int vertex: visited) {
			vertices.printName(vertex);
			System.out.print(" ");
		}
		
		System.out.println();
	}
    
    public void printDFSMatrix(String vertName) {
    	int index = vertices.findIndex(vertName);
		Integer[] visited = GraphTraversalUtil.dfsMatrix(index, matrix);
		System.out.println("- DFS Matrix -");

		for (int vertex: visited) {
			vertices.printName(vertex);
			System.out.print(" ");
		}
		
		System.out.println();
	}

    public void printBFSConnectedComponents() {
        Integer[][] components = MatrixUtil.bfsConnectedComponents(matrix);
        
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
        Integer[][] components = MatrixUtil.dfsConnectedComponents(matrix);
        
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
        String[] edges = MatrixUtil.bfsMinimumEdges(matrix);
        
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
        String[] edges = MatrixUtil.dfsMinimumEdges(matrix);
        
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
    	for (int row = 0; row < matrix.length; row++) {
    		vertices.printName(row);
    		System.out.print(" - ");

    		for (int col = 0; col < matrix[row].length; col++) {
    			if (col == row || matrix[row][col] == 0) 
    				System.out.print("x");
    			else 
    				vertices.printName(col);

    			if (col < matrix[row].length - 1) 
    				System.out.print(", ");
    		}
    		System.out.println();
    	}
    			
    }
    
    public void printBFSConnectivity() {
    	Integer[][] grid = MatrixUtil.bfsConnectivityGrid(matrix);

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
    	Integer[][] grid = MatrixUtil.dfsConnectivityGrid(matrix);

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
