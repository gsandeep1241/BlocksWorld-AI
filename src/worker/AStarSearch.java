package worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import base.Node;
import helper.StatGenerator;
import helper.StatGeneratorImpl;
import static helper.Constants.*;
import heuristics.Heuristic;

public class AStarSearch {

	public static void perform(Node startNode, Heuristic heuristic) {
		
		StatGenerator statGenerator = new StatGeneratorImpl();
		statGenerator.print("Initializing A* Search using Heuristic " + heuristic.getName() +  " on: ");
		statGenerator.printState(startNode);
		
		startNode.setFValue(0);
		startNode.setGValue(0);
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.getFValue()-n2.getFValue();
			}
			
		});
		String errorMessage = "";
		int goalTestLimit = GOAL_TESTS_LIMIT;
		int maxAllowedQueueSize = MAX_ALLOWED_QUEUE_SIZE;
		ArrayList<Node> seenNodes = new ArrayList<>();
		long numberOfGoalTests = 0;
		long maxQueueSize = 0;
		long queueSize = 0;
		int numberOfMoves = 0;
		
		queue.offer(startNode);
		queueSize++;
		maxQueueSize = (long)Math.max(queueSize, maxQueueSize);
		
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			seenNodes.add(currentNode);
			queueSize--;
			
			numberOfGoalTests++;
			if(numberOfGoalTests > goalTestLimit) {
				errorMessage = "Goal Tests limit(" + goalTestLimit + ") exceeded."; break;
			}
			if(currentNode.isGoalState()) {
				
				statGenerator.printStats(true, currentNode, maxQueueSize, currentNode.getGValue(),
						numberOfGoalTests);
				statGenerator.traceBack(currentNode);
				return;
			}

			numberOfMoves++;
			List<Node> successors = currentNode.successors();
			for(Node node: successors) {
				if(!seen(node, seenNodes)) {
					int gValue = currentNode.getGValue() + 1;
					int hValue = heuristic.getHValue(node);
					int fValue = gValue + hValue;
					node.setGValue(gValue);
					node.setFValue(fValue);
					
					queue.offer(node);
					queueSize++;
					if(queueSize > maxAllowedQueueSize) {
						errorMessage = "Queue Size limit(" + maxAllowedQueueSize + ") exceeded."; break;
					}
					maxQueueSize = (long)Math.max(queueSize, maxQueueSize);
				}
			}
			
		}
		statGenerator.printErrorStats(false, null, maxQueueSize, -1,
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
