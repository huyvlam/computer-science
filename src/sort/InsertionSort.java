package sort;

public class InsertionSort {
    /**
     * @perform Time - compare O(n), swap O(n2)
     */
    public static long sort(int[] arr) {
        long count = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int index = i;
            
            while (index > 0 && value <= arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
                count++;
            }
            
            arr[index] = value;
        }
        
        return count;
    }

}
