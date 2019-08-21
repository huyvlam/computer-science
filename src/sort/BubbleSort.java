package sort;

public class BubbleSort {
    /**
     * @perform Time - compare O(n2), swap O(n2)
     *          Space O(1)
     * @desc    1. start from left at index 0
     *          2. compare index to its immediate right (index + 1), if index is greater then swap the two
     *          3. increment index by 1 and continue this compare & swap till the end of array
     * @return  the number of inversion occurred in the process
     */
    public static long sort(int[] arr) {
        boolean bubble;
        long count = 0;
        
        do {
            bubble = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    SortUtil.swap(arr, i, i + 1);
                    bubble = true;
                    count++;
                }
            }
        } while (bubble);
        
        return count;
    }
}
