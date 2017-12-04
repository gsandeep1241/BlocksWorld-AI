package helper;

import base.Node;

public interface StatGenerator {

	public void printStats(boolean isSuccessful, Node endState, long maxQueueSize, int numberOfMoves, long goalTests);

	public void printState(Node state);
	
	public void traceBack(Node node);
	
	public void printErrorStats(boolean isSuccessful, Node endState, long maxQueueSize, int numberOfMoves, 
			long goalTests, String errorMessage);
	
	public void print(String message);
}
