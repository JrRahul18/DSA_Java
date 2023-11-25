package DP;
import java.util.*;

public class minimumSubsetSumDifference {
	//FIND 2 SUBSETS OF AN ARRAY IN WHICH THE DIFFERENCE BETWEEN THESUM OF TWO SUBSET IS MINIMUM AND RETURN THE DIFFERENCE
	static int minimumDifference(int[] valueArray) {
		if(valueArray.length == 1) {
			return valueArray[0];
		}
		int total = 0;
		for(int i = 0; i<valueArray.length; i++) {
			total +=valueArray[i];
		}
		
		int[][] dp = new int[valueArray.length + 1][total + 1];
		
		for(int i = 0; i<dp.length; i++) {
			for(int j = 0; j<dp[0].length; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 1;
				}
				else if(i == 0) {
					dp[i][j] = 0;
				}
				else if(j == 0) {
					dp[i][j] = 1;
				}
				else {
					int val = valueArray[i-1];
					if(val<=j) {
						int max = Math.max(dp[i - 1][j - val], dp[i - 1][j]);
						dp[i][j] = max;
					}
					else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		ArrayList<Integer> arl = new ArrayList<>();
		
		for(int i = 0; i <= (dp[0].length-1)/2; i++) {
			if(dp[valueArray.length][i] == 1) {
				arl.add(i);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<arl.size(); i++) {
			min = Math.min(min, total - 2 * arl.get(i));
		}
		return min;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] valueArray = new int[n];
		for(int i = 0; i< n; i++) {
			valueArray[i] = sc.nextInt();
		}
		int t =minimumDifference(valueArray);
		
		System.out.println(t);
		sc.close();
		
	}

}
