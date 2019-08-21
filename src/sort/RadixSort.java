package sort;
import java.util.LinkedList;

public class RadixSort {
    private static int MAX_LENGTH = 0;
    private static int CURRENT_LENGTH = 1;

    public static long sort(int[] arr) {
        //loop thru the list, convert each element to string and save greatest length to MAX_LENGTH
        for (int num: arr) 
            MAX_LENGTH = Math.max(MAX_LENGTH, String.valueOf(num).toCharArray().length);

        return divide(arr);
    }
    
    private static long divide(int[] arr) {
        // create array of 0-9 index
        // each index store a queue of numbers of that digit
        LinkedList[] queues = new LinkedList[10];
        long count = 0;

        for (int num: arr) {
            char[] conversion = String.valueOf(num).toCharArray();
            int digit = 0;
            
            if (CURRENT_LENGTH <= conversion.length) {
                digit = Character.getNumericValue(conversion[conversion.length - CURRENT_LENGTH]);
                count++;
            }
            
            if (queues[digit] == null) 
                queues[digit] = new LinkedList();

            queues[digit].push(num);
        }
        
        merge(arr, queues);
        
        if (++CURRENT_LENGTH <= MAX_LENGTH) 
            count += divide(arr);
        
        return count;
    }
    
    private static void merge(int[] arr, LinkedList[] queues) {
        int i = 0;
        
        while (i < arr.length) 
            for (int q = 0; q < queues.length; q++) {
                if (queues[q] == null) 
                    continue;
                
                LinkedList list = (LinkedList) queues[q];
                while (!list.isEmpty()) 
                    arr[i++] = (int) list.removeLast();
            }
    }
}
