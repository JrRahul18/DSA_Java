package DP;
import java.util.*;

public class paintHouse {
	
	//FIND MINIMUM COST TO PAINT n HOUSES SUCH THAT NO TWO CONSECUTIVE HOUSES ARE PAINTED WITH SAME COLOUR
	static void minCost(int[][] costOfPaint) {
		long[][]dp = new long[costOfPaint.length][costOfPaint[0].length];
		
		
		for(int i = 0; i<dp.length; i++) {
			if(i==0) {
				dp[i][0] = costOfPaint[i][0];
				dp[i][1] = costOfPaint[i][1];
				dp[i][2] = costOfPaint[i][2];
			}
			else {
				dp[i][0] = costOfPaint[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = costOfPaint[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = costOfPaint[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
		}
		long min1 = Math.min(dp[dp.length-1][0], dp[dp.length-1][1]);
		long min = Math.min(min1, dp[dp.length-1][2]);
		System.out.println(min);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int clr = 3;
		int[][] costOfPaint = new int[n][clr];
		for(int i =0; i<n; i++) {
			for(int j=0; j<clr; j++) {
				costOfPaint[i][j] = sc.nextInt();
			}
		}
		minCost(costOfPaint);
		sc.close();
		
	}

}
