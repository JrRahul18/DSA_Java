package Graphs;

import java.util.*;

public class dijkstraAlgoForPath {
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
	//USED COMPARABLE FOR PRIORITY QUEUE
	static class Pair implements Comparable <Pair>{
		int v;
		int weight;
		String path;
		
		Pair(int v, int weight, String path){
			this.v = v;
			this.weight= weight;
			this.path = path;
			
		}
		public int compareTo(Pair p) {
			return this.weight - p.weight;
		}
	}
	
	//FIND SHORTEST PATH TO ALL VERTEX USING DIJKSTRA via BFS
	static void shortestPath(ArrayList<Edge>[] graph, PriorityQueue<Pair> pQueue, boolean[] checkVisited, int initial) {
		pQueue.add(new Pair(initial, 0, initial+""));
		
		while(pQueue.size()>0) {
			Pair toBeRemoved = pQueue.remove();
			if(checkVisited[toBeRemoved.v] == true) {
				continue;
			}
			checkVisited[toBeRemoved.v] = true;
			
			System.out.println("To " + toBeRemoved.v + " via " + toBeRemoved.path + " (w-> " + toBeRemoved.weight+")");
			
			for(Edge e: graph[toBeRemoved.v]) {
				if(checkVisited[e.nbr] == false) {
					pQueue.add(new Pair(e.nbr, toBeRemoved.weight+ e.weight, toBeRemoved.path +"-"+ e.nbr));
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
		int initial=sc.nextInt();
		PriorityQueue<Pair> pQueue = new PriorityQueue<>();
		boolean[] checkVisited = new boolean[vertex];
		shortestPath(graph, pQueue, checkVisited, initial);
 	}

}
