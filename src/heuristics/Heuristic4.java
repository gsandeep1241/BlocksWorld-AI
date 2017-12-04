package heuristics;

import java.util.List;

import base.Node;

public class Heuristic4 implements Heuristic{

	@Override
	public int getHValue(Node node) {
		int value = 0;
		List<List<Integer>> stackList = node.getStackList();
		int mainStackSize = stackList.get(0).size();
		for(int i=0; i < mainStackSize; i++) {
			if(stackList.get(0).get(i) == i+1) {
				continue;
			}else {
				value += 2*(mainStackSize-i);
				break;
			}
		}
		
		for(int i=1; i < stackList.size(); i++) {
			int size = stackList.get(i).size();
			if(size == 0) {
				continue;
			}
			
			int count = 0;
			int base = stackList.get(i).get(0);
			for(int j=1; j < size; j++) {
				if(stackList.get(i).get(j) > base) {
					count++;
				}
			}
			value += count;
			value += size;
		}
		return value;
	}
	
	@Override
	public String getName() {
		return "Heuristic4";
	}


}
