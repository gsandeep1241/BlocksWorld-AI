package heuristics;

import base.Node;

public interface Heuristic {

	public int getHValue(Node node);
	
	public String getName();
}
