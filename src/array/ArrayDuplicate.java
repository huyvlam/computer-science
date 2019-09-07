package array;

import java.util.LinkedList;

import demo.DisplayUtil;

public class ArrayDuplicate {
	/**
	 * @desc: 	1. Given an array of elements with value from 1 to n
	 * 			2. The array is n + 2 in size
	 * 			3. All elements occur once except for 2 repeats
	 * 			4. Find the 2 repeated elements
	 * @return	two repeated elements
	 */
	public static Integer[] findTwoRepeats(int[] list) {
		int[] visited = new int[list.length];
		LinkedList<Integer> repeats = new LinkedList<>();
		
		for (int item: list) 
			if (visited[item] == 1) 
				repeats.add(item);
			else 
				visited[item] = 1;
		
		return repeats.toArray(new Integer[repeats.size()]);
	}
}
