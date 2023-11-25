package DP;
import java.util.*;

public class q01_fibonacci {
	
	// FIBONACCI USING MEMOIZATION  
	static int getFibonacci(int n, int[] track) {
		//BASE CASE
		if(n==0 || n==1) {
			return n;
		}
		if(track[n] !=0) {
			return track[n];
		}
		
		int n1 = getFibonacci(n-1, track);
		int n2 = getFibonacci(n-2, track);
		
		int sum = n1 + n2;
		track[n] = sum;
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] track = new int[num+1];
		System.out.println(getFibonacci(num, track));
		sc.close();
		
	}

}
