package ds_graph;
import java.util.ArrayList;
import java.util.Stack;
class Graph6{
	int nodes;
    boolean Visited[];
    ArrayList<ArrayList<Integer>> graph;
	public  Graph6(int node) {
		nodes=node;
		Visited=new boolean[node];
		graph=new ArrayList<>();
		for(int i=0;i<nodes;i++) {
			graph.add(i,new ArrayList<>());
		}
		
	}
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
		
	}
	public boolean isPathExists(int source,int dest){
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

public class ifSourceToDestinationPathExists {

	public static void main(String[] args) {
		Graph6 g=new Graph6(4);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(3,2);
		
		
	    System.out.println(g.isPathExists(0,2));
		

	}

}
