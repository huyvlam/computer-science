package recursion;
import java.util.HashMap;

public class Recursion {
	/**
     * @source https://www.mathsisfun.com/numbers/factorial.html
     * @desc n! = n × (n−1)!
     */
	public static int factorial(int n) {
		return (n == 0) ? 1 : n * factorial(n - 1);
	}

    /**
     * @source https://www.mathsisfun.com/numbers/fibonacci-sequence.html
     * @desc Xn = X(n - 1) + X(n - 2) 
     */
	public static int fibonacci(int n) {
		return (n == 0 || n == 1) ? 
				1 : (fibonacci(n - 1) + fibonacci(n - 2));
	}    
}
