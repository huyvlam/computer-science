package graph;

import java.util.Arrays;

public class Vertices {
	private int size;
    private String[] names;
    
    public Vertices(int size) {
    	this.size = size;
    	names = new String[size];
    }
    
    public String getName(int index) {
    	return names[index];
    }

    public void printName(int index) {
        System.out.print(names[index]);
    }
        
    public int findIndex(String name) {
        for (int index = 0; index < size; index++) 
            if (name.equals(names[index]))
                return index;
        
        return -1;
    }
    
    public void addName(String name, int index) {
        names[index] = name;
    }
    
    /**
     * @desc	1. remove specified vertex by pivoting list and move specified vertex to the end
     * 			2. place the deleted row at the end
     * @param 	vertex index to delete
     * @param 	matrix is where the vertex is removed from
     */
    public void deleteVertex(int index) {
    	String deleted = names[index];
    	for (int vertex = index; vertex < names.length; vertex++) 
    		names[vertex] = names[(vertex + 1) % names.length];

    	names[names.length - 1] = deleted;
    	size--;
    }
}
