package array;

import java.util.List;
import java.util.LinkedList;

public class Subarray {
	/**
	 * @desc	find and return the maximum sum of subarrays
	 */
	public static int maxSum(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);

			if (sum > max) 
				max = sum;
			
			if (sum < 0) 
				sum = 0;
		}
		
		return sum;
	}
	
	/**
	 * @desc	find and return the subarray that has max sum
	 */
	public static Integer[] maxSequence(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		LinkedList<Integer> sequence = new LinkedList<>();
		
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			sequence.offer(list.get(i));
			
			if (sum > max) 
				max = sum;
			
			if (sum < 0) {
				sum = 0;
				sequence.clear();
			}
		}
		
		return sequence.toArray(new Integer[sequence.size()]);
	}
}
