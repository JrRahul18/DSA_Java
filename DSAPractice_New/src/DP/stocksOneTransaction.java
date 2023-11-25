package DP;
import java.util.*;

public class stocksOneTransaction {
	
	// FIND MAXIMUM PROFIT FROM BUYING AND SELLING STOCKS GIVEN PRICES OF STOCKS OF n DAYS
	static void maximumProfit(int[] prices) {
		int leastPrice = Integer.MAX_VALUE;
		int profit = 0;
		int maximumProfit = 0;
		
		for(int i = 0; i<prices.length; i++) {
			if(prices[i]<leastPrice) {
				leastPrice = prices[i];
			}
			
			profit = prices[i] - leastPrice;
			
			if(profit>maximumProfit) {
				maximumProfit = profit;
			}
		}
		System.out.println(maximumProfit);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n];
		for(int i = 0; i< n; i++) {
			prices[i] = sc.nextInt();
		}
		
		maximumProfit(prices);
		sc.close();
	}

}
