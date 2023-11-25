package DP;
import java.util.*;

public class q02_climbStairs {
	
	//COUNT TOTAL METHODS TO REACH n STAIRS BY MEMOIZAION AND TABULATION(YOU CAN JUMP 1, 2 AND 3 STEPS)
	static int countMethodsMemoization(int n, int[] arr) {
		
		//BASE CASE
		if(n==0) {
			return 1;
		}
		if(n == -1 || n == -2) {
			return 0;
		}
		if(arr[n]>0) {
			return arr[n];
		}
		
		int a1 = countMethodsMemoization(n-1, arr);
		int a2 = countMethodsMemoization(n-2, arr);
		int a3 = countMethodsMemoization(n-3, arr);
		
		int sum = a1 + a2 + a3;
		arr[n] = sum;
		return sum;
	}
	
	static int countMethodsTabulation(int n) {
		int[] tabulation = new int[n+1];
		tabulation[0] = 1;
		
		for(int i =1; i<=n; i++) {
			if(i==1) {
				tabulation[i] = tabulation[i-1];
			}
			else if(i==2) {
				tabulation[i] = tabulation[i-1] + tabulation[i-2];
			}
			else {
				tabulation[i] = tabulation[i-1] + tabulation[i-2] + tabulation[i-3];
			}
		}
		return tabulation[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairs = sc.nextInt();
		int[] memoization = new int[stairs+1];
		System.out.println(countMethodsMemoization(stairs, memoization));
		System.out.println(countMethodsTabulation(stairs));
		sc.close();
	}

}
