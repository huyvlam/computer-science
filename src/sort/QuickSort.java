package sort;

public class QuickSort {
    private static int[] list;
    public static long count = 0; //count the number of inversion
    
    public static long sort(int[] arr) {
        list = arr; //store the array in list so it can be accessed by other methods
        sort(0, arr.length - 1);
        return count;
    }
    
    private static void sort(int left, int right) {
        int size = right - left + 1;
        
        if (size <= 3) 
            manualSort(left, right);
        else {
            long pivot = getMedian(left, right);
            int partition = partitionArray(left, right, pivot);

            sort(left, partition - 1);
            sort(partition + 1, right);
        }
    }
    
    /**
     * Median of 3
     * @desc select the first, middle, last element and compare
     *       if left element is greater than right element then swap
     * @return the value of element pivoted
     */
    private static long getMedian(int left, int right) {
        int midIndex = (left + right) / 2;

        //left element greater than mid element ->  swap
        if (list[left] > list[midIndex]) {
            swap(left, midIndex);
            count++;
        }

        //left element greater than right element -> swap
        if (list[left] > list[right]) {
            swap(left, right);
            count++;
        }
        
        //mid element greater than right element -> swap
        if (list[midIndex] > list[right]) {
            swap(midIndex, right);
            count++;
        }
        
        swap(midIndex, right - 1); //place pivot element on the right
        
        return list[right - 1];
    }

    /**
     * @desc partition array into 2 subarrays
     * @return 
     */
    private static int partitionArray(int left, int right, long pivot) {
        int leftPointer = left;
        int rightPointer = right - 1; //since the right most element is the pivoted and sorted, we want to use the element next to it
        
        while (true) {
            //element in left partition is less than pivot element
            //increment the left pointer
            while (leftPointer < right && list[++leftPointer] < pivot)
                ;

            //element in right partition is less than pivot element
            //decrement the right pointer
            while (rightPointer > left && list[--rightPointer] > pivot)
                ;
            
            //left pointer is greater than right -> stop
            if (leftPointer >= rightPointer)
                break;
            //swap element in left and right partition
            else {
                swap(leftPointer, rightPointer);
                count++;
            }
        }
        swap(leftPointer, right - 1);
        
        return leftPointer;
    }
    
    private static void swap(int left, int right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }
    
    /**
     * @desc array has 3 or less elements then use this method to sort
     */
    private static void manualSort(int left, int right) {
        int size = right - left + 1;
        
        //array has one element -> no sort needed
        if (size <= 1)
            return;
        
        //array has 2 elements -> swap the 2 if needed
        if (size == 2) {
            if (list[left] > list[right]) {
                swap(left, right);
                count++;
            }

            return;
        }
        
        //array has 3 elements -> swap among 3 if needed
        if (list[left] > list[right - 1]) {
            swap(left, right - 1);
            count++;
        }
        
        if (list[left] > list[right]) {
            swap(left, right);
            count++;
        }
        
        if (list[right - 1] > list[right]) {
            swap(right - 1, right);
            count++;
        }
    }
    
    /**
     * @desc simplified version works well for small array but yield O(n2) for large array
     */
//    private static int partition(int[] arr, int left, int right) {
//        int pivot = arr[right];
//        int marker = left;
//        int count = 0;
//        
//        while (left <= right) {
//            if (arr[left] <= pivot) {
//                int temp = arr[left];
//
//                arr[left] = arr[marker];
//                arr[marker] = temp;
//                marker++;
//                count++;
//            }
//            
//            left++;
//        }
//        
//        if (marker - 2 > 1) 
//            partition(arr, 0, marker - 2);
//
//        if (right - marker > 1) 
//            partition(arr, marker, right);
//        
//        return count;
//    }
}
