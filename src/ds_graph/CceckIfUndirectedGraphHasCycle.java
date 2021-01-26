package ds_graph;

import java.util.ArrayList;
import java.util.List;

class Graph7{
	List<List<Integer>> graph;
	boolean Visited[];
	int nodes;
	public Graph7(int nodes) {
		graph=new ArrayList<List<Integer>>();
		Visited=new boolean[nodes];
		this.nodes=nodes;
		
		for (int i = 0; i <nodes; i++) {
			graph.add(i,new ArrayList<Integer>());
		}
	}	
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}
	
	public boolean  ifUndirectedGraphHasCycle() {
		for (int i = 0; i <nodes; i++) {
			if(!Visited[i]) {
				if(ifCycle(i,-1))
					return true;
			}
			
		}
		return false;
	}
	
	public boolean ifCycle(int index,int parent) {
		Visited[index]=true;
		List<Integer> neighbourlist=graph.get(index);
		for(int neighbour:neighbourlist) {
			if(!Visited[neighbour]) {
				ifCycle(neighbour,index);
			}
			else if(neighbour!=parent) {
				return true;
			}
		}
		return false;
	}
}

public class CceckIfUndirectedGraphHasCycle {

	public static void main(String[] args) {
       int nodes=3;
       Graph7 g=new Graph7(nodes);
       g.addEdge(0,1);
       g.addEdge(0,2);
       g.addEdge(1,0);
       g.addEdge(1,2);
       g.addEdge(2,0);
       g.addEdge(2,1);
       
       System.out.println(g.ifUndirectedGraphHasCycle( ));

	}

}
