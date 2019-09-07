package demo;

import array.ArrayDuplicate;

public class ArrayDuplicateDemo {
	public static void main(String[] args) {
		findTwoRepeats();
	}

	public static void findTwoRepeats() {
		int[] arr = {1,6,5,5,4,3,4};
		Integer[] repeats = ArrayDuplicate.findTwoRepeats(arr);
		System.out.println("-Find Two Repeated Elements-");
		System.out.print("  ");
		DisplayUtil.printIntArray(arr);
		System.out.println("\nResult:");
		DisplayUtil.printArray(repeats);
	}
}
