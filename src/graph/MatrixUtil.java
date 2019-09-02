package graph;

import java.util.HashMap;

public class MatrixUtil {
	private static HashMap<String, Integer> visitedList;

	/**
	 * @desc	Count the biggest component, or the largest region in a given matrix
	 * @return	the size of the biggest component/largest region
	 */
    public static int maxComponentSize(int[][] matrix) {
    	initVisitedList();
        int count = 0;
        
        // Starting with the top left most cell, go thru each cell...
        // 1. check for the largest combined region of each cell
        // 2. store and return the largest found
        for (int row = 0; row < matrix.length; row++) 
            for (int col = 0; col < matrix[row].length; col++) 
                count = Math.max(count, countConnectedCell(row, col, matrix, visitedList));
        
        return count;
    }
    
	/**
	 * @desc	Count the number of island in a given matrix (any cell that is marked as 1)
	 * @return	total count
	 */
    public static int countIsland(int[][] matrix) {
    	initVisitedList();
    	int count = 0;

    	for (int row = 0; row < matrix.length; row++) 
    		for (int col = 0; col < matrix[row].length; col++) 
    			count += (countConnectedCell(row, col, matrix, visitedList) == 0) ? 0 : 1;
    	
    	return count;
    }
    
    public static int countConnectedCell(int row, int col, int[][] matrix) {
    	initVisitedList();
    	return countConnectedCell(row, col, matrix, visitedList);
    }

    /**
	 * @desc	Count the number of cell connected to a specified row, col 
	 * @return	total count
	 */
    private static int countConnectedCell(int row, int col, int[][] matrix, HashMap<String, Integer> visitedList) {
    	String hashed = "r" + row + "c" + col;

    	// check for the followings:
    	// 1. index is in bound
    	// 2. the cell is connected
    	// 3. the cell has not been visited
    	if (row < 0 || col < 0 
    			|| row >= matrix.length 
    			|| col >= matrix[row].length 
    			|| matrix[row][col] == 0 
    			|| visitedList.containsKey(hashed)) 
    		return 0;
    	
    	visitedList.put(hashed, 1);
    	int count = matrix[row][col];
    	count += countConnectedCell(row, col - 1, matrix, visitedList);
    	count += countConnectedCell(row, col + 1, matrix, visitedList);
    	count += countConnectedCell(row - 1, col - 1, matrix, visitedList);
    	count += countConnectedCell(row - 1, col, matrix, visitedList);
    	count += countConnectedCell(row - 1, col + 1, matrix, visitedList);
    	count += countConnectedCell(row + 1, col - 1, matrix, visitedList);
    	count += countConnectedCell(row + 1, col, matrix, visitedList);
    	count += countConnectedCell(row + 1, col + 1, matrix, visitedList);
    	
    	return count;
    }
    
    private static void initVisitedList() {
    	visitedList = new HashMap<>();
    }
}
