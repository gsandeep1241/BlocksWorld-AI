package heuristics;

import java.util.ArrayList;
import java.util.List;

import base.Node;

public class Heuristic1 implements Heuristic{

	@Override
	public int getHValue(Node node) {
		
		int value = 0;
		List<List<Integer>> stackList = node.getStackList();
		for(int i=1; i < stackList.size(); i++) {
			int size = stackList.get(i).size();
			value += size;
		}
		return value;
		
	}
	
	@Override
	public String getName() {
		return "Heuristic1";
	}

}
