package Graphs;
import java.util.*;

public class primsAlgo {
	static class Edge{
		int src;
		int nbr;
		int weight;
		Edge(int src, int nbr, int weight){
			this.src = src;
			this.nbr = nbr;
			this.weight = weight;
		}
	}
	static class Pair implements Comparable<Pair>{
		int v;
		int prev;
		int wgt;
		Pair(int v, int prev, int wgt){
			this.v = v;
			this.prev = prev;
			this.wgt = wgt;
		}
		public int compareTo(Pair p) {
			return this.wgt - p.wgt;
		}
	}
	
	// FIND MST(minimum spanning tree) USING PRIM'S ALGORITHM
	// Prim's different from Dijkstra because in Prim's, we have to travel to all vertices for minimum path 
	//whereas in Dijkstra, it is not necessary to include all vertex for shortest path.  
	static void primsMST(ArrayList<Edge>[] graph, PriorityQueue<Pair> pQueue, boolean[] checkVisited) {
		pQueue.add(new Pair(0, -1, 0));
		while(pQueue.size()>0){
			Pair toBeRemoved = pQueue.remove();
			
			if(checkVisited[toBeRemoved.v] == true) {
				continue;
			}
			checkVisited[toBeRemoved.v] = true;
			
			if(toBeRemoved.prev != -1) {
				System.out.println("To " + toBeRemoved.v + " via " + toBeRemoved.prev + " (w-> " + toBeRemoved.wgt+")");
			}
			for(Edge e : graph[toBeRemoved.v]) {
				if(checkVisited[e.nbr] == false) {
					pQueue.add(new Pair(e.nbr, toBeRemoved.v, e.weight));
				}	
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt();
		int edges = sc.nextInt();
		
		ArrayList<Edge> graph[] = new ArrayList[vertex];
		for(int i = 0; i<vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<edges; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wgt = sc.nextInt();
			graph[v1].add(new Edge(v1, v2, wgt));
			graph[v2].add(new Edge(v2, v1, wgt));
			 
		}
		PriorityQueue<Pair> pQueue = new PriorityQueue<>();
		boolean[] checkVisited = new boolean[vertex];
		
		primsMST(graph, pQueue, checkVisited);
	}
	

}
