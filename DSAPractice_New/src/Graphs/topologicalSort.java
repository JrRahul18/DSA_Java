package Graphs;
import java.util.*;

public class topologicalSort {
	static class Edge{
		int src;
		int nbr;
		Edge(int src, int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	
	//PRINT THE TOPOLOGICAL SORT OF A GRAPH
	// Topological Sort: Sorts a directed graph of edges(u,v) such that every u is placed before v
	static void getTopological(ArrayList<Edge>[] graph, int initial, boolean[] checkVisited, Stack<Integer> stk) {
		
		checkVisited[initial] = true;
		for(Edge e: graph[initial]) {
			if(checkVisited[e.nbr] == false) {
				getTopological(graph, e.nbr, checkVisited, stk);
			}
		}
		stk.push(initial);
	}
	static void printSortedStack(Stack<Integer> stk) {
		while(stk.isEmpty() != true) {
			if(stk.size() == 1) {
				System.out.println(stk.pop());
			}else {
				System.out.print(stk.pop() + "->");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt();
		int edges = sc.nextInt();
		
		ArrayList<Edge> [] graph = new ArrayList[vertex];
		for(int i=0; i<vertex; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<edges; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1].add(new Edge(v1, v2));
		}
		
		boolean[] checkVisited = new boolean[vertex];
		Stack<Integer> stk = new Stack<>();
		
		for(int i=0; i<vertex; i++) {
			if(checkVisited[i] == false) {
				getTopological(graph, i, checkVisited, stk);
				
			}
		}
		printSortedStack(stk);
		
		
	}
	
	
	
}
