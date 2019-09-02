package graph;

import java.util.Arrays;

public class Vertices {
	private int size;
    private String[] root;
    
    public Vertices(int size) {
    	this.size = size;
    	root = new String[size];
    }
    
    public void addVertex(String name, int index) {
        root[index] = name;
    }
    
    public String getVertex(int index) {
    	return root[index];
    }

    public void printVertex(int index) {
        System.out.print(root[index]);
    }
        
    public int findIndex(String name) {
        for (int index = 0; index < size; index++) 
            if (name.equals(root[index]))
                return index;
        
        return -1;
    }
    
    private boolean lastIndex(int index) {
    	return index == size - 1;
    }
    
    /**
     * @desc	1. remove specified vertex by pivoting list and move specified vertex to the end
     * 			2. place the deleted row at the end
     * 			3. decrement the size to mark out of bound element as deleted
     * @param 	vertex index to delete
     * @param 	matrix is where the vertex is removed from
     */
    public void deleteVertex(int index) {
    	// if deleted is the last element -> no need to pivot, just decrement the size
    	if (!lastIndex(index)) {
        	String deleted = root[index];
        	for (int vertex = index; vertex < root.length; vertex++) 
        		root[vertex] = root[(vertex + 1) % root.length];

        	root[root.length - 1] = deleted;    		
    	}
    	size--;
    }
}
