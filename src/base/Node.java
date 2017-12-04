package base;

import java.util.ArrayList;
import java.util.List;

import heuristics.Heuristic;

public class Node {
	
	private List<List<Integer>> stackList;
	private Node parent;
	private int fValue;
	private int gValue;
	
	public Node(List<List<Integer>> stackList) {
		this.stackList = stackList;
	}
	
	public Node(List<List<Integer>> stackList, Node parent) {
		this.stackList = stackList;
		this.parent = parent;
	}
	
	public Node(List<List<Integer>> stackList, int fValue) {
		this.stackList = stackList;
		this.fValue = fValue;
	}
	
	public Node(List<List<Integer>> stackList, Node parent, int fValue) {
		this.stackList = stackList;
		this.parent = parent;
		this.fValue = fValue;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setFValue(int fValue) {
		this.fValue = fValue;
	}
	
	public int getFValue() {
		return this.fValue;
	}
	
	public void setGValue(int gValue) {
		this.gValue = gValue;
	}
	
	public int getGValue() {
		return this.gValue;
	}
	
	
	//returns a list of valid successor nodes
	public List<Node> successors(){
		
		List<Node> successorNodes = new ArrayList<>();
		List<List<Integer>> stacksList = this.getStackList();
		int size = stacksList.size();
		
		for(int i=0; i < size; i++) {
			for(int j=0; j < size; j++) {
				if(i == j) {
					continue;
				}
				
				List<List<Integer>> newList = new ArrayList<>();
				for(int k=0; k < size; k++) {
					List<Integer> newStack = new ArrayList<>();
					for(int l=0; l < stacksList.get(k).size(); l++) {
						newStack.add(stackList.get(k).get(l));
					}
					newList.add(newStack);
				}
				
				if(newList.get(i).size() != 0) {
					int removed = newList.get(i).get(newList.get(i).size() - 1);
					newList.get(i).remove(newList.get(i).size()-1);
					newList.get(j).add(removed);
					successorNodes.add(new Node(newList, this));
				}
				
			}
		}
		
		return successorNodes;
	}
	
	public List<List<Integer>> getStackList(){
		return this.stackList;
	}
	
	public boolean isGoalState() {
		
		for(int i=1; i < this.stackList.size(); i++) {
			if(this.stackList.get(i).size() != 0) {
				return false;
			}
		}
		
		List<Integer> firstStack = this.stackList.get(0);
		for(int i=0; i < firstStack.size(); i++) {
			if(firstStack.get(i) != i+1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean deepEquals(Node node) {
		
		int size1 = this.stackList.size();
		int size2 = node.getStackList().size();
		
		if(size1 != size2) {
			return false;
		}
		
		for(int i=0; i < size1; i++) {
			List<Integer> mainStack = this.stackList.get(i);
			List<Integer> compareStack = node.getStackList().get(i);
			
			if(mainStack.size() != compareStack.size()) {
				return false;
			}
			
			for(int j=0; j < mainStack.size(); j++) {
				if(mainStack.get(j) != compareStack.get(j)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void print() {
		
		for(int i=0; i < this.stackList.size(); i++) {
			System.out.print(i+1 + "-> ");
			
			for(int j=0; j < stackList.get(i).size(); j++) {
				System.out.print(stackList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
