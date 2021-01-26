package ds_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Graph3{
	private int nodes;
	List<List<Integer>> graph;
	boolean visited[];
	public Graph3(int nodes) {
		graph=new ArrayList<List<Integer>>();
		visited=new boolean[nodes];
		this.nodes=nodes;
		for (int i = 0; i < nodes; i++) {
			graph.add(i,new ArrayList<>());
		}
	}
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
	}
 boolean ifDirectedGraphStronglyConneted(){
		for (int i = 0; i < nodes; i++) {
			dfs(i);
			for(int j=0;j<nodes;j++) {
				if(!visited[j])
					return false;
			}
			Arrays.fill(visited,false);
		}
		return true;
	}
 public void dfs(int start) {
	 Stack<Integer> stack=new Stack<Integer>();
	 stack.push(start);
	 visited[start]=true;
	 while (!stack.isEmpty()) {
		int elem=stack.pop();
		List<Integer> neighbour=graph.get(elem);
		for (Integer n : neighbour) {
			if(!visited[n]) {
				visited[n]=true;
				stack.push(n);
			}
		}
	}
 }
}

public class IsDirectedGraphStronglyConnected {

	public static void main(String[] args) {
		Graph3 graph=new Graph3(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(3, 2);
		
		System.out.println(graph.ifDirectedGraphStronglyConneted());
	}

}
