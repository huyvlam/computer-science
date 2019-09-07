package array;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Subarray is a sequence made of one or more array element
 * @desc	this class contains methods for calculation, lookup subarrays
 * @author 	huyster
 */
public class Subarray {
	/**
	 * @desc	find and return the max sum of among the subarrays
	 */
	public static int maxSum(int[] list) {
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < list.length; i++) {
			sum += list[i];

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
	public static Integer[] findMaxSubarray(int[] list) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		LinkedList<Integer> sequence = new LinkedList<>();
		
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
			sequence.offer(list[i]);
			
			if (sum > max) 
				max = sum;
			
			if (sum < 0) {
				sum = 0;
				sequence.clear();
			}
		}
		
		return sequence.toArray(new Integer[sequence.size()]);
	}

	/**
	 * @desc	look in the 2 arrays and find any subarrays that matches one another
	 * @param 	A
	 * @param 	B
	 * @return	subarray
	 */
    public static List<List<String>>[] findMatchingSubarrays(String[] A, String[] B) {
        Map<String, Integer> map = new HashMap<>();
        Stack<List> matched = new Stack<>();
        int prev = Integer.MIN_VALUE; // keep track of the element index that was added to list sequence
        
        // store all A elements in hash map
        for (int i = 0; i < A.length; i++) 
            map.put(A[i], i);
        
        // iterate thru B
        for (int i = 0; i < B.length; i++) {
            String entry = B[i];

            // if hash map contains B element
            if (map.containsKey(entry)) {
                int index = map.get(entry);

                // if previous index is 1 less than the current index
                // -> sequence exists already, add current entry to the sequence
                if (prev + 1 == index) {
                    List<String> existing = matched.peek();
                    existing.add(entry);

                // if no sequence exists, initialize a new sequence, 
                // -> add entry to new sequence
                // -> add sequence to match list
                } else {
                    List<String> sequence = new LinkedList<>();
                    sequence.add(entry);
                    matched.push(sequence);
                }
                
                prev = index;
            }
        }
        
        return matched.toArray(new List[] {});
    }
}
