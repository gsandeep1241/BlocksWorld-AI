package helper;

import base.Node;

public interface ProblemGenerator {
	
	static int defaultStacks = 3;
	static int defaultBlocks = 5;
	
	//sets default number of stacks and blocks
	public Node generateRandomStartNode();

	public Node generateRandomStartNode(int stacks, int blocks);
	
	//sets default number of stacks and blocks
	public Node generateStartNodeByShufflingGoalState();
	
	public Node generateStartNodeByShufflingGoalState(int stacks, int blocks);
	
	public Node generateManualStartNode();
}
