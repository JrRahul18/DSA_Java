package DP;
import java.util.*;

public class q07_targetSumSubsets {
	
	//CHECK WHETHER SUBSET OF SUM OF GIVEN NUMBER EXISTS OR NOT
	static void checkSubsets(int[] set, int check) {
		int[][] dp = new int[set.length+1][check+1];
		
		for(int i =0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = 0;
			}
		}
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if(i==0 && j==0) {
					dp[i][j] = 1;
				}
				else if(i==0) {
					dp[i][j] = 0;
				}
				else if(j==0) {
					dp[i][j] = 1;
				}
				else {
					if(dp[i-1][j] == 1) {
						dp[i][j] = 1;
					}
					else {
						int num = set[i-1];
						if(j>=num) {
							if(dp[i-1][j-num] == 1) {
								dp[i][j] = 1;
							}
						}
					}
				}
			}
		}
		if(dp[set.length][check] == 1) {
			System.out.println("Subset Exist");
		}
		else {
			System.out.println("Subset does not Exist");
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int check = sc.nextInt();
		checkSubsets(arr, check);
		sc.close();
		
	}
	
//	5
//	4 2 7 1 3
//	10
	
//	5
//	8 6 5 4 3
//	24

}
