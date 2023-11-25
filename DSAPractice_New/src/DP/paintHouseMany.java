package DP;
import java.util.*;

public class paintHouseMany {
	
	// PRINT MINIMUM COST TO PAINT h HOUSES FROM clr COLOUR SUCH THAT NO TWO CONSECUTIVE HOUSES ARE PAINTED WITH SAME COLOUR.
	static void printLeastCost(int[][] costOfPaint) {
		int[][] dp = new int[costOfPaint.length][costOfPaint[0].length];
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for(int i = 0; i<costOfPaint[0].length; i++) {
			dp[0][i] = costOfPaint[0][i];
			
			if(dp[0][i] <= min1) {
				min2 = min1;
				min1 = dp[0][i];
			}
			else if(dp[0][i] <= min2) {
				min2 = dp[0][i];
			}
		}
		
		for(int i = 1; i<costOfPaint.length; i++) {
			int m1 = Integer.MAX_VALUE;
			int m2 = Integer.MAX_VALUE;
			for(int j=0; j<costOfPaint[0].length; j++) {
				if(dp[i-1][j] != min1) {
					dp[i][j] = costOfPaint[i][j] + min1;
				}
				else {
					dp[i][j] = costOfPaint[i][j] + min2;
				}
				
				if(dp[i][j] <= m1) {
					m2 = m1;
					m1 = dp[i][j];
				}
				else if(dp[i][j] <= m2) {
					m2 = dp[i][j];
				}
			}
			min1 = m1;
			min2 = m2;
		}
		System.out.println(min1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int clr = sc.nextInt();
		int[][] costOfPaint = new int[h][clr];
		for(int i =0; i<h; i++) {
			for(int j =0; j<clr; j++) {
				costOfPaint[i][j] = sc.nextInt();
			}
		}
		printLeastCost(costOfPaint);
		sc.close();
	}
//	SAMPLE INPUT
//	4 6
//	1 5 7 2 1 4
//	5 8 4 3 6 1
//	3 2 9 7 2 3
//	1 2 4 9 1 7
//	OP= 5

}
