package DP;
import java.util.*;

public class q09_coinChangePermutation {
	
	//FIND TOTAL PERMUTATIONS TO PAY THE REQUIRED SUM
	static void getTotalPermutation(int[] coinArray, int pay) {
		int[] dp = new int[pay+1];
		dp[0] = 1;
		for(int i = 1; i<dp.length; i++) {
			for(int j = 0; j<coinArray.length; j++) {
				int val = coinArray[j];
				if(val <= i) {
					int sum = dp[i-val];
					dp[i]+=sum;
				}
			}
		}
		System.out.println(dp[pay]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coins = sc.nextInt();
		int[] coinArray = new int[coins];
		for(int i =0; i<coins; i++) {
			coinArray[i] = sc.nextInt();
		}
		int pay = sc.nextInt();
		getTotalPermutation(coinArray, pay);
		sc.close();
		
		
	}
	
//	3
//	2 3 5
//	7
	
//	4
//	2 3 5 6
//	10

}
