package Graphs;
import java.util.*;

public class spreadOfInfection {
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
		int timeOfInfected;
		
		Pair(int v, int timeOfInfected){
			this.v = v;
			this.timeOfInfected= timeOfInfected;
		}
	}
	
	//FIND HOW MANY NEIGBHOURS ARE INFECTED IN GIVEN TIME via BFS
	static void isInfected(ArrayList<Edge> [] graph, ArrayDeque<Pair> queue, int[] checkVisited, int initial, int time) {
		int pointer = 0;
		queue.add(new Pair(initial, 1));
		
		while(queue.size()>0) {
			Pair toBeRemoved = queue.removeFirst();
			if(checkVisited[toBeRemoved.v]>0) {
				continue;
			}
			checkVisited[toBeRemoved.v] = toBeRemoved.timeOfInfected;
			if(toBeRemoved.timeOfInfected > time) {
				break;
			}
			pointer++;
			
			for(Edge e: graph[toBeRemoved.v]) {
				if(checkVisited[e.nbr]==0) {
					queue.add(new Pair(e.nbr, toBeRemoved.timeOfInfected+1));
				}
			}
			
		}
		System.out.println("Total infected till time " + time +": " + pointer);
		
		
		
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
		int infected = sc.nextInt();
		int time = sc.nextInt();
		int[] checkVisited = new int[vertex];
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		isInfected(graph, queue, checkVisited, infected,time);
		
	}

}
