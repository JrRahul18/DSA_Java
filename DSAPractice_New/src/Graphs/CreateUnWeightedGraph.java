package Graphs;

import java.util.*;

public class CreateUnWeightedGraph {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();

		// adjacency matrix(unweighted Graph)
		int arr[][] = new int[v + 1][v + 1];
//		int arr2[] = new int[(int)1e8];

		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}

		// adjacency list(unweighted graph)
		ArrayList<Integer> graph[] = new ArrayList[v];
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1].add(v2);
			graph[v2].add(v1);
		}

	}

}
