package sort;

/**
 * @desc: Count inversions using enhance merged sort
 *        Time O(n log n)
 *        Space O(n)
 * @author http://www.geeksforgeeks.org/counting-inversions/
 */
public class MergeSort {
    public static long sort(int[] arr){
        return divide(arr, new int[arr.length], 0, arr.length - 1);
    }
    
    private static long divide(int[] src, int[] copy, int left, int right) {
        long count = 0;

        if (left < right) {
            int median = (left + right) / 2;

            count = divide(src, copy, left, median);
            count += divide(src, copy, median + 1, right);
            count += merge(src, copy, left, median + 1, right);
        }

        return count;
    }
    
    private static long merge(int[] src, int[] copy, int left, int median, int right) {
        int leftIndex = left;
        int rightIndex = median;
        int copyIndex = left;
        long count = 0;
        
        while (leftIndex < median && rightIndex <= right)
            if (src[leftIndex] <= src[rightIndex]) {
                copy[copyIndex++] = src[leftIndex++];
            } else {
                copy[copyIndex++] = src[rightIndex++];
                count += median - leftIndex;
            }
        
        while (leftIndex < median)
            copy[copyIndex++] = src[leftIndex++];
        
        while (rightIndex <= right)
            copy[copyIndex++] = src[rightIndex++];
        
        for (int i = left; i <= right; i++)
            src[i] = copy[i];
        
        return count;
    }
}
