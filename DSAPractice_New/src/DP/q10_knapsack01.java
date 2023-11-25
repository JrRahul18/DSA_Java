package DP;
import java.util.*;

public class q10_knapsack01 {
	
	//FIND MAXIMUM VALUE SUCH THAT SUM OF WEIGHTS IS EQUAL(OR LESS) TO GIVEN TARGET WEIGHT. 
	static void knapsackMaxValue(int[] valueArray, int[] weightArray, int target) {
		int[][] dp = new int[weightArray.length+1][target+1];
		
		for(int i=1; i<dp.length; i++) {
			
			int weight = weightArray[i-1];
			int value = valueArray[i-1];
			
			for(int j=1; j<dp[0].length; j++) {
				
				dp[i][j] = dp[i-1][j];
				
				if(j>=weight) {
					
					int remainingWeight = j-weight;
					
					if(dp[i-1][remainingWeight] + value > dp[i-1][j]) {
						dp[i][j] = dp[i-1][remainingWeight] + value;
						
					}	
				}
			}
		}
		System.out.println(dp[weightArray.length][target]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] valueArray = new int[n];
		int [] weightArray = new int[n];
		
		for(int i = 0; i<n; i++) {
			valueArray[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++) {
			weightArray[i] = sc.nextInt();
		}
		int tWeight = sc.nextInt();
		knapsackMaxValue(valueArray, weightArray, tWeight);
		sc.close();
		
		
	}
	
//	5
//	14 30 45 10 15
//	5 4 3 1 2
//	7

}
