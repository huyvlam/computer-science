package recursion;

public class Palindrome {
    /**
     * @source https://en.wikipedia.org/wiki/Palindrome
     * @desc Palindrome is a sequence of characters which reads the same backward as forward
     *       Ex: kayak, civic
     */
    public static boolean isPalindrome(String expression) {
        //find the middle index
        int median = (expression.length() - 1) / 2;

        //compare the character on the left to its equivalent on the right
        for (int left = 0; left < median; left++) {
            int right = expression.length() - 1 - left;

            //if two characters are not equal at any given point, then it is not palindrome
            if (expression.charAt(left) != expression.charAt(right))
                return false;
        }
        
        //if the expression has even length, compare the middle element to its immediate right
        if (expression.length() % 2 == 0 && expression.charAt(median) != expression.charAt(median + 1)) 
            return false;
        
        return true;
    }
}
