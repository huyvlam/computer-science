package recursion;

import java.util.HashMap;

public class Anagram {
    /**
     * @note This problem can also be solved with permutation of one string and stop when the other string is found
     * @desc Anagram is a sequence of characters rearranged in different ways
     *       Ex: binary -> brainy
     */
    public static boolean areAnagram(String A, String B) {
        //neither A, B has the same length -> stop
        if (A.length() != B.length())
            return false;

        HashMap<Character, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i), b = B.charAt(i);

            //both character are the same -> skip
            if (a == b) 
                continue;
            
            if (map.containsKey(a)) 
                map.remove(a);
            else
                map.put(a, Boolean.TRUE);

            if (map.containsKey(b))
                map.remove(b);
            else
                map.put(b, Boolean.TRUE);
        }

        return map.size() == 0 ? true : false;
    }
}
