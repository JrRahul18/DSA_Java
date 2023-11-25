package Graphs;

import java.util.*;

public class cyclicGraph {
	static class Edge{
		int src;
		int nbr;
		Edge(int src, int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	
	static class Pair{
		int v;
		String path;
		
		Pair(int v, String path){
			this.v = v;
			this.path = path;
		}
	}
	//TO CHECK WHETHER CYCLE EXISTS IN GRAPH(via BFS)
	static boolean isCyclic(ArrayList<Edge> graph[], int initial, boolean[] checkVisited) {
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(initial, initial + ""));
		
		while(queue.size()>0) {
			Pair toBeRemoved = queue.removeFirst();
			if(checkVisited[toBeRemoved.v] == true) {
				return true;
			}
			checkVisited[toBeRemoved.v] = true;
			
			for(Edge e: graph[toBeRemoved.v]) {
				if(checkVisited[e.nbr] == false) {
					queue.add(new Pair(e.nbr, toBeRemoved.path + " " + e.nbr));
				}
				
			}
		}
		return false;
		
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
			 
		}
		boolean[] checkVisited = new boolean[vertex];
		for(int i = 0; i<vertex; i++) {
			if(checkVisited[i] == false) {
				boolean cycle = isCyclic(graph, i, checkVisited);
				if(cycle) {
					System.out.println("Cycle Exists");
					return;
				}
				
			}
		}
		System.out.println("No Cycle Exists");
		
	}
	


}
