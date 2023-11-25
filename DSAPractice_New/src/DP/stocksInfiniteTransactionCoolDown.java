package DP;
import java.util.*;

public class stocksInfiniteTransactionCoolDown {
	
	//FIND MAXIMUM PROFIT FROM BUYING AND SELLING STOCK INFINITE TIMES WITH COOL DOWN TIME GIVEN PRICES OF STOCKS FOR n DAYS.
	static void maximumProfit(int[] prices) {
		int oldBuyingProfit = -prices[0];
		int oldSellingProfit = 0;
		int oldCoolingProfit = 0;
		
		int newBuyingProfit = 0;
		int newSellingProfit = 0;
		int newCoolingProfit = 0;
		
		for(int i = 1; i<prices.length; i++) {
			if(oldCoolingProfit - prices[i] > oldBuyingProfit) {
				newBuyingProfit = oldCoolingProfit - prices[i];
			}
			else {
				newBuyingProfit = oldBuyingProfit;
			}
			
			if(oldBuyingProfit + prices[i] > oldSellingProfit) {
				newSellingProfit = oldBuyingProfit + prices[i];
			}
			else {
				newSellingProfit = oldSellingProfit;
			}
			
			if(oldSellingProfit > oldCoolingProfit) {
				newCoolingProfit = oldSellingProfit;
			}
			else {
				newCoolingProfit = oldCoolingProfit;
			}
			
			oldBuyingProfit = newBuyingProfit;
			oldSellingProfit = newSellingProfit;
			oldCoolingProfit = newCoolingProfit;
			
			newBuyingProfit = 0;
			newSellingProfit = 0;
			newCoolingProfit = 0;
		}
		System.out.println(oldSellingProfit);
		
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
