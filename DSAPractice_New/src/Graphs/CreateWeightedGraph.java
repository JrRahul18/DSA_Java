package Graphs;

import java.util.*;

public class CreateWeightedGraph {
	
	static class Edge{
		int src, dst, weight;
		Edge(int src, int dst, int weight){
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}
		
	}
	// 1) TO CHECK THE PATH BETWEEN TWO EDGES
	static boolean hasPath(ArrayList<Edge> graph[], int src, int result, boolean IsVisited[]) {
		if(src==result) {
			return true;
		}
		IsVisited[src] = true;
		for (Edge edge: graph[src]) {
			if(IsVisited[edge.dst]== false) {
				boolean hasNbrPath = hasPath(graph, edge.dst, result, IsVisited);
				if(hasNbrPath==true) {
					return true;
				}
			}
		}
		return false;
	}
	
	// 2) TO PRINT THE PATH BETWEEN TWO EDGES
	static void printPath(ArrayList<Edge> graph[], int src, int result, boolean isVisited[], String path) {
		
		if(src == result) {
			System.out.println(path);
			return;
		}
		
		isVisited[src] = true;
		for(Edge edge : graph[src]) {
			if(isVisited[edge.dst] == false) {
				printPath(graph, edge.dst, result, isVisited, path+" " + edge.dst);
			}
		}
		isVisited[src] = false;
	}
	
	// 3) TO GET CONNECTED COMPONENTS OF A GRAPH IN A LIST (includes method addComponent)
	static void getConnectedComponents(ArrayList<Edge> graph[],int vertices) {
		ArrayList<ArrayList<Integer>> allConnectedComponentsList = new ArrayList<>();
		boolean[] visited = new boolean[vertices];
		
		for (int v = 0; v<vertices; v++) {
			if(visited[v]==false) {
				ArrayList<Integer> component = new ArrayList<>();
				addComponent(graph, v, component, visited);
				allConnectedComponentsList.add(component);
			}
		}
		System.out.println(allConnectedComponentsList);
	}
	static void addComponent(ArrayList<Edge> graph[], int src, ArrayList<Integer> component, boolean[]visited) {
		visited[src]= true;
		component.add(src);
		for (Edge e: graph[src]) {
			if(visited[e.dst] == false) {
				addComponent(graph, e.dst, component, visited);
			}
		}
	}
	
	// 4) TO GET TOTAL NUMBER OF ISLAND IN A MATRIX (includes method checkComponent)
	static void countIsland(int [][] arrayIsland) {
		int m = arrayIsland.length;
		int n = arrayIsland[0].length;
		boolean[][] checkVisited = new boolean[m][n];
		
		int countAllIsland = 0; 
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if (arrayIsland[i][j]==0 && checkVisited[i][j]==false) {
					checkComponent(arrayIsland, i, j, checkVisited);
					countAllIsland++;
				}
			}
		}
		System.out.println(countAllIsland);	
	}
	static void checkComponent(int[][] arrayIsland, int i, int j, boolean[][] checkVisited) {
		if(i<0 || j<0 || i>arrayIsland.length-1 || j>arrayIsland.length-1 || arrayIsland[i][j] == 1 || checkVisited[i][j] == true) {
			return;
		}
		checkVisited[i][j] = true;
		
		checkComponent(arrayIsland, i-1, j, checkVisited);
		checkComponent(arrayIsland, i, j+1, checkVisited);
		checkComponent(arrayIsland, i, j-1, checkVisited);
		checkComponent(arrayIsland, i+1, j, checkVisited);
	}
	
	
	static void dfs(ArrayList<Edge> graph[], int src, boolean[] isVisited) {
	
		System.out.println(src);
		isVisited[src] = true;
		for(Edge edge : graph[src]) {
			if(isVisited[edge.dst] == false) {
				dfs(graph, edge.dst, isVisited);
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		ArrayList<Edge> graph[] = new ArrayList[v];
		
		for(int i = 0; i < v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			graph[v1].add(new Edge(v1, v2, weight));
			graph[v2].add(new Edge(v2, v1, weight));
		}
		
		
		boolean isVisited[] = new boolean[v];
		
		System.out.println(hasPath(graph, 0, 6, isVisited));				//ANSWER 1)
		
//		printPath(graph, 0, 6, isVisited, 0+"");							//ANSWER 2)
		
		
//		getConnectedComponents(graph,v);									//ANSWER 3)
		
//		int [][] island = new int[][] {{0, 0, 1, 1, 1, 1, 1, 1 },
//										{0, 0, 1, 1, 1, 1, 1, 1},
//										{1, 1, 1, 1, 1, 1, 1, 0},
//										{1, 1, 0, 0, 0, 1, 1, 0},
//										{1, 1, 1, 1, 0, 1, 1 ,0},
//										{1, 1, 1, 1, 0, 1, 1, 0},
//										{1, 1, 1, 1, 1, 1, 1, 0},
//										{1, 1, 1, 1, 1, 1, 1, 0}};			//ANSWER 4)			
										
//		countIsland(island);												//ANSWER 4)
		
		
		
//		dfs(graph, 0, isVisited);

	}

}
