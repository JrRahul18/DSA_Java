package DP;
import java.util.*;

public class q06_goldmineProblem {
	
	// COLLECT MAXIMUM GOLD FROM PATH FROM LEFT COLUMN TO RIGHT COLUMN MOVING DIAGONALLY UPWARD & DOWNWARD AND HORIZONTAL. 
	static void maximumGoldPath(int[][] goldmine) {
		int r = goldmine.length;
		int c = goldmine[0].length;
		int[][] dp = new int[r][c];
		
		for(int j = c-1; j>=0; j--) {
			for(int i = r-1; i>=0; i--) {
				if(j == c-1) {
					dp[i][j] = goldmine[i][j];
				}
				else if (r == 1 && c != 1) {
					dp[i][j] = dp[i][j+1] + goldmine[i][j];
				}
				else if(i == r-1) {
					int max = Math.max(dp[i][j+1], dp[i-1][j+1]);
					dp[i][j] = max + goldmine[i][j];
				}
				else if(i == 0) {
					int max = Math.max(dp[i][j+1], dp[i+1][j+1]);
					dp[i][j] = max + goldmine[i][j];
				}
				else {
					int check = Math.max(dp[i-1][j+1], dp[i+1][j+1]);
					int max = Math.max(dp[i][j+1], check);
					dp[i][j] = max + goldmine[i][j];
					
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<r; i++) {
			if(dp[i][0] > max) {
				max = dp[i][0];
			}
		}
		System.out.println(max);
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] goldmine = new int[row][col];
		for(int i =0; i<row; i++) {
			for(int j =0; j<col; j++) {
				goldmine[i][j] = sc.nextInt();
				
			}
		}
		maximumGoldPath(goldmine);
		sc.close();
		
		
	}

}
