package array;

import java.util.HashMap;


public class ArrayQuery {
	/**
	 * @desc: 	Given an array of n + r elements. 
	 * 			All elements of the array are in range 1 to n, and all elements occur once except r elements which occur twice. 
	 * 			Find the r repeating elements.
	 */
	public static int[] findRepeated(int[] list, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] repeats = new int[list.length - n];
		int ri = 0;

		for (int el: list) {
			if (map.containsKey(el)) 
				repeats[ri++] = el;
			else 
				map.put(el, 1);
		}
		
		return repeats;
	}
}
