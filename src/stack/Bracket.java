package stack;

import java.util.Stack;

public class Bracket {
	/**
	 * 
	 * @param expression
	 * @return true if all bracket has matching pair
	 */
	public static boolean isPaired(String expression) {
		Stack<Character> stack = new Stack<>();

		for (Character character: expression.toCharArray())
			if (!stack.isEmpty() && stack.peek().equals(leftBracket(character)))
				stack.pop();
			else 
				stack.push(character);
		
		return stack.isEmpty();
	}

    /**
     * @return the matching left bracket for "}, ], )"
     */
    private static char leftBracket(char c) {
        if (c == '}')
            return '{';
        
        if (c == ']')
            return '[';
        
        if (c == ')')
            return '(';
        
        return ' ';
    }
}
