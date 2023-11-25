package DP;
import java.util.*;

public class tilingWithMx1 {
	
	//FIND TOTAL WAYS TO TILE m*n AREA FROM TILE OF DIMENSION m*1
	static void totalWaysOfMx1Tiles(int n, int m) {
		int[] dp = new int[n+1];
		
		for(int i=1; i<dp.length; i++) {
			if(i < m) {
				dp[i] = 1;
			}
			else if(i == m) {
				dp[i] = 2;
			}
			else {
				dp[i] = dp[i-1] + dp[i-m];
			}
		}
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sizeOfTile = sc.nextInt();
		totalWaysOfMx1Tiles(n, sizeOfTile);
		sc.close();
	}

}
