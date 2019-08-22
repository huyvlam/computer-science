package demo;

import java.util.HashMap;
import java.util.Set;
import java.util.Random;

public class DemoUtil {
    public static int[] createIntArray(int size) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        Random random = new Random();
        int num = random.nextInt(size * 5);
        
        while (map.size() < size) {
            if (map.containsKey(num))
                num = random.nextInt(size * 5);
            else
                map.put(num, true);
        }
        
        Set<Integer> set = map.keySet();
        int[] output = new int[size];
        int i = 0;
        
        for (Integer entry: set)
            output[i++] = entry;

        return output;
    }
    
    public static void printIntArray(int[] A) {
    	for (int a: A) 
    		System.out.print(a + " ");
    }
}
