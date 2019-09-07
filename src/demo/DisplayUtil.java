package demo;

import java.util.HashMap;
import java.util.Set;
import java.util.Random;

public class DisplayUtil {
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
    
    public static <T> void printArray(T[] list) {
    	for (int i = 0; i < list.length; i++) {
    		System.out.print(list[i]);
    		if (!isLast(i, list)) 
    			System.out.print(", ");
    	}
    }
    
    public static void printIntArray(int[] list) {
    	for (int i = 0; i < list.length; i++) {
    		System.out.print(list[i]);
    		if (i < list.length - 1) 
    			System.out.print(", ");
    	}
    }
    
    private static <T> boolean isLast(int index, T[] list) {
    	return index == list.length - 1;
    }
}
