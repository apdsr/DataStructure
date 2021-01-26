package ds_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edges{
	int targetNode;
	int distanceFromNode;
	public Edges(int targetNode,int distanceFromNode) {
		this.targetNode=targetNode;
		this.distanceFromNode=distanceFromNode;
	}
}

class Graph12{
	List<List<Edges>> graph;
	boolean visited[];
	int nodes;
	public Graph12(int nodes){
		graph=new ArrayList<>();
		visited=new boolean[nodes];
		this.nodes=nodes;
		for(int i=0;i<nodes;i++) {
			graph.add(i,new ArrayList<>());
		}
		
	}
	public void addEdges(int src,int dest,int cost) {
		graph.get(src).add(new Edges(dest,cost));
		graph.get(dest).add(new Edges(src,cost));
	}
	public int mst() {
		int minCost=0;
		for(int i=0;i<nodes;i++) {
			if(!visited[i]) {
				minCost+=minSpaningTree(i);
			}
		}
		return minCost;
	}
	public int minSpaningTree(int src) {
		PriorityQueue<Edges> minHeap=new PriorityQueue<>((e1,e2)->e1.distanceFromNode-e2.distanceFromNode);
		visited[src]=true;
		List<Edges> childNodes=graph.get(src);
		for (Edges edges : childNodes) {
			minHeap.add(edges);
		}
		int minCost=0;
		while(!minHeap.isEmpty()) {
			Edges minValueEdges=minHeap.poll();
			if(visited[minValueEdges.targetNode])
				continue;
			visited[minValueEdges.targetNode]=true;
			minCost+=minValueEdges.distanceFromNode;
			List<Edges> childList=graph.get(minValueEdges.targetNode);
			for (Edges child : childList) {
				if(!visited[child.targetNode])
					minHeap.add(child);
			}
		}
		return minCost;
	}
	
}


public class PrimesAlgoDS {

	public static void main(String[] args) {
		Graph12 g=new Graph12(5);
		g.addEdges(0, 1, 6);
		g.addEdges(0, 3, 4);
		g.addEdges(1, 2, 10);
		g.addEdges(1, 3, 7);
		g.addEdges(2, 3, 8);
		g.addEdges(2, 4, 5);
		g.addEdges(3, 4, 12);
	
		System.out.println(g.mst());
		
	}
}
