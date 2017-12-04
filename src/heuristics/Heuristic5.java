package heuristics;

import java.util.List;

import base.Node;

public class Heuristic5 implements Heuristic{

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
			
			int max = 0;
			for(int j=0; j < size; j++) {
				int count = 0;
				for(int k=j+1; k < size; k++) {
					if(stackList.get(i).get(k) > stackList.get(i).get(j)) {
						count++;
					}
					max = (int)Math.max(max, count);
				}
			}
			value += max;
			value += size;
		}
		return value;
	}
	
	@Override
	public String getName() {
		return "Heuristic5";
	}


}
