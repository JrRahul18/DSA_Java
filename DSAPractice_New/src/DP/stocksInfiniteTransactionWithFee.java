package DP;
import java.util.*;

public class stocksInfiniteTransactionWithFee {
	
	//FIND MAXIMUM PROFIT FROM BUYING AND SELLING STOCK INFINITE TIMES WITH TRANSACTION FEE GIVEN PRICES OF STOCKS FOR n DAYS.
	static void maximumProfit(int[] prices, int fee){
		int buyingProfit = - prices[0];
		int sellingProfit = 0;
		
		int newBuyingProfit = 0;
		int newSellingProfit = 0;
		
		for(int i = 1; i<prices.length; i++) {
			
			if(sellingProfit - prices[i] > buyingProfit) {
				newBuyingProfit = sellingProfit - prices[i];
			}
			else {
				newBuyingProfit = buyingProfit;
			}
			
			if(prices[i] - fee + buyingProfit > sellingProfit) {
				newSellingProfit = prices[i] - fee + buyingProfit;
			}
			else {
				newSellingProfit = sellingProfit;
			}
			buyingProfit = newBuyingProfit;
			sellingProfit = newSellingProfit;
			
			newBuyingProfit = 0;
			newSellingProfit = 0;
		}
		System.out.println(sellingProfit);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices= new int[n];
		for(int i =0; i< prices.length; i++) {
			prices[i] = sc.nextInt();
		}
		int fee = sc.nextInt();
		maximumProfit(prices, fee);
		sc.close();
		
	}

}
