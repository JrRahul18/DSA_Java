package DP;
import java.util.*;

public class q16_maxSumNonAdjacentElements {
	
	// PRINT MAX SUM OF ELEMENTS OF A SUBSEQUENCE WITH NO ADJACENT ELEMENTS
	static void maxSum(int[] elements) {
		int[] dp_included = new int[elements.length];
		int[] dp_excluded = new int[elements.length];
		
		dp_included[0] = elements[0];
		dp_excluded[0] = 0;
		
		for(int i = 1; i<dp_included.length; i++) {
			dp_included[i] = dp_excluded[i-1] + elements[i];
			dp_excluded[i] = Math.max(dp_included[i-1], dp_excluded[i-1]);
		}
		
		int max = Math.max(dp_included[elements.length-1], dp_excluded[elements.length-1]);
		System.out.println(max);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] elements = new int[n];
		for(int i = 0; i<n; i++) {
			elements[i]= sc.nextInt();
		}
		maxSum(elements);
		sc.close();
		
	}
	

}
