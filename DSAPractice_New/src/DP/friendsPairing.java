package DP;
import java.util.*;

public class friendsPairing {
	
	//FIND TOTAL NUMBER OF WAYS TO PAIR n FRIENDS AND EACH FRIEND HAS 2 OPTION: REMAIN IN PAIR OR NOT.
	static void countTotalWaysToPair(int n) {
		int [] dp = new int[n + 1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i<dp.length; i++) {
			dp[i] = dp[i-1] + ((i-1) * dp[i-2]);
		}
		System.out.println(dp[n]);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int friends = sc.nextInt();
		countTotalWaysToPair(friends);
		sc.close();
	}

}
