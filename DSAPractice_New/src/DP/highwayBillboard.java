package DP;
import java.util.*;

public class highwayBillboard {
	//FIND MAXIMUM EARNINGS EARNED THROUGH PLACING l BILLBOARDS AT GIVEN DISTANCES AND MONEY EARNED THROUGH EACH BILLBOARD
	//METHOD 1
	static void maximumEarning(int n, int[] distance, int[] price, int minDistance) {
		int[] dp = new int[price.length];
		dp[0] = price[0];
		
		for(int i = 1; i<dp.length; i++) {
			int maxEarning = 0;
			
			for(int j = 0; j < i; j++) {
				if(distance[i] - distance[j] > minDistance) {
					if(maxEarning < dp[j]) {
						maxEarning = dp[j];
					}
				}
			}
			dp[i] = maxEarning + price[i];
		}
		int maxCheck = 0;
		
		for(int i =0;i<dp.length;i++) {
			if(dp[i]>maxCheck) {
				maxCheck = dp[i];
			}
		}
		System.out.println(maxCheck);
	}
	//METHOD 2
	static void maximumEarning2(int n, int[] distance, int[] price, int minDistance) {
		int[] placeBillboard = new int[n + 1];
		Arrays.fill(placeBillboard, -1);
		for(int i =0; i<price.length; i++) {
			int index = distance[i];
			int val = price[i];
			placeBillboard[index] = val;
		}
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		
		for(int i = 1; i<dp.length; i++) {
			if(placeBillboard[i] == -1) {
				dp[i] = dp[i - 1];
			}
			else {
				int max1 = dp[i - 1];
				int max2 = placeBillboard[i];
				dp[i] = max1;
				if(i - minDistance - 1 >= 0) {
					max2 = placeBillboard[i] + dp[i - minDistance - 1];
				}
				int ans = Math.max(max1, max2);
				dp[i] = ans;
			}
		}
		System.out.println(dp[n]);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] distance = new int[l];
		for(int i =0; i<distance.length; i++) {
			distance[i] = sc.nextInt();
		}
		int[] price = new int[l];
		for(int i = 0;i<price.length; i++) {
			price[i] = sc.nextInt();
		}
		int minDistance = sc.nextInt();
		maximumEarning(n, distance, price, minDistance);
		maximumEarning2(n, distance, price, minDistance);
		sc.close();
	}
//	20
//	5
//	6 8 12 14 16
//	5 8 5 3 1
//	3
	
//	20
//	5
//	6 7 12 14 15
//	5 8 5 3 1
//	5
	
	
	
}
