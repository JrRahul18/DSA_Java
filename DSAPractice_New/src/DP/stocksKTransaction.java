package DP;
import java.util.*;

public class stocksKTransaction {
	
	//FIND MAXIMUM PROFIT FROM BUYING AND SELLING STOCK k TIMES GIVEN PRICES OF STOCKS FOR n DAYS.
	static void maximumProfit(int[] prices, int transactions) {	
		int [][] dp = new int[transactions + 1][prices.length];
		
		for(int i = 0; i<dp.length; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = 0; j<dp[0].length; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else {
					if(dp[i - 1][j - 1] - prices[j - 1] > max) {
						max = dp[i - 1][j - 1] - prices[j - 1];
					}
					int maxProfit = max + prices[j];
					if(maxProfit > dp[i][j - 1]) {
						dp[i][j]= maxProfit;
					}
					else {
						dp[i][j]= dp[i][j-1];
					}
				}
			}
		}
		System.out.println(dp[transactions][prices.length - 1]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n];
		for(int i =0 ; i<n; i++) {
			prices[i] = sc.nextInt();
		}
		int transactions = sc.nextInt();
		maximumProfit(prices, transactions);
		sc.close();
		
	}

}
