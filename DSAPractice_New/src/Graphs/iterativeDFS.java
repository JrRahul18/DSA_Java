package Graphs;
import java.util.*;

public class iterativeDFS {
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
			this.path= path;
		}
	}
	
	// PRINT DFS TRAVERSAL TO EACH EDGE THORUGH ITERATION.
	// FOR ITERATION, WE HAVE USED BFS METHOD BUT JUST REPLACED QUEUE WITH STACK
	static void printDFS(ArrayList<Edge>[]graph, boolean[] checkVisited, int initial, Stack<Pair> stk) {
		stk.push(new Pair(initial, initial + ""));
		
		while(stk.size()>0) {
			Pair toBeRemoved = stk.pop();
			if(checkVisited[toBeRemoved.v] == true) {
				continue;
			}
			checkVisited[toBeRemoved.v] = true;
			System.out.println(toBeRemoved.v + "-> " + toBeRemoved.path);
			
			for(Edge e: graph[toBeRemoved.v] ) {
				if(checkVisited[e.nbr] == false) {
					stk.push(new Pair(e.nbr, toBeRemoved.path + " " + e.nbr));
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vertex = sc.nextInt();
		int edges =sc.nextInt();
		
		ArrayList<Edge> graph[] = new ArrayList[vertex];
		
		for(int i=0; i<vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<edges; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}
		int initial = sc.nextInt();
		
		Stack<Pair> stk = new Stack<>();
		boolean[] checkVisited = new boolean[vertex];
		
		printDFS(graph, checkVisited, initial, stk);
		
		
	}
	

}
