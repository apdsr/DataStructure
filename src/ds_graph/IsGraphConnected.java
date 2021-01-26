package ds_graph; 
import java.util.*;

class Graph2{
	List<List<Integer>> graph;
	boolean Visited[];
	int nodes;
	public Graph2(int nodes) {
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
	
	public boolean ifGraphConnected() {
		int startindex=0;
	    dfs(startindex);
		for (int i = 0; i < Visited.length; i++) {
		    if(!Visited[i])	{
		    	return false;
		    }
		}
		return true;
	}
	public void  dfs(int startIndex) {
		 Stack<Integer> stack=new Stack<Integer>();
		 stack.push(startIndex);
		 Visited[0]=true;
		 while (!stack.isEmpty()) {
			int element=stack.pop();
			List<Integer> neighbourList=graph.get(element);
			for (Integer neighbour : neighbourList) {
				if(!Visited[neighbour]) {
					stack.push(neighbour);
					Visited[neighbour]=true;
				}
			}
			
		} 
		 
		}
	
}


public class IsGraphConnected {

	public static void main(String[] args) {
	 int nodes=7;
	 Graph2 graph2=new Graph2(nodes);
	 graph2.addEdge(0, 1);
	 graph2.addEdge(0, 2);
	 graph2.addEdge(1, 3);
	 graph2.addEdge(2, 4);
	 graph2.addEdge(3, 5);
	 graph2.addEdge(4, 5);
	// graph2.addEdge(4, 6);  
	 
	 System.out.println(graph2.ifGraphConnected());

	}

}
