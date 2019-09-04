package graph;

public class Edge {
	public int source;
	public int destination;
	public int weight;

    public Edge(int sourceIndex, int destIndex, int weight) {
        source = sourceIndex;
        destination = destIndex;
        this.weight = weight;
    }
}
