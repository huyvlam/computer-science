package array;

public class ArrayMerge {
	/**
     * Merge Array w/o Space - Time O(n) Space O(1)
     * @spec A is sorted with m elements that are not assigned value
     *       B is sorted with n size equal to m
     *       merge B into A while maintaining sort order
     * @desc merge B into A w/o using extra space
     */
    public static void join(int[] A, int[] B) {
        int a = 0, b = 0;
        int prev = 0;
        
        while (a < A.length && b < B.length) {
            int current = A[a];
            
            //current & previous has no assigned value
            if (current == 0 && prev == 0) {
            	// Check one of the following conditions:
                // 1. current is the last element in A (a == A.length - 1)
                // 2. next element has no assigned value (A[a + 1] == 0)
                // 3. next element is greater than B element (A[a + 1] > B[b])
                // -> any is true -> place B element in current index
                if (a == A.length - 1 || A[a + 1] == 0 || (A[a + 1] != 0 && A[a + 1] > B[b])) {
                    A[a] = B[b++];
                // next element is less than B element -> place next element in current index, set next element value to none
                } else {
                    A[a] = A[a + 1];
                    A[a + 1] = 0;
                }

            // 1. current has no assigned value
            // 2. B element is less than previous
            // -> both are true -> place B element in current index
            } else if (current == 0 && B[b] < prev) {
                A[a] = B[b++];

            // 1. current has no assigned value
            // 2. previous is less than B element
            // -> both true -> place previous in current index, set prev to none
            } else if (current == 0 && B[b] > prev) {
                A[a] = prev;
                prev = 0;

            // current is greater than previous -> place previous in current index, save current value in prev
            } else if (prev != 0 && current > prev) {
                A[a] = prev;
                prev = current;

            //current is greater than B element -> place B element in current index, save current value in prev
            } else if (current > B[b]) {
                A[a] = B[b++];
                prev = current;
            }
            
            a++;
        }
        
        //last element remains in A -> place previous in its place
        while (a < A.length && prev != 0)
            A[a++] = prev;
    }

	/**
     * Merge Array w/ Space - Time O(n) Space o(n)
     * @desc loop thru both arrays continuously, compare and place the min value into new array
     * @return the merged array in sorted order
     */
    public static int[] joinAlt(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];
        int indexA = 0, indexB = 0, indexM = 0;
        
        // compare each element in A & B, add the smaller one to merged array
        while (indexA < A.length && indexB < B.length) 
            // A less than B, add A to merged array and increment indexA
            if (A[indexA] < B[indexB]) 
                merged[indexM++] = A[indexA++];
            // B less than A, add B to merged array and increment indexB
            else
                merged[indexM++] = B[indexB++];
        
        // check for remaining in A, add to merged array
        while (indexA < A.length)
            merged[indexM++] = A[indexA++];
        
        // check for remaining in B, add to merged array
        while (indexB < B.length)
            merged[indexM++] = B[indexB++];
        
        return merged;
    }    
}
