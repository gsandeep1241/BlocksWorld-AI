package worker;

import base.Node;
import heuristics.*;

public class AStarSearchHelper {

	public static void perform(Node startNode, int choice) {
		
		if(choice == 1) {
			Heuristic heuristic1 = new Heuristic1();
			AStarSearch.perform(startNode, heuristic1);
		}else if(choice == 2) {
			Heuristic heuristic2 = new Heuristic2();
			AStarSearch.perform(startNode, heuristic2);
		}else if(choice == 3) {
			Heuristic heuristic3 = new Heuristic3();
			AStarSearch.perform(startNode, heuristic3);
		}else if(choice == 4) {
			Heuristic heuristic4 = new Heuristic4();
			AStarSearch.perform(startNode, heuristic4);
		}else if(choice == 5) {
			Heuristic heuristic5 = new Heuristic5();
			AStarSearch.perform(startNode, heuristic5);
		}else if(choice == 6) {
			Heuristic heuristic4 = new Heuristic4();
			AStarSearch.perform(startNode, heuristic4);
			Heuristic heuristic5 = new Heuristic5();
			AStarSearch.perform(startNode, heuristic5);
		}else if(choice == 7) {
			Heuristic heuristic1 = new Heuristic1();
			AStarSearch.perform(startNode, heuristic1);
			Heuristic heuristic2 = new Heuristic2();
			AStarSearch.perform(startNode, heuristic2);
			Heuristic heuristic3 = new Heuristic3();
			AStarSearch.perform(startNode, heuristic3);
			Heuristic heuristic4 = new Heuristic4();
			AStarSearch.perform(startNode, heuristic4);
			Heuristic heuristic5 = new Heuristic5();
			AStarSearch.perform(startNode, heuristic5);
		}
	}
}
