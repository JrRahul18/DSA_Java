package DP;
import java.util.*;

public class q12_countBinaryStrings {
	
	//COUNT TOTAL BINARY STRINGS OF SIZE n SUCH THAT NO 0 OCCURS CONSECUTIVELY.
	static void printAllStrings(int n) {
		int[] dp0 = new int[n+1];
		int[] dp1 = new int[n+1];
		
		
		dp0[1] = 1;
		dp1[1] = 1;
		for(int i =2; i<dp0.length; i++) {
			dp0[i] = dp1[i-1];
			dp1[i] = dp0[i-1] + dp1[i-1];
		}
		int count = dp0[n] + dp1[n];
		System.out.println(count);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printAllStrings(n);
		sc.close();
		
		
	}

}
