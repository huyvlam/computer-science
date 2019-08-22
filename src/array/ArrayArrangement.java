package array;

import java.util.HashSet;

public class ArrayArrangement {
    /**
     * Rearrange Array Value To Match Its Index
     * @desc 	rearrange array by placing element at the index that matches its value, such that A[i] = i
     *       	empty index has "-1" as value
     */
    public static void placeValueToIndex(int[] A) {
        //loop thru array
        for (int index = 0; index < A.length; index++) {
            //store value of current element
            int value = A[index];

            //1. current element has valid value
            //2. value does not match index
            //   both conditions meet -> assign -1 to current index
            if (value != -1 && value != index)
                A[index] = -1;

            //1. value is valid
            //2. value does not match index
            //   both conditions meet -> continue the loop to check and place value in its correct index position
            while (value != -1 && A[value] != value) {
                //the checked index has no assigned value -> move value to that index
                if (A[value] == -1)
                    A[value] = value;
                //the checked index has a valid value
                else {
                    int temp = A[value]; //store the value in temp variable
                    A[value] = value; //assign value to the checked index
                    value = temp; //set value to temp and continue the loop to check
                }
            }
        }
    }
    
    /**
     * Rearrange Array Value To Match Its Index
     * @desc	rearrange array by placing element at the index that matches its value, such that A[i] = i
     *       	empty index has "-1" as value
     * @note	this alternative approach store all values in hash set then place the value in hash set to its correct index
     */
    public static void placeValueToIndexAlt(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++)
            if (A[i] != -1)
                set.add(A[i]);
        
        for (int j = 0; j < A.length; j++)
            A[j] = (set.contains(j)) ? j : -1;
    }
    
    /**
     * Segregate Elements By Value
     * @desc Given an array with values of "0" & "1", segregate these elements such that: 
     * 		 1. group of "0" are placed on the left
     * 		 2. group of "1" are on the right
     */
    public static void segregateByValue(int[] A, int leftVal, int rightVal) {
    	int right = A.length - 1;
    	for (int left = 0; left < right; left++) {
    		boolean searching = false;
    		
    		do {
            	// left element has "right value", right has "left value" -> swap their position
    			if (A[left] == rightVal && A[right] == leftVal) {
    				A[left] = leftVal;
    				A[right--] = rightVal;
    				searching = false;

    			// both left & right element have "left value" -> check the next right element
    			} else if (A[left] == rightVal && A[right] == rightVal) {
    				right--;
    				searching = true;
    			}
    		} while (searching && left < right);
    	}
    }
}
