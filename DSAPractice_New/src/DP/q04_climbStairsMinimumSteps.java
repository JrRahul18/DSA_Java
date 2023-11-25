package DP;
import java.util.*;


public class q04_climbStairsMinimumSteps {
	
	//REACH n STAIRS WITH MINIMUM STEPS
	static void getMinimumSteps(int n, int[] jumps) {
		Integer[] dp = new Integer[n+1];
		dp[n] = 0;
		
		for(int i=n-1; i>=0; i--) {
			
			if(jumps[i] > 0) {
				int checkMin = Integer.MAX_VALUE;
				
				for(int j=1; j<=jumps[i]; j++) {	
					
					if((i+j) < dp.length && dp[i+j] != null) {
						int val = dp[i+j];
						checkMin = Math.min(checkMin, val);
						dp[i] = checkMin+1;
					}
				}
				// MinimumValue already added above while comparing
//				if(checkMin!= Integer.MAX_VALUE) { 
//					dp[i] = checkMin+1;
//				}
			}
		}
		System.out.println(dp[0]);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairs = sc.nextInt();
		int [] jumps = new int[stairs];
		for(int i = 0; i<jumps.length; i++) {
			jumps[i] = sc.nextInt();
		}
		getMinimumSteps(stairs, jumps);
		sc.close();
	}
//	10
//	3 2 4 2 0 2 3 1 2 2

}
