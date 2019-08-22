package demo;

import array.*;
import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
	public static void main(String[] args) {
		matchSequence();
//		valueToIndex();
//		segregate();
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

	public static void segregate() {
        int[] A = {0, 1, 1, 0, 1, 0, 0, 1, 0};
        
        System.out.println("\nSegregate element of value 0 to left, 1 to right.");
        System.out.println(">>");
        DemoUtil.printIntArray(A);

        ArrayArrangement.segregateValues(A);
        System.out.println("\n<<");
        DemoUtil.printIntArray(A);
    }
	
	public static void matchSequence() {
		String[] A = {"Nine", "Four", "Six", "Seven", "One", "Eight", "Three"};
		String[] B = {"Eight", "Three", "Two", "Four", "Six", "Seven"};
		String[] C = {"Three", "Four", "Six", "Seven", "One"};
		String[] D = {"One", "Eight", "Three", "Two", "Four", "Six", "Five"};
	    
	    List[] sequence = ArraySequence.findMatchingSequence(B, C);
	    for (List seq: sequence) {
	    	for (String item: (String[]) seq.toArray(new String[] {}))
                System.out.print(item + " ");
	    	System.out.println("\n");
	    }
	}
}
