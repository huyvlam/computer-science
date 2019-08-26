package recursion;
import java.util.HashMap;

public class Recursion {
	/**
     * @desc n! = n × (n−1)!
     */
	public static int factorial(int n) {
		return (n == 0) ? 1 : n * factorial(n - 1);
	}

    /**
     * @desc Xn = X(n - 1) + X(n - 2) 
     */
	public static int fibonacci(int n) {
		return (n == 0 || n == 1) ? 
				1 : (fibonacci(n - 1) + fibonacci(n - 2));
	}
}
