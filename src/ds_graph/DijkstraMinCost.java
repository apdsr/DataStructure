package ds_graph;

import java.util.*;

class Edge{
	int targetNode;
	int distanceFromNode;
	public Edge(int targetNode,int distanceFromNode) {
		this.distanceFromNode=distanceFromNode;
		this.targetNode=targetNode;
	}
}

class Graphh11{
	List<List<Edge>> graph;
	boolean Visited[];
	int distance[];
	
	public Graphh11(int nodes) {
		graph=new ArrayList<>();
		Visited=new boolean[nodes];
		distance=new int[nodes];
		
		for(int i=0;i<nodes;i++) {
			graph.add(i,new ArrayList<>());
			distance[i]=Integer.MAX_VALUE;
		}
	}
	
	public void addEdge(int srcNode,int targetNode,int distance) {
		graph.get(srcNode).add(new Edge(targetNode,distance));
		
	}
	public int minimumDistanceBetweenTwoNodes(int src,int dest) {
		if(src==dest)
			return 0;
		PriorityQueue<Edge> minheap=new PriorityQueue<>((e1,e2) ->e1.distanceFromNode-e2.distanceFromNode);
		distance[src]=0;
		minheap.add(new Edge(0, 0));
		while(!minheap.isEmpty()) {
			int v=minheap.poll().targetNode;
			if(Visited[v])
				continue;
			Visited[v]=true;
			
			List<Edge> childList=graph.get(v);
			for (Edge child : childList) {
				int dist=child.distanceFromNode;
				int childNode=child.targetNode;
				if(!Visited[childNode] && (distance[v]+dist<distance[childNode])) {
					distance[childNode]=distance[v]+dist;
					child.distanceFromNode=distance[v]+dist;
					minheap.add(child);
				}
			}
		}
		return distance[dest];
	}
	
}


public class DijkstraMinCost {
     

	public static void main(String[] args) {
		int nodes=5;
		Graphh11 a=new Graphh11(nodes); 
		a.addEdge(0, 1, 1);
		a.addEdge(0, 2, 7);
		a.addEdge(1, 2, 5);
		a.addEdge(1, 4, 4);
		a.addEdge(4, 3, 2);
		a.addEdge(2, 3, 6);
		
		System.out.println(a.minimumDistanceBetweenTwoNodes(0,4));

	}

}
