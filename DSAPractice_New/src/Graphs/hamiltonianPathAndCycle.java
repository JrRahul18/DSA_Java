package Graphs;
import java.util.*;


public class hamiltonianPathAndCycle {
	static class Edge{
		int src;
		int nbr;
		Edge(int src, int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	static void hamiltonian(ArrayList<Edge> graph[], int src) {
		HashSet<Integer> checkVisited = new HashSet<>();
		printHamiltonian(graph, checkVisited, src, src, src+"");
		
	}
	static void printHamiltonian(ArrayList<Edge> graph[], HashSet<Integer> checkVisited, int src, int initial, String printPath) {
		
		// size == length - 1 BECAUSE WHILE CALLING RECURSION, HASHSET IS ONE VERTEX BEHIND AND VERTEX IS ALREADY INCLUDED IN STRING
		if(checkVisited.size()==graph.length - 1) {
			
			boolean check = false;
			for(Edge e: graph[src]) {
				if(e.nbr==initial) {
					check = true;
					break;
				}
			}
			if(check==true) {
				System.out.println(printPath + ": Hamiltonian Cycle");
			}
			else {
				System.out.println(printPath+ ": Hamiltonian Path");
			}
			
			return;
		}
		
		checkVisited.add(src);
		for(Edge e: graph[src]) {
			if(checkVisited.contains(e.nbr)==false) {
				printHamiltonian(graph, checkVisited, e.nbr, initial, printPath +" "+e.nbr);
			}
		}
		checkVisited.remove(src);
		
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
		int src = sc.nextInt();
		hamiltonian(graph, src);
		
	}

}
