package recursion;
import java.lang.String;

public class Permutation {	
	public static int countPermutation(int n) {
		return Recursion.factorial(n);
	}
	
	public static int countPermutation(int n, int r) {
		return Recursion.factorial(n)/Recursion.factorial(n - r);
	}
	
	public static int countCombination(int n, int r) {
		return Recursion.factorial(n)/(Recursion.factorial(n - r) * Recursion.factorial(r));
	}
	
	private static String swap(String input, int a, int b) {
		char A = input.charAt(a);
		char[] chars = input.toCharArray();
		chars[a] = chars[b];
		chars[b] = A;
		return String.copyValueOf(chars);
	}
	
	public static void permute(String input) {
		if (input.length() == 1) return;
		
		permute(input, 0, input.length() - 1);
	}
	
	private static void permute(String input, int l, int r) {
		if (l == r) 
			System.out.println(input);
		else {
			for (int i = l; i <= r; i++) {
				input = swap(input, l, i);
				permute(input, l + 1, r); // 
				input = swap(input, l, i); // backtracking
			}			
		}
	}
}
