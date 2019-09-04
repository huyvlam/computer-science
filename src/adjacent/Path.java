package adjacent;

public class Path {
	public int layover;
	public int weight;
	
	public Path(int vertex, int weight) {
		layover = vertex;
		this.weight = weight;
	}
}
