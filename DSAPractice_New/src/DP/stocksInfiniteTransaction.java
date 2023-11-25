package DP;
import java.util.*;

public class stocksInfiniteTransaction {
	//FIND MAXIMUM PROFIT FROM BUYING AND SELLING STOCK INFINITE TIMES GIVEN PRICES OF STOCKS FOR n DAYS.
	static void maximumProfit(int[] prices) {
		int buy = 0;
		int sell = 0;
		int totalProfit = 0;
		
		for(int i = 1; i<prices.length; i++) {
			if(prices[i]>= prices[i-1]) {
				sell++;
			}
			else {
				int profit = prices[sell] - prices[buy];
				totalProfit+=profit;
				buy = sell = i;
			}
		}
		int profit = prices[sell] - prices[buy];
		totalProfit+=profit;
		
		System.out.println(totalProfit);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n];
		for(int i = 0; i<prices.length; i++) {
			prices[i] = sc.nextInt();	
		}
		maximumProfit(prices);
		sc.close();
	}

}
