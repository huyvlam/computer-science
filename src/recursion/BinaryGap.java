package recursion;

public class BinaryGap {
	/**
	 * @desc: given an integer, convert to binary string and find the max gap between 1 (i.e. 0100101)
	 * @param: integer
	 * @return: interger
	 * @see: 3032 -> 101111011000 -> max gap between two "1" is one
	 */
    public static int max(int num) {
        char[] binaries = Integer.toBinaryString(num).toCharArray();
        int count = 0, max = count;
        boolean counting = false;
        
        for (int i = 0; i < binaries.length; i++) {
            if (binaries[i] == '0' && counting) 
                count += 1;
            else {
                if (max < count)
                    max = count;
                
                count = 0;
                counting = true;
            }
        }
        
        return max;
    }
}
