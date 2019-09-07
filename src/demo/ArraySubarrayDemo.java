package demo;

import java.util.List;

import array.Subarray;

public class ArraySubarrayDemo {
	public static void main(String[] args) {
		demoMaximumSubarray();
		demoMatchingSubarrays();
	}

	public static void demoMaximumSubarray() {
		int[] list = {2,-10,11,3,4,-5,1};
		int sum = Subarray.maxSum(list);
		Integer[] sub = Subarray.findMaxSubarray(list);

		System.out.println("-Maximum Subarray-");
		System.out.print("  ");
		DisplayUtil.printIntArray(list);
		System.out.println("");

		System.out.println("Sum:\n  " + sum);
		System.out.print("Subarray:\n  ");
		DisplayUtil.printArray(sub);
		System.out.println("\n");
	}

	public static void demoMatchingSubarrays() {
		String[] A = {"Nine", "Four", "Six", "Seven", "One", "Eight", "Three"};
		String[] B = {"One", "Eight", "Three", "Two", "Four", "Six", "Seven"};
		String[] C = {"Three", "Four", "Six", "Seven", "One", "Eight"};
		String[] D = {"One", "Eight", "Three", "Two", "Four", "Six", "Five"};
	    
		System.out.println("-Find Matching Subarrays-");
		System.out.print("  ");
		DisplayUtil.printArray(B);
		System.out.print("\n  ");
		DisplayUtil.printArray(C);

	    System.out.println("\nResult:");
		
	    List<List<String>>[] subarrays = Subarray.findMatchingSubarrays(B, C);
	    for (List match: subarrays) {
	    	System.out.print("  ");
	    	DisplayUtil.printArray(match.toArray(new String[] {}));
	    	System.out.println();
	    }
	    System.out.println();
	}
}
