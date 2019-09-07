package demo;

import array.*;
import java.util.Arrays;
import java.util.List;

public class ArrayMutationDemo {
	public static void main(String[] args) {
		arrangeValueToIndex();
		System.out.println();
		segregateValues();
		System.out.println();
		demoArrayRotation();
	}
	
	public static void demoArrayRotation() {
		int[] arr = DisplayUtil.createIntArray(10);
		int[] copy = Arrays.copyOf(arr, arr.length);
		System.out.println("-Array Rotation-");
		System.out.print("  ");
		DisplayUtil.printIntArray(arr);
		ArrayMutation.rotateLeft(arr, 2);
		System.out.println("\nRotate Left 2:");
		System.out.print("  ");
		DisplayUtil.printIntArray(arr);
		ArrayMutation.rotateRight(copy, 5);
		System.out.println("\nRotate Right 5:");
		System.out.print("  ");
		DisplayUtil.printIntArray(copy);
	}

	public static void arrangeValueToIndex() {
        int[] A = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1, 12, 5, -1, 11};
        
        System.out.println("-Rearrange Element To The Index That Matches Its Value-");
        System.out.print("  ");
        DisplayUtil.printIntArray(A);

        ArrayMutation.arrangeValueToIndex(A);

        System.out.println("\nResult:");
        System.out.print("  ");
        DisplayUtil.printIntArray(A);
        System.out.println();
    }

	public static void segregateValues() {
        int[] A = {9, 2, 2, 2, 9, 9, 2, 9, 2, 9};
        int leftValue = 9, rightValue = 2;
        
        System.out.println("-Segregate Elements By Value and Rearrange-");
        System.out.print("  ");
        DisplayUtil.printIntArray(A);

        ArrayMutation.segregateValues(A, 2, 9);
        System.out.println("\nResult:");
        System.out.print("  ");
        DisplayUtil.printIntArray(A);
        System.out.println();
    }	
}
