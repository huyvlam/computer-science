package array;

import java.util.HashSet;

public class ArrayMutation {
    /**
     * @perform Time O(n) Space O(d) 
     *          this approach optimizes the Space Complexity
     * @desc pivot the array to the right per given step
     */
    public static void rotateLeft(int[] arr, int step) {
        // create a temp array to store elements that will be overridden while shifting
        int[] temp = new int[step];
        int joint = arr.length - step;
        
        // copy and store the leftmost elements to temp
        for (int i = 0; i < step; i++)
            temp[i] = arr[i];
        
        // start with first to last element and shift everything to the left
        for (int j = 0; j < joint; j++)
            arr[j] = arr[(j + step) % arr.length];
        
        // copy over elements in temp
        for (int k = joint; k < arr.length; k++)
            arr[k] = temp[(k + step) % arr.length];
    }

    /**
     * @perform Time O(n) Space O(d) 
     *          this approach optimizes the Space Complexity
     * @desc pivot the array to the right per given step
     */
    public static void rotateRight(int[] arr, int step) {
        //create a temp array to store elements that will be overridden while shifting
        int[] temp = new int[step];
        int joint = step;

        //copy and store the leftmost elements to temp
        for (int i = 0; i < step; i++)
            temp[i] = arr[i];
        
        //start with last to first element and shift everything to the right
        for (int j = arr.length - 1; j >= joint; j--)
            arr[(j + step) % arr.length] = arr[j];

        //copy over elements in temp
        for (int k = 0; k < joint; k++)
            arr[(k + step) % arr.length] = temp[k];
    }    

    /**
     * Rearrange Array Value To Match Its Index
     * @desc 	rearrange array by placing element at the index that matches its value, such that A[i] = i
     *       	empty index has "-1" as value
     */
    public static void arrangeValueToIndex(int[] arr) {
        //loop thru array
        for (int index = 0; index < arr.length; index++) {
            //store value of current element
            int value = arr[index];

            //1. current element has valid value
            //2. value does not match index
            //   both conditions meet -> assign -1 to current index
            if (value != -1 && value != index)
                arr[index] = -1;

            //1. value is valid
            //2. value does not match index
            //   both conditions meet -> continue the loop to check and place value in its correct index position
            while (value != -1 && arr[value] != value) {
                //the checked index has no assigned value -> move value to that index
                if (arr[value] == -1)
                    arr[value] = value;
                //the checked index has a valid value
                else {
                    int temp = arr[value]; //store the value in temp variable
                    arr[value] = value; //assign value to the checked index
                    value = temp; //set value to temp and continue the loop to check
                }
            }
        }
    }
    
    /**
     * Segregate Elements By Value
     * @desc Given an array with values of "0" & "1", segregate these elements such that: 
     * 		 1. group of "0" are placed on the left
     * 		 2. group of "1" are on the right
     */
    public static void segregateValues(int[] A, int leftValue, int rightValue) {
    	int right = A.length - 1;
    	for (int left = 0; left < right; left++) {
    		boolean searching = false;
    		
    		do {
            	// left element has "right value", right has "left value" -> swap their position
    			if (A[left] == rightValue && A[right] == leftValue) {
    				A[left] = leftValue;
    				A[right--] = rightValue;
    				searching = false;

    			// both left & right element have "left value" -> check the next right element
    			} else if (A[left] == rightValue && A[right] == rightValue) {
    				right--;
    				searching = true;
    			}
    		} while (searching && left < right);
    	}
    }
}
