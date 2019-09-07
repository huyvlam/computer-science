package recursion;
import java.lang.String;

public class Permutation {	
	/**
	 * @desc	calculate the number of permutation
	 * @param 	n - the number of elements available (the size of given list)
	 * @param 	r - the number of elements selected
	 * @return	total count of permutation
	 */
	public static int countPermutation(int n, int r) {
		return Recursion.factorial(n)/Recursion.factorial(n - r);
	}
	
	/**
	 * @desc	calculate the number of combination
	 * @param 	n - the number of elements available (the size of given list)
	 * @param 	r - the number of elements selected
	 * @return	total count of combination
	 */
	public static int countCombination(int n, int r) {
		return Recursion.factorial(n)/(Recursion.factorial(n - r) * Recursion.factorial(r));
	}
	
	/**
	 * @desc	print all permutation of a given string
	 * @param 	input
	 */
	public static void permute(String input) {
		if (input.length() == 1) return;
		
		permute(input, 0, input.length() - 1);
	}
	
	private static void permute(String input, int l, int r) {
		if (l == r) 
			System.out.println(input);
		else 
			for (int i = l; i <= r; i++) {
				input = swap(input, l, i); // swap each character
				permute(input, l + 1, r); // permute next character
				input = swap(input, l, i); // backtrack character
			}
	}
	
	private static String swap(String input, int a, int b) {
		char A = input.charAt(a);
		char[] chars = input.toCharArray();
		chars[a] = chars[b];
		chars[b] = A;
		return String.copyValueOf(chars);
	}
}
