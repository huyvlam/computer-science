package graph;

public class Edge {
	public int sourceIndex;
	public int destIndex;
	public int weight;

    public Edge(int sourceIndex, int destIndex, int weight) {
        this.sourceIndex = sourceIndex;
        this.destIndex = destIndex;
        this.weight = weight;
    }
}
