package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import base.Node;

//All the functions in ProblemGenerator return a Node type
//which will be used as the Start Node in solving the Stacking Blocks Algorithm

public class ProblemGeneratorImpl implements ProblemGenerator{

	@Override
	public Node generateRandomStartNode() {
		return generateRandomStartNode(defaultStacks, defaultBlocks);
	}

	@Override
	public Node generateRandomStartNode(int stacks, int blocks) {
		List<List<Integer>> stackList = new ArrayList<>();
		
		for(int i=0; i < stacks; i++) {
			stackList.add(new ArrayList<Integer>());
		}
		
		ArrayList<Integer> blockList = new ArrayList<>();
		for(int i=1; i <= blocks; i++) {
			blockList.add(i);
		}
		
		long seed = System.nanoTime();
		Collections.shuffle(blockList, new Random(seed));
		
		for(int i=0; i < blockList.size(); i++) {
			int randomStackIndex = (int) Math.floor(Math.random()*(stacks));
			stackList.get(randomStackIndex).add(blockList.get(i));
		}
		return new Node(stackList);
	}

	@Override
	public Node generateStartNodeByShufflingGoalState() {
		return generateStartNodeByShufflingGoalState(defaultStacks, defaultBlocks);
	}

	@Override
	public Node generateStartNodeByShufflingGoalState(int stacks, int blocks) {
		Node startNode = getGoalNode(stacks, blocks);
		
		//perform random shuffles for stacks^2 times
		int shufflesLeft = stacks*stacks*blocks;
		while(shufflesLeft != 0) {
			int randomPickUpStackIndex = (int) Math.floor(Math.random()*(stacks));
			int randomPlaceBackStackIndex = (int) Math.floor(Math.random()*(stacks));
			
			List<Integer> pickUpStack = startNode.getStackList().get(randomPickUpStackIndex);
			List<Integer> placeBackStack = startNode.getStackList().get(randomPlaceBackStackIndex);
			if(pickUpStack.size() == 0 || 
					randomPickUpStackIndex == randomPlaceBackStackIndex) {
				continue;
			}else {
				int valueRemoved = pickUpStack.get(pickUpStack.size()-1);
				pickUpStack.remove(pickUpStack.size()-1);
				
				placeBackStack.add(valueRemoved);
				shufflesLeft--;
			}
		}
		return startNode;
	}
	
	@Override
	public Node generateManualStartNode() {
		List<List<Integer>> stackList = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>(Arrays.asList(4));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(5,6,9,10));
		List<Integer> list3 = new ArrayList<>(Arrays.asList(2,7));
		List<Integer> list4 = new ArrayList<>(Arrays.asList(3,8));
		List<Integer> list5 = new ArrayList<>(Arrays.asList(1));
		stackList.add(list1);
		stackList.add(list2);
		stackList.add(list3);
		stackList.add(list4);
		stackList.add(list5);
		return new Node(stackList);
	}
	
	private Node getGoalNode(int stacks, int blocks) {
		List<List<Integer>> stackList = new ArrayList<>();
		
		for(int i=0; i < stacks; i++) {
			stackList.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i <= blocks; i++) {
			stackList.get(0).add(i);
		}
		
		return new Node(stackList);
	}
	
}
