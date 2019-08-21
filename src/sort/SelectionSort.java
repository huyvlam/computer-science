package sort;

public class SelectionSort {
    /**
     * @perform Time - compare O(n2), swap O(n)
     * @desc    1. start from left at index 0 (swapIndex)
     *          2. loop thru array and find the smallest
     *          3. replace the smallest with the swapIndex
     *          4. increment swapIndex by and repeat the process till sorting is complete
     * @return the number of inversion occurred in sorting process
     */
    public static long sort(int[] arr) {
        long count = 0;
        
        for (int out = 0; out < arr.length - 1; out++) {
            int min = out;
            
            for (int in = out + 1; in < arr.length; in++)
                if (arr[in] < arr[min]) {
                    min = in;
                    count++;
                }
            
            SortUtil.swap(arr, out, min);
        }
        
        return count;
    }
}
