package ds_graph;
import java.util.*;
class Graph5{
	int nodes;
    boolean Visited[];
    ArrayList<ArrayList<Integer>> graph;
	public  Graph5(int node) {
		nodes=node;
		Visited=new boolean[node];
		graph=new ArrayList<>();
		for(int i=0;i<nodes;i++) {
			graph.add(i,new ArrayList<>());
		}
		
	}
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
		
	}
	public boolean isCoonected(int source,int dest){
		dfs(source);
		if(Visited[dest])
			return true;
		else 
			return false;
	}
	public void dfs(int src) {
		Stack<Integer> st=new Stack<>();
		st.push(src);
		Visited[src]=true;
		while(!st.isEmpty()) {
			int elem=st.pop();
			ArrayList<Integer> neighbourlist=graph.get(elem);
			for(Integer neighbour:neighbourlist) {
				if(!Visited[neighbour]) {
					Visited[neighbour]=true;
					st.push(neighbour);
				}
			}
		}
	}
	
}

public class IsSourceToDestnationConnected {

	public static void main(String[] args) {
		Graph5 g=new Graph5(7);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,0);
		g.addEdge(1,3);
		g.addEdge(2,0);
		g.addEdge(3,1);
		g.addEdge(4,5);
		g.addEdge(4,6);
		g.addEdge(5,4);
		g.addEdge(6,4);
		
		 System.out.println(g.isCoonected(0,4));
		
	}

}
