package ds_graph;

import java.util.ArrayList;
import java.util.Stack;

class Graph4{
	private int node;
	ArrayList<ArrayList<Integer>> graph;
	boolean  visited[]; 
	public Graph4(int node) {
		this.node=node;
		graph=new ArrayList<>();
		visited =new boolean[node];
		for(int i=0;i<node;i++) {
			graph.add(i,new ArrayList<>());
		}
	}
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
		
	}
	public  int  countComponent() {
		int count=0;
		for(int i=0;i<node;i++) {
			if(!visited[i]) {
				dfs(i);
				count++;			
			}
		}
		return count;
	}
	public void dfs(int start) {
		Stack<Integer> st=new Stack<>();
		st.push(start);
		visited[start]=true;
		while(!st.isEmpty()) {
			int elm=st.pop();
			ArrayList<Integer> neighbourList=graph.get(elm);
			for(Integer neighbour:neighbourList) {
				if(!visited[neighbour]) {
					st.push(neighbour);
					visited[neighbour]=true;
				}
			}
		}
		
	}
	
	
}

public class CountConnectedComponent {

	public static void main(String[] args) {
		int node=7;
		Graph4 g=new Graph4(node);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,0);
		g.addEdge(1,3);
		g.addEdge(2,0);
		g.addEdge(3,1);
		g.addEdge(4,5);
		g.addEdge(5,4);
		g.addEdge(6,5);
		
	 System.out.println(g.countComponent());
		
		

	}

}
