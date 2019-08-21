package array;

import java.util.HashSet;

public class ArrayArrangement {
    /**
     * Rearrange Array Value To Match Its Index
     * @perform Time O(n)
     * @see https://www.geeksforgeeks.org/rearrange-array-arri/
     * @desc rearrange the array by matching value to index such that A[i] = i
     *       if the index has no assigned value, set it to -1
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
     * Arrange Value To Its Index (using HashSet)
     * @note this approach store all values in hash set then place the value in hash set to its correct index
     * @perform Time O(n) Space O(n)
     * @see https://www.geeksforgeeks.org/rearrange-array-arri/
     * @desc rearrange the array to match value to index such that A[i] = i
     *       if A[i] is not assigned value, leave it
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
     * @see https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
     * @desc segregate 0 & 1 in the array -> place all 0 on the left, 1 on the right 
     */
    public static void segregateValues(int[] A) {
        int right = A.length - 1;
        
        for (int left = 0; left < right; left++) {
            boolean loop = false;
            
            do {
                if (A[left] == 1 && A[right] == 0) {
                    A[right--] = 1;
                    A[left] = 0;
                    loop = false;
                } else if (A[left] == 1 && A[right] == 1) {
                    right--;
                    loop = true;
                }
            } while (loop && left < right);
        }
    }    
}
