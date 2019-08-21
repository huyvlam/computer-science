package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {
    public static void sort(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr.length, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
        
        for (Integer el: arr)
            heap.add(el);
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }
}
