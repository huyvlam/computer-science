package graph;

import java.util.Arrays;

public class Vertices {
	public int size;
    private String[] names;
    private int vertIndex = 0;
    
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
    
    public void addName(String name) {
        names[vertIndex++] = name;
    }
}
