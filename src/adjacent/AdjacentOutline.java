package adjacent;

/**
 * @desc	outline methods for adjacent matrix, adjacent list
 * @author 	huyster
 */
public interface AdjacentOutline {
	public Integer[] bfsTraverse(int vertIndex);
	public Integer[] dfsTraverse(int vertIndex);
	
	public void addEdge(int source, int destination, int weight);	
	public boolean isEdge(int source, int destination);
	
	public boolean hasSuccessor(int vertIndex);
	public int findSuccessor();
	
	public boolean isLast(int vertIndex);

	public void initVisitedList();	
	public void resetVisitedList();
	public void addToVisited(int vertIndex);
	public boolean hasVisited(int vertIndex);
	public int findUnvisited(int vertIndex);
}
