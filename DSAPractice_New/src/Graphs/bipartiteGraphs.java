package Graphs;
import java.util.*;

public class bipartiteGraphs {
	static class Edge{
		int src;
		int nbr;
		Edge(int src, int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	// PAIR INCLUDES LEVELOFv SO THAT NO VERTEX CAN GET TWO DIFFERENT LEVELS
	static class Pair{
		int v;
		String path;
		int levelOfv;
		
		Pair(int v, String path, int levelOfv){
			this.v = v;
			this.path = path;
			this.levelOfv= levelOfv;
		}
	}
	// TO CHECK WHETHER GRAPH IS BIPARTITE VIA BFS
	static boolean checkBipartite(ArrayList<Edge>[] graph, int initial, int[] checkVisited) {
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(initial, initial + "", 0));
		
		while(queue.size()>0) {
			Pair toBeRemoved = queue.removeFirst();
			
			if(checkVisited[toBeRemoved.v] != -1) {
				if(checkVisited[toBeRemoved.v] != toBeRemoved.levelOfv) {
					return false;
				}
			}
			checkVisited[toBeRemoved.v] = toBeRemoved.levelOfv;
			
			for(Edge e: graph[toBeRemoved.v]) {
				if(checkVisited[e.nbr]==-1) {
					queue.add(new Pair(e.nbr, toBeRemoved.path + e.nbr, toBeRemoved.levelOfv+1 ));
				}
			}
		}
		return true;
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
		int[] checkVisited = new int[vertex];
		for(int i=0; i<checkVisited.length; i++) {
			checkVisited[i] = -1;
		}
		
		for(int i=0; i<vertex; i++) {
			if(checkVisited[i] == -1) {
				if(checkBipartite(graph, i, checkVisited)==false) {
					System.out.println("Graph is not Bipartite");
					return;
				}
				
			}
		}
		System.out.println("Graph is Bipartite");
   	}
	

}
