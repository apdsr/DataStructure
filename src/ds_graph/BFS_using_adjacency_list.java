package ds_graph;
import java.util.*;
class Graph{
	List<List<Integer>> graph;
	boolean visited[];
	Graph(int node){
		graph=new ArrayList<>();
	    visited =new boolean[node];
	    for (int i = 0; i <node; i++) {
			graph.add(i,new ArrayList<>());
		}
	}
	public void addEdge(int a,int b){
		graph.get(a).add(b);
		graph.get(b).add(a);
	}
	
	public void bfs(int startIndex) {
		Queue<Integer> q=new LinkedList<>();
		q.add(startIndex);
		visited[startIndex]=true;
		while(!q.isEmpty()) {
			int node=q.poll();
			System.out.println(node);
			List<Integer> childList=graph.get(node);
			for (Integer child: childList) {
				if(!visited[child]) {
					q.add(child);
					visited[child]=true;
				}
			}
		}
	}
	
}

public class BFS_using_adjacency_list {
	public static void main(String args[]) {
		int node=6;
		Graph g=new Graph(node);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(1,4);
		g.addEdge(2,4);
		g.addEdge(2,5);
		g.addEdge(4,5);
		g.bfs(0);
	}
}
