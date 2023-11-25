package DP;
import java.util.*;

public class stocksTwoTransactions {
	//FIND MAXIMUM PROFIT FROM BUYING AND SELLING STOCK 2 TIMES GIVEN PRICES OF STOCKS FOR n DAYS.
	static void maximumProfit(int[] prices) {
		
		int profit_buyingToday = 0;
		int leastPrice = prices[0];
		int[] dp_forward = new int[prices.length];
		
		for(int i = 1; i<prices.length; i++) {
			
			if(leastPrice > prices[i]) {
				leastPrice = prices[i];
			}
			profit_buyingToday = prices[i] - leastPrice;
			
			if(profit_buyingToday > dp_forward[i - 1]) {
				dp_forward[i] = profit_buyingToday;
			}
			else {
				dp_forward[i] = dp_forward[i - 1];
			}
		}
		
		// Traversing array backwards
		int profit_sellingToday = 0;
		int maximumPrice = prices[prices.length - 1];
		int[] dp_backward = new int[prices.length];
		
		for(int i = prices.length-2; i>=0; i--) {
			if(prices[i] > maximumPrice) {
				maximumPrice = prices[i];
			}
			profit_sellingToday = maximumPrice - prices[i];
			
			if(profit_sellingToday > dp_backward[i+1]) {
				dp_backward[i] = profit_sellingToday;
			}
			else {
				dp_backward[i] = dp_backward[i + 1];
			}
			
		}
		int maxProfit = 0;
		for(int i =0; i<dp_forward.length; i++) {
			if(dp_backward[i] + dp_forward[i] > maxProfit) {
				maxProfit = dp_backward[i] + dp_forward[i];
			}
		}
		System.out.println(maxProfit);
		
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n];
		for(int i =0; i<prices.length; i++) {
			prices[i] = sc.nextInt();
		}
		maximumProfit(prices);
		sc.close();
		
	}
//	19
//	30 40 43 50 45 20 26 40 80 50 30 15 10 20 40 45 71 50 55

}
