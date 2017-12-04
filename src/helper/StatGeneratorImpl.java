package helper;

import base.Node;

public class StatGeneratorImpl implements StatGenerator{

	@Override
	public void printStats(boolean isSuccessful, Node endState, long maxQueueSize, int numberOfMoves, long goalTests) {
		System.out.println("**********************************************************************");
		if(isSuccessful) {
			System.out.println("The algorithm executed successfully.");
			System.out.println("The end state achieved is: ");
			endState.print();
			
			System.out.println();
			System.out.println("The maximum queue size reached: " + maxQueueSize);
			System.out.println("The number of goal tests conducted: " + goalTests);
			System.out.println("The number of moves taken to reach goal: " + numberOfMoves);
		}else {
			System.out.println("The algorithm failed to execute properly.");
			System.out.println();
			System.out.println("The maximum queue size reached: " + maxQueueSize);
			System.out.println("The number of goal tests conducted: " + goalTests);
			System.out.println("The number of moves taken to reach goal: " + numberOfMoves);
		}
		System.out.println("**********************************************************************");
	}

	@Override
	public void printState(Node state) {
		state.print();
		
	}

	@Override
	public void traceBack(Node node) {
		System.out.println("**********************************************************************");
		System.out.println("Tracing the steps followed by the algorithm: ");
		implementTraceBack(node);
		System.out.println("**********************************************************************");
	}
	
	@Override
	public void printErrorStats(boolean isSuccessful, Node endState, long maxQueueSize,
			int numberOfMoves, long goalTests, String errorMessage) {
		System.out.println("Failure: " + errorMessage);
		printStats(isSuccessful, endState, maxQueueSize, numberOfMoves, goalTests);
	}
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}
	
	private void implementTraceBack(Node node) {
		if(node == null) {
			return;
		}
		implementTraceBack(node.getParent());
		node.print();
		System.out.println();
	}

}
