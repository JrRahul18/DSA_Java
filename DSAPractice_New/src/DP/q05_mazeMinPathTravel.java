package DP;
import java.util.*;

public class q05_mazeMinPathTravel {
	
	//FIND THE MINIMUM COST TO REACH THE BOTTOM-RIGHT OF MAZE FROM TOP-LEFT
	static void minimumCostPath(int[][] maze) {
		int p = maze.length;
		int q = maze[0].length;
		int[][] dp = new int[p][q];
		
		for(int i = p-1; i>=0; i--) {
			for(int j = q-1; j>=0; j--) {
				if(i == p-1 && j == q-1) {
					dp[i][j] = maze[i][j];
				}
				else if(i == p-1) {
					dp[i][j] = dp[i][j+1] + maze[i][j];
				}
				else if(j == q-1) {
					dp[i][j] = dp[i+1][j] + maze[i][j];
				}
				else {
					int min = Math.min(dp[i+1][j], dp[i][j+1]);
					dp[i][j] = min + maze[i][j];
				}
			}
		}
		System.out.println(dp[0][0]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int[][] maze = new int[n1][n2];
		
		for(int i=0; i<maze.length;i++) {
			for(int j =0; j<maze.length; j++) {
				maze[i][j] = sc.nextInt();
			}
		}
		minimumCostPath(maze);
		sc.close();
	}
//	INPUT
//	7 7
//	2 8 4 1 6 4 2
//	6 0 9 5 3 8 5
//	1 4 3 4 0 6 5
//	6 4 7 2 4 6 1
//	1 0 3 7 1 2 7
//	1 5 3 2 3 0 9
//	2 2 5 1 9 8 2

}
