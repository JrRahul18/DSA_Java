package DP;
import java.util.*;

public class q03_climbStairsWithJumps {
	
	//COUNT TOTAL METHODS TO REACH n STAIRS GIVEN MAX JUMPS IN EACH STAIR
	static int climbValueStairs(int n, int[] jumps) {
		int[] dp = new int[n+1];
		dp[n] = 1;
		
		for(int i = n-1; i>=0; i--) {
			for(int j = 1; j<=jumps[i]; j++) {
				if(i+j<dp.length) {
					dp[i]+=dp[i+j];
				}else {
					break;
				}
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairs = sc.nextInt();
		int [] jumps = new int[stairs];
		for(int i =0; i<jumps.length; i++) {
			jumps[i] = sc.nextInt();
		}
		System.out.println(climbValueStairs(stairs, jumps));
		sc.close();
	}

}
