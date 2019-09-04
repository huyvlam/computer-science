package adjacent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class AdjList extends AdjListBase {
	public AdjList(int size) {
		this.size = size;
		list = new LinkedList[size];
	}
}
