package search;

public class JumpSearch {
	public static int findIndex(int[] list, int query) {
		// Determine the block size to jump
		int step = getStep(list);
		int prev = 0;

		// Jump thru the list to find query element
		while (list[Math.min(step, list.length) - 1] < query) {
			prev = step;
			step += getStep(list);

			// if prev is out of bound then element doesn't exist
			if (prev >= list.length) 
				return -1;
		}
		
		// Start with prev, search and increment by one to find query
		while (list[prev] < query) {
			prev++;

			if (prev == Math.min(step, list.length)) 
				return -1;
		}
		
		// Return element index if found
		if (list[prev] == query) 
			return prev;
		
		return -1;
	}

	private static int getStep(int[] list) {
		return (int) Math.floor(Math.sqrt(list.length));
	}
}
