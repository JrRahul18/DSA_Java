package DP;
import java.util.*;

public class q15_countSubsequences_A_B_C {
	//COUNT TOTAL SUBSEQUENCES OF TYPE A+,B+,C+
	static void countSubsequences(String str) {
		int a = 0;
		int ab = 0;
		int abc = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == 'a') {
				a = 2*a + 1;
			}
			else if(str.charAt(i) == 'b') {
				ab = 2*ab + a;
			}
			else if(str.charAt(i) == 'c') {
				abc = 2*abc + ab;
			}
		}
		System.out.println(abc);
		
	}
	// VIA DP ARRAY
	static void countSubsequences_1(String str) {
		int[] dp_a = new int[str.length() +1];
		int[] dp_b = new int[str.length() + 1];
		int[] dp_c = new int[str.length() +1];
		
		dp_a[0] = 0;
		dp_b[0] = 0;
		dp_c[0] = 0;
		
		for(int i = 0; i<str.length(); i++ ) {
			
			if(str.charAt(i) == 'a') {
				dp_a[i+1] = 2*dp_a[i] + 1;
				dp_b[i+1] = dp_b[i];
				dp_c[i+1] = dp_c[i];
			}
			else if(str.charAt(i) == 'b') {
				dp_b[i+1] = 2*dp_b[i] + dp_a[i];
				dp_a[i+1] = dp_a[i];
				dp_c[i+1] = dp_c[i];
			}
			else if(str.charAt(i) == 'c') {
				dp_c[i+1] = 2*dp_c[i] + dp_b[i];
				dp_a[i+1] = dp_a[i];
				dp_b[i+1] = dp_b[i];
				
			}
		}
		System.out.println(dp_c[str.length()]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
//		countSubsequences(str);
		countSubsequences_1(str);
		sc.close();
		
		
	}
}
