package search;

public class BinarySearch {
	public static int findIndex(int[] list, int query) {
		return findIndex(list, query, 0, list.length - 1);
	}
	
	private static int findIndex(int[] list, int query, int low, int high) {
		if (low > high) 
			return -1;
		
		int median = (high - low) / 2 + low;		

		if (list[median] < query) 
			return findIndex(list, query, median + 1, high);
		
		if (list[median] > query) 
			return findIndex(list, query, low, median - 1);
		
		return median;
	}
}
