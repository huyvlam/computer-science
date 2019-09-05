package heap;

public class Heap {
    private final int CAPACITY;
    private int size = 0;
    private HeapNode[] root;
    
    public Heap(int size) {
        CAPACITY = size;
        root = new HeapNode[CAPACITY];
    }
    
    public boolean add(int num) {
        if (size == CAPACITY) 
        	return false;
        
        root[size] = new HeapNode(num);
        trickleUp(size++);
        
        return true;
    }
    
    private void trickleUp(int index) {
    	HeapNode parent = root[getParentIndex(index)];
    	HeapNode child = root[index];
    	
    	while (index > 0 && parent.getKey() < child.getKey()) {
    		root[index] = parent;
    		index = getParentIndex(index);
    		parent = root[getParentIndex(index)];
    	}

    	root[index] = child;
    }

    public HeapNode delete() {
        HeapNode max = root[0];
        root[0] = root[--size];
        trickleDown(0);
        
        return max;
    }
    
    private void trickleDown(int index) {
        int greaterIndex;
        HeapNode top = root[index];
        
        while (index < size / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            
            greaterIndex = (rightChildIndex < size && 
                root[leftChildIndex].getKey() < root[rightChildIndex].getKey()) ? 
                    rightChildIndex : leftChildIndex;
            
            if (top.getKey() >= root[greaterIndex].getKey()) break;
            
            root[index] = root[greaterIndex];
            index = greaterIndex;
        }
        
        root[index] = top;
    }
    
    public boolean change(int index, int num) {
        if (index < 0 || index >= size) return false;
        
        int saved = root[index].getKey();
        root[index].setKey(num);
        
        if (saved < num) 
            trickleUp(index);
        else 
            trickleDown(index);

        return true;
    }
    
    public int getParentIndex(int index) {
    	return (index - 1) / 2;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        System.out.print("Heaps: ");
        
        for (int i = 0; i < size; i++) 
            if (root[i] != null) 
                System.out.print(root[i].getKey() + " ");
            else 
                System.out.print("-- ");
        
        System.out.println();
        
        int blanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        
        System.out.println(dots + dots);
        
        while (size > 0) {
            if (column == 0) 
                for (int k = 0; k < blanks; k++)
                    System.out.print(" ");
            
            System.out.print(root[j].getKey());
            
            if (++j == size)
                break;
            
            if (++column == itemsPerRow) {
                blanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else 
                for (int k = 0; k < blanks * 2 - 2; k++) 
                    System.out.print(" ");            
        }

        System.out.println("\n" + dots + dots);
    }
}
