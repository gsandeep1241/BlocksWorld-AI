package main;

import java.util.*;

import base.Node;
import helper.ProblemGenerator;
import helper.ProblemGeneratorImpl;
import worker.AStarSearch;
import worker.AStarSearchHelper;
import worker.BreadthFirstSearch;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int stacks = 0;
		int blocks = 0;
		ProblemGenerator generator = new ProblemGeneratorImpl();
		Node startNode = null;
		
		System.out.println("Enter 0 to perform BFS.");
		System.out.println("Enter 1 to perform A* Search using Heuristic 1.");
		System.out.println("Enter 2 to perform A* Search using Heuristic 2.");
		System.out.println("Enter 3 to perform A* Search using Heuristic 3.");
		System.out.println("Enter 4 to perform A* Search using Heuristic 4.");
		System.out.println("Enter 5 to perform A* Search using Heuristic 5.");
		System.out.println("Enter 6 to perform A* Search using only the two best Heuristics: 4 & 5.");
		System.out.println("Enter 7 to perform A* Search using all the 5 Heuristics");
		System.out.print("Your choice: ");
		int choice = in.nextInt();
		
		if(choice < 0 || choice > 7) {
			System.out.println("Bad choice. Please restart."); in.close(); return;
		}
		
		System.out.println("Do you want to operate on a randomly generated start state?");
		System.out.print("Enter Y/N: ");
		
		String decision = in.next();
		if(decision.equals("Y")) {
			System.out.print("Enter Number of stacks: ");
			stacks = in.nextInt();
			if(stacks < 3) {
				System.out.println("Enter atleast 3 stacks. Please restart."); in.close(); return;
			}
			System.out.print("Enter number of blocks: ");
			blocks = in.nextInt();
			
			startNode = generator.generateRandomStartNode(stacks, blocks);
		}else if(decision.equals("N")){
			System.out.print("Enter Number of stacks: ");
			stacks = in.nextInt();
			if(stacks < 3) {
				System.out.println("Enter atleast 3 stacks. Please restart."); in.close(); return;
			}
			System.out.print("Enter number of blocks: ");
			blocks = in.nextInt();
			
			boolean[] a = new boolean[blocks+1];
			List<List<Integer>> stackList = new ArrayList<>();
			int count = 0;
			for(int i=0; i < stacks; i++) {
				List<Integer> list = new ArrayList<>();
				System.out.print("Enter number of blocks in Stack" + (i+1) + ": ");
				int b = in.nextInt();
				if(count+b > blocks) {
					System.out.print("Maximum number of blocks allowed is " + blocks + ". Please restart."); in.close(); return;
				}
				if(b == 0) {
					stackList.add(list);
					continue;
				}
				System.out.println("Enter " + b + " values. Only enter numbers less than or equal to " + blocks + 
						" and don't repeat the block numbers.");
				for(int j=0; j < b; j++) {
					int val = in.nextInt();
					if(val > blocks || val <= 0) {
						System.out.println("Block number should be less than number of blocks and greater than 0. "
								+ "Please restart."); in.close(); return;
					}
					count++;
					if(count > blocks) {
						System.out.println("Too many blocks. Please restart."); in.close(); return;
					}
					if(a[val]) {
						System.out.println("Repeated block. Please restart."); in.close(); return;
					}
					a[val] = true;
					
					list.add(val);
				}
				stackList.add(list);
			}
			startNode = new Node(stackList);
			
		}else {
			System.out.println("You need to enter Y or N. Please restart."); in.close(); return;
		}
		
		if(choice == 0) {
			BreadthFirstSearch.perform(startNode);
		}else {
			AStarSearchHelper.perform(startNode, choice);
			
		}
		
	}

}
