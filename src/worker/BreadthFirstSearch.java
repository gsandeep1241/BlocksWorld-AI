package worker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import base.Node;
import helper.StatGenerator;
import helper.StatGeneratorImpl;
import static helper.Constants.*;

public class BreadthFirstSearch {

	public static void perform(Node startNode) {
		
		StatGenerator statGenerator = new StatGeneratorImpl();
		statGenerator.print("Initializing Breadth First Search on: ");
		statGenerator.printState(startNode);
		
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> seenNodes = new ArrayList<>();
		String errorMessage = "";
		int goalTestLimit = GOAL_TESTS_LIMIT;
		int maxAllowedQueueSize = MAX_ALLOWED_QUEUE_SIZE;
		
		queue.add(startNode);
		seenNodes.add(startNode);
		
		long maxQueueSize = 1;
		int numberOfMoves = 0;
		long numberOfGoalTests = 0;
		
		int total = 1;
		while(!queue.isEmpty()) {
			
			int size = total;
			if(size > maxAllowedQueueSize) {
				errorMessage = "Queue Size limit(" + maxAllowedQueueSize + ") exceeded."; break;
			}
			maxQueueSize = (int)Math.max(size, maxQueueSize);
			total = 0;
			
			for(int t=0; t < size; t++) {
				Node currentNode = queue.remove();
				numberOfGoalTests++;
				if(numberOfGoalTests > goalTestLimit) {
					errorMessage = "Goal Tests limit(" + goalTestLimit + ") exceeded."; break;
				}
				if(currentNode.isGoalState()) {
					
					statGenerator.printStats(true, currentNode, maxQueueSize, numberOfMoves,
							numberOfGoalTests);
					statGenerator.traceBack(currentNode);
					return;
				}
				
				List<Node> successors = currentNode.successors();
				for(Node node: successors) {
					if(!seen(node, seenNodes)) {
						queue.add(node);
						seenNodes.add(currentNode);
						total++;
						maxQueueSize = (int)Math.max(size+total-1, maxQueueSize);
					}
				}
			}
			size = total;
			numberOfMoves++;
		}
		statGenerator.printErrorStats(false, null, maxQueueSize, numberOfMoves,
				numberOfGoalTests, errorMessage);
	}
	
	private static boolean seen(Node node, List<Node> seenNodes) {
		for(int i=0; i < seenNodes.size(); i++) {
			if(node.deepEquals(seenNodes.get(i))) {
				return true;
			}
		}
		return false;
	}
}
