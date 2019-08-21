package array;

public class ArrayRotation {
    /**
     * @perform Time O(n) Space O(d) 
     *          this approach optimizes the Space Complexity
     * @desc pivot the array to the right per given step
     */
    public static void pivotLeft(int[] arr, int step) {
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
     * @perform Time O(n) Space O(n)
     * @desc pivot the array to the left per given step
     */
    public static int[] pivotLeftAlt(int[] arr, int step) {
        int[] rotations = new int[arr.length];

        for (int i = 0; i < arr.length; i++) 
            rotations[i] = arr[(i + step) % arr.length];

        return rotations;
    }

    /**
     * @perform Time O(n) Space O(d) 
     *          this approach optimizes the Space Complexity
     * @desc pivot the array to the right per given step
     */
    public static void pivotRight(int[] arr, int step) {
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
     * @perform Time O(n) Space O(n)
     * @desc pivot the array to the right per given step
     */
    public static int[] pivotRightAlt(int[] arr, int step) {
        int[] rotations = new int[arr.length];

        for (int i = 0; i < arr.length; i++) 
            rotations[(step + i) % arr.length] = arr[i];

        return rotations;
    }
}
