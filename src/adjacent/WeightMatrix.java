package adjacent;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;

public class WeightMatrix extends AdjMatrixBase {
	private PriorityQueue<Edge> candidates; // list of fringe vertex
	private HashMap<Integer, Integer> selectedTree;

	public WeightMatrix(int size) {
		this.size = size;
		matrix = new int[size][size];
		candidates = new PriorityQueue<Edge>(size - 1, new Comparator<Edge>() {
			public int compare(Edge A, Edge B) {
				return ((Integer) A.weight).compareTo(B.weight);
			}
		});
	}
	
	/*
	 * @desc	find the lightest path from one vertex to another
	 * @param	index of starting vertex
	 */
	public Path[] lightestPath(int index) {
		Path[] paths = new Path[size];
		int count = 0;
		int source = index;

		initSelectedTree();
		addToSelectedTree(index);
		prefillPaths(index, paths);
		
		while (count < size) {
			int destination = findMinimumWeight(paths); // find index of the dest vertex with least weight
			
			if (destination == -1) 
				break;
			
			if (paths[destination].weight == Vertex.UNCONNECTED) 
				break;
			
			addToSelectedTree(destination);
			updatePath(destination, paths[destination].weight, paths);
			count++;
		}
		
		return paths;
	}

	/**
	 * All Pairs Shortest Path (Transitive Closure w/ Lightest Weight)
	 * @desc	revise matrix and keep only path with lightest weight
	 * 			this operation mutate the original matrix
	 */
    public void allPairsLightestPath() {
        if (isTransitiveClosure)
            return;

        for (int row = 0; row < size; row++) 
        	for (int col = 0; col < size; col++) 
        		if (matrix[row][col] >= Vertex.CONNECTED)
        			for (int i = 0; i < size; i++) 
        				if (matrix[i][row] >= Vertex.CONNECTED) {
        					int combinedWeight = matrix[row][col] + matrix[i][row];
        					int currentWeight = matrix[i][col];
        					
        					if (currentWeight == Vertex.UNCONNECTED || currentWeight > combinedWeight) 
        						matrix[i][col] = combinedWeight;
        				}

        isTransitiveClosure = true;
    }
	
    /**
     * Weight Minimum Span Tree
     * @desc 	find the minimum number of edges that connect all vertices in a weight graph
     * @return 	a list of edges or null
     */
	public Edge[] minimumEdges() {
		LinkedList<Edge> minSpanTree = new LinkedList<>();
		initSelectedTree();
		int source = 0; // start at 0 or any index
		
		// the minimum number of edges is one less than the number of vertices
		while (minSpanTree.size() < size - 1) {
			addToSelectedTree(source); // add source to selected tree to avoid repeat selection
			
			for (int destination = 0; destination < size; destination++) {
				if (destination == source || isSelected(destination) || !isEdge(source, destination)) 
					continue;
				
				// check candidate list for edge with same destination before adding
				addCandidate(source, destination, matrix[source][destination]);
			}
			
			if (candidates.size() == 0) 
				return null;
			
			Edge min = candidates.poll(); // select min (least weight) from the candidate list
			minSpanTree.offer(min); // min selection is added to MST
			source = min.destination; // set min selection destination as the new source vertex
		}		

		return minSpanTree.toArray(new Edge[minSpanTree.size()]);
	}
	
	private void initSelectedTree() {
		selectedTree = new HashMap<>();
		candidates.clear();
	}
	
	private void addToSelectedTree(int index) {
		selectedTree.put(index, 1);
	}
	
	private boolean isSelected(int index) {
		return selectedTree.containsKey(index);
	}

	/**
	 * @desc	find any candidate that has either same source, destination as specified
	 * @param 	index to check
	 * @param 	indexType is either "source" | "destination"
	 * @return	null | found edge
	 */
    private Edge findSimilarCandidate(int index, String indexType) {
        Iterator iter = candidates.iterator();
        
        while (iter.hasNext()) {
            Edge edge = (Edge) iter.next();
            
            if (indexType == "source") 
                if (edge.source == index)
                    return edge;
            else
            	if (edge.destination == index) 
            		return edge;
        }        

        return null;
    }
    
    /**
     * @desc	check in the list of fringe candidates for any edge with same destination
     * 			1. if none found -> add new candidate
     * 			2. if found -> keep only the one with the least weight
     * @param source
     * @param destination
     * @param weight
     */
    private void addCandidate(int source, int destination, int weight) {
    	Edge sameDestination = findSimilarCandidate(destination, "destination");
    	
    	if (sameDestination == null) 
    		candidates.offer(new Edge(source, destination, weight));
    	else 
    		if (sameDestination.weight > weight) {
    			candidates.remove(sameDestination);
    			candidates.offer(new Edge(source, destination, weight));
    		}
    }

    /**
     * @desc	loop thru array to find the element with lightest weight
     * @param 	paths array
     * @return	index of min weight element
     */
    private int findMinimumWeight(Path[] paths) {
    	int minIndex = -1;
    	int minWeight = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < paths.length; i++) {
    		int weight = (int) paths[i].weight;
    		
    		if (!isSelected(i) && weight >= Vertex.CONNECTED && weight < minWeight) {
    			minWeight = weight;
    			minIndex = i;
    		}
    	}
    	
    	return minIndex;
    }

    /**
     * @desc prefill paths array using vertex as layover, matrix value as weight
     * @param vertIndex 
     */
    private void prefillPaths(int vertex, Path[] paths) {
    	for (int col = 0; col < size; col++) 
    		paths[col] = new Path(vertex, matrix[vertex][col]);
    }
    
    /**
     * @desc	1. find and check the weight of all edge connected to new path
     * 			2. combine the weight of each edge with new path weight
     * 			3. check the paths array for currently existing path at the specified "nextDest" index
     * 			4. compare the combined weight with the existing path weight, select least weight
     * 			-> if the combined weight is less, update the path with the combined weight
     * @param	path
     * @param	paths
     */
    private void updatePath(int pathIndex, int pathWeight, Path[] paths) {
    	int adjacent = 1;
    	
    	while (adjacent < size) {
    		if (isSelected(adjacent)) {
    			adjacent++;
    			continue;
    		}
    		
    		int edgeWeight = matrix[pathIndex][adjacent]; // weight of any edge connected to new path index
    		int combinedWeight = pathWeight + edgeWeight; // combine path weight and new edge weight
    		int currentWeight = paths[adjacent].weight; // 
    		
    		if ((currentWeight > combinedWeight || currentWeight == Vertex.UNCONNECTED) 
    				&& edgeWeight != Vertex.UNCONNECTED) {
    			paths[adjacent] = new Path(pathIndex, combinedWeight);
    		}
    		adjacent++;
    	}
    }
}
