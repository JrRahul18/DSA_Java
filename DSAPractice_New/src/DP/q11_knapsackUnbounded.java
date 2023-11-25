package DP;
import java.util.*;

public class q11_knapsackUnbounded {
	
	// FIND MAXIMUM VALUE SUCH THAT SUM OF WEIGHTS IS EQUAL(OR LESS) TO GIVEN TARGET WEIGHT AND SAME VALUES CAN BE REPEATED AGAIN.
	static void knapsackUnboundedMax(int [] weightArray, int[] valueArray, int target) {
		int[] dp = new int[target+1];
		dp[0] = 0;
		
		for(int i=1; i<dp.length; i++) {
//			int checkValue = 0;
			for(int j = 0; j<weightArray.length; j++) {
				if(weightArray[j]<=i) {
					int remainingWeight = i - weightArray[j];
//					if(dp[remainingWeight] + valueArray[j] > checkValue) {
					if(dp[remainingWeight] + valueArray[j] > dp[i]) {
						dp[i] = dp[remainingWeight] + valueArray[j];
					}	
				}
			}
//			dp[i] = checkValue;
		}
		System.out.println(dp[target]);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] weightArray = new int[n];
		int[] valueArray = new int[n];
	
		for(int i=0; i<n; i++) {
			valueArray[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++) {
			weightArray[i] = sc.nextInt();
		}
		int tWeight = sc.nextInt();
		knapsackUnboundedMax(weightArray, valueArray, tWeight);
		sc.close();
	}
	
//	5
//	15 14 10 45 30
//	2 5 1 3 4
//	7
	
//	6
//	15 14 10 45 30 15
//	3 6 2 4 5 1
//	7

}
