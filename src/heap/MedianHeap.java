package heap;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * @desc	Median Heap use one PQ to store high values and another PQ to store low values
 * 			The head of this two PQ is used to calculate the median value
 * @author 	huyster
 *
 */
public class MedianHeap {
    PriorityQueue<Integer> hi; // natural asc order
    PriorityQueue<Integer> lo; // descending order

    public MedianHeap() {
        hi = new PriorityQueue<Integer>();
        hi.add(Integer.MAX_VALUE);

        lo = new PriorityQueue<Integer>(20, new Comparator<Integer>() {
            public int compare(Integer A, Integer B) {
                return B.compareTo(A);
            }
        });
        lo.add(Integer.MIN_VALUE);
    }

    /**
     * @return	the median of two PQ head
     */
    public double median() {
    	// if the low PQ has more element -> the median is low head element
        if (lo.size() > hi.size())
            return (double) lo.peek();
        
        // if the high PQ has more element -> the median is high head element
        if (hi.size() > lo.size())
            return (double) hi.peek();
        
        // if the number of elements are even -> the median is half the sum of low and high
        return (double) (hi.peek() + lo.peek()) / 2;
    }
    
    /**
     * @desc	1. if entry is greater than high PQ head then add it to high PQ
     * 			2. if entry is less -> add to low PQ
     * 			3. balance the two PQ after each addition
     * @param num
     */
    public void add(int num) {
        if (num >= hi.peek())
            hi.add(num);
        else
            lo.add(num);
        
        balance();
    }
    
    /**
     * @desc	balance the two PQ to ensure: 
     * 			1. EITHER their size should be equal when the number of entries are even
     * 			2. OR there's only one different between the two PQ
     */
    private void balance() {
        if (hi.size() - lo.size() > 1)
            lo.add(hi.poll());
        else if (lo.size() - hi.size() > 1)
            hi.add(lo.poll());        
    }
}
