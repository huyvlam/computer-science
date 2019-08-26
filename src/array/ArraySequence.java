package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ArraySequence {    
    public static List<List<String>>[] findMatchingSequence(String[] A, String[] B) {
        Map<String, Integer> map = new HashMap<>();
        Stack<List> match = new Stack<>();
        int prevIndex = -100; // keep track of the element index that was added to list sequence
        
        // store all A elements in hash map
        for (int i = 0; i < A.length; i++) 
            map.put(A[i], i);
        
        // iterate thru B
        for (int i = 0; i < B.length; i++) {
            String entry = B[i];

            // if hash map contains B element
            if (map.containsKey(entry)) {
                int entryIndex = map.get(entry);

                // if previous index is 1 less than the current index
                // -> sequence exists already, add current entry to the sequence
                if (prevIndex + 1 == entryIndex) {
                    List<String> currentSeq = match.peek();
                    currentSeq.add(entry);

                // if no sequence exists, initialize a new sequence, 
                // -> add entry to new sequence
                // -> add sequence to match list
                } else {
                    List<String> sequence = new LinkedList<>();
                    sequence.add(entry);
                    match.push(sequence);
                }
                
                prevIndex = entryIndex;
            }
        }
        
        return match.toArray(new List[] {});
    }
}
