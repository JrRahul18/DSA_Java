package DP;
import java.util.*;

public class q08_coinChangeCombination {
	
	//FIND TOTAL COMBINATIONS TO PAY THE REQUIRED SUM
	static void getTotalCombination(int coinsArray[], int pay) {
		int[] dp = new int [pay+1];
		dp[0] = 1;
		
		for(int i = 0; i<coinsArray.length; i++) {
			int val = coinsArray[i];
			for(int j = val; j<dp.length; j++) {
				int count = dp[j-val];
				dp[j] += count;
			}
		}
		System.out.println(dp[pay]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coins = sc.nextInt();
		int[] coinsArray = new int[coins];
		for(int i = 0; i<coins; i++) {
			coinsArray[i] = sc.nextInt();
		}
		int pay = sc.nextInt();
		getTotalCombination(coinsArray, pay);
		sc.close();
		
	}
//	4
//	2 3 5 6
//	10
	
//	4
//	2 3 5 6
//	10

}
