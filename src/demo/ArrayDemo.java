package demo;

import array.*;
import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
	public static void main(String[] args) {
//		matchSequence();
//		valueToIndex();
//		segregateByValue();
//		findRepeated();
		maximumSubarray();
	}
	
	public static void maximumSubarray() {
		int sum = Subarray.maxSum(Arrays.asList(2,-10,11,3,4,-5,1));
		System.out.println("Maximum Subarray " + sum);
	}
	
	public static void findRepeated() {
		int[] repeats = ArrayQuery.findRepeated(new int[] {1,6,5,5,4,3,4}, 5);
		DemoUtil.printIntArray(repeats);
	}

	public static void valueToIndex() {
        int[] A = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1, 12, 5, -1, 11};
        
        System.out.println("\nRearrange element by matching its value to index.");
        System.out.println(">>");
        DemoUtil.printIntArray(A);

        ArrayArrangement.placeValueToIndex(A);

        System.out.println("\n<<");
        DemoUtil.printIntArray(A);
    }

	public static void segregateByValue() {
        int[] A = {9, 2, 2, 2, 9, 9, 2, 9, 2, 9};
        int leftValue = 9, rightValue = 2;
        
        System.out.println("\nSegregate elements by their same value, " + leftValue + "-left " + rightValue + "-right");
        System.out.println(">>");
        DemoUtil.printIntArray(A);

        ArrayArrangement.segregateByValue(A, 2, 9);
        System.out.println("\n<<");
        DemoUtil.printIntArray(A);
    }
	
	public static void matchSequence() {
		String[] A = {"Nine", "Four", "Six", "Seven", "One", "Eight", "Three"};
		String[] B = {"Eight", "Three", "Two", "Four", "Six", "Seven"};
		String[] C = {"Three", "Four", "Six", "Seven", "One"};
		String[] D = {"One", "Eight", "Three", "Two", "Four", "Six", "Five"};
	    
	    List<List<String>>[] sequence = ArraySequence.findMatchingSequence(B, C);
	    for (List seq: sequence) {
	    	for (String item: (String[]) seq.toArray(new String[] {}))
                System.out.print(item + " ");
	    	System.out.println("\n");
	    }
	}
}
