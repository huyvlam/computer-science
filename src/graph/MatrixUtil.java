package graph;

public class MatrixUtil {
	/**
	 * @desc	Given a cell in a matrix, where values are either 0 or 1. 
	 * 			Find the largest region, or the largest combined area where cell with value of 1 are connected
	 * @return	the largest region
	 */
    static int getLargestRegion(int[][] matrix) {
        int count = 0;
        
        // Starting with the top left most cell, go thru each cell...
        // 1. check for the largest combined region of each cell
        // 2. store and return the largest found
        for (int row = 0; row < matrix.length; row++) 
            for (int col = 0; col < matrix[row].length; col++) 
                count = Math.max(count, countCell(matrix, row, col));
        
        return count;
    }

    // Start w/ specified cell, check each 8 neighboring cell for adjacent
    // For each adjacent cell, check recurringly until no adjacent is found
    static int countCell(int[][] matrix, int row, int col) {
    	// if index out of bound or no connection
    	if (row < 0 || 
            col < 0 || 
            row >= matrix.length || 
            col >= matrix[row].length || 
            matrix[row][col] == 0) return 0;
                
    	// count adjacent cell then decrement by 1 to mark the cell as visited
    	int count = matrix[row][col]--;
        
    	
        count += countCell(matrix, row - 1, col - 1); // check above row, left col
        count += countCell(matrix, row - 1, col); // check above row, same col
        count += countCell(matrix, row - 1, col + 1); // check above row, right col
        count += countCell(matrix, row, col - 1); // check same row, left col
        count += countCell(matrix, row, col + 1); // check same row, right col
        count += countCell(matrix, row + 1, col - 1); // check below row, left col
        count += countCell(matrix, row + 1, col); // check below row, same col
        count += countCell(matrix, row + 1, col + 1); // check below row, right col
        
        return count;
    }
}
