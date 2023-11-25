package DP;
import java.util.*;

public class partitionIntoSubsets {
	//COUNT TOTAL WAYS TO FORM t TEAMS WITH n PLAYERS.
	static void totalTeams(int players, int teams) {
		long [][] dp = new long[teams+1][players+1];
		
		for(int i =0; i<dp.length; i++) {
			for(int j =0; j<dp[0].length; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(i>j) {
					dp[i][j] = 0;
				}
				else if(i==j) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = (dp[i][j-1] * i) + dp[i-1][j-1];
				}	
			}
		}
		System.out.println(dp[teams][players]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int teams = sc.nextInt();
		totalTeams(n, teams);
		sc.close();
		
	}

}
