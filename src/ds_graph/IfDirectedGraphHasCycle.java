package ds_graph;

import java.util.ArrayList;
import java.util.List;

class Graph8{
	List<List<Integer>> graph;
	boolean Visited[],recursiveStack[];
	int nodes;
	public Graph8(int nodes) {
		graph=new ArrayList<List<Integer>>();
		Visited=new boolean[nodes];
		recursiveStack=new boolean[nodes];
		this.nodes=nodes;
		
		for (int i = 0; i <nodes; i++) {
			graph.add(i,new ArrayList<Integer>());
		}
	}	
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
	}
	
	public boolean  ifHasCycle() {
		for (int i = 0; i <nodes; i++) {
			if(ifCycle(i)) {
				return true;
			}
			
		}
		return false;
	}
	
	public boolean ifCycle(int index) {
		if(recursiveStack[index]) {
			return true;
		}
		if(Visited[index]) {
			return false;
		}
		Visited[index]=true;
		recursiveStack[index]=true;
		
		
		
		List<Integer> neighbourlist=graph.get(index);
		for(int neighbour:neighbourlist) {
			if(ifCycle(neighbour)) {
				return true;
			}
		}
		recursiveStack[index]=false;
		return false;
	}
}


public class IfDirectedGraphHasCycle {

	public static void main(String[] args) {
		    int nodes=5;
	       Graph8 g=new Graph8(nodes);
	       g.addEdge(0,1);
	       g.addEdge(1,2);
	       g.addEdge(2,0);
	       g.addEdge(0,3);
	       g.addEdge(3,4);
	       g.addEdge(4,0);
	       
	      System.out.println(g.ifHasCycle());
	       
	       

	}

}
