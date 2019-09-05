package demo;

import java.util.Random;
import java.util.PriorityQueue;
import java.util.Comparator;

import heap.*;

public class HeapDemo {
	public static void main(String[] args) {
		demoMedianHeap();
	}
	
	public static void demoHeap() {
		Heap heap = new Heap();
	}

	public static void demoMedianHeap() {
        MedianHeap heap = new MedianHeap();
        Random random = new Random();
        
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(30);
            heap.add(num);
            System.out.print("Add: " + num + "\n");
            System.out.println("Median: " + heap.median());
        }
	}
}
