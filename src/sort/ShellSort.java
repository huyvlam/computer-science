package sort;

public class ShellSort {
    /**
     * @perform h = 3 * h + 1 (reversed formula: h = (h - 1) / 3)
     * @return the number of inversion occurred in sorting process
     */
    public static long sort(int[] arr) {
        long count = 0;
        int gap = 1;        

        // loop thru to determine the largest initial gap sequence
        while (gap <= arr.length / 3) 
            gap = gap * 3 + 1;

        while (gap > 0) {
            for (int marker = gap; marker < arr.length; marker++) {
                int currentIndex = marker;
                int currentValue = arr[marker];
                
                while (currentIndex > gap - 1 && currentValue <= arr[currentIndex - gap]) {
                    arr[currentIndex] = arr[currentIndex - gap];
                    currentIndex -= gap;
                    count++;
                }
                
                arr[currentIndex] = currentValue;
            }
            
            gap = (gap - 1) / 3;
        }
        
        return count;
    }
}
