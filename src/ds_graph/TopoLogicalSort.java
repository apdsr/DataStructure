package ds_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Graphtsort{
	List<List<Integer>> graph;
	int nodes;
	HashMap<Integer,Integer> incomingdegree;
	Queue<Integer> sourceQue;
	public Graphtsort(int nodes) {
		this.nodes = nodes;
		graph=new ArrayList<>();
		incomingdegree=new HashMap<Integer,Integer>();
		sourceQue=new LinkedList<Integer>();
		
		for (int i = 0; i <nodes; i++) {
			graph.add(i,new ArrayList<>());
			incomingdegree.put(i,0);
		}
		
	}
	
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
		incomingdegree.put(b,incomingdegree.get(b)+1);	
	}
	
	public List<Integer> topologicalSort(){
		for (Map.Entry<Integer,Integer> entry:incomingdegree.entrySet()) {
			if(entry.getValue()==0)
				sourceQue.add(entry.getKey());
		}
		List<Integer> resultList=new ArrayList<>();
		
		while(!sourceQue.isEmpty()) {
			int source=sourceQue.remove();
			resultList.add(source);
			List<Integer> neighbourList=graph.get(source);
			for (Integer child : neighbourList) {
				 incomingdegree.put(child,incomingdegree.get(child)-1);
				 if(incomingdegree.get(child)==0) {
					 sourceQue.add(child);
				 }
			}
			
		}
		return resultList;
		
	}
	
	
}

public class TopoLogicalSort {

	public static void main(String[] args) {
		int nodes=6;
		Graphtsort g=new Graphtsort(nodes);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
	  System.out.println(g.topologicalSort());

	}

}
