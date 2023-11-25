package Graphs;
import java.util.*;

public class PerfectFriendProblems {
	
	static class Edge{
		int src;
		int nbr;
		Edge(int src, int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	
	// TO FIND TOTAL POSSIBLE PAIRS FROM A GROUP OF FRIENDS FORMED THROUGH EDGES OF DIFFERENT VERTEX 
	static void totalPairOfFriends(ArrayList<Edge> graph[], int v) {
		
		ArrayList<ArrayList<Integer>> totalGroups = new ArrayList<>();
		boolean checkVisited[] = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(checkVisited[i] == false) {
				ArrayList<Integer> group = new ArrayList<>();
				formPairs(graph, i, group, checkVisited);
				totalGroups.add(group);				
			}
		}
		int totalPairs = 0;
		for(int i =0; i<totalGroups.size(); i++) {
			for(int j = i+1; j<totalGroups.size(); j++) {
				int size1 = totalGroups.get(i).size();
				int size2 = totalGroups.get(j).size();
				int pairs = size1 * size2;
				totalPairs = totalPairs+ pairs;
			}
		}
		System.out.println(totalPairs);
	}
	
	static void formPairs(ArrayList<Edge> graph[], int src, ArrayList<Integer> group, boolean[] checkVisited) {
		checkVisited[src] = true;
		group.add(src);
		
		for(Edge e: graph[src]) {
			if(checkVisited[e.nbr]==false) {
				formPairs(graph, e.nbr, group, checkVisited);
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
			 
		}
		
		totalPairOfFriends(graph, vertex);
		
	}

}
