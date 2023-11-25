package DP;
import java.util.*;

public class q14_decodeWays {
	
	// COUNT TOTAL WAYS TO DECODE A STRING OF INTEGERS TO STRING OF ALPAHBETS TAKING VALUES OF LETTERS AS THIER COUNTING NUMBERS (Eg. 1-> a, 2->b, 3->c, ....)
	static void countDecode(String str) {
		int[] dp = new int[str.length()];
		dp[0] = 1;
		if(str.charAt(0) == '0'){
            dp[0] = 0;
        }
		
		for(int i =1; i<dp.length; i++) {
			if(str.charAt(i-1) == '0' && str.charAt(i) == '0') {
				dp[i]=0;
			}
			
			
			else if(str.charAt(i-1) == '0' && str.charAt(i) != 0) {
				dp[i] = dp[i-1];
			}
			
			
			else if(str.charAt(i-1) != '0' && str.charAt(i) == '0') {
				if(Integer.parseInt(str.substring(i-1, i+1)) <= 26 ) {
					if(i>=2) {
						dp[i] = dp[i-2];
					}
					else {
						dp[i] = 1;
					}
				}
				else {
					dp[i] = 0;
				}
			}
			
			
			else {
				if(Integer.parseInt(str.substring(i-1, i+1)) <= 26) {
					if(i>=2) {
						dp[i] = dp[i-1] + dp[i-2];
					}
					else {
						dp[i] = dp[i-1] + 1;
					}
				}
				else {
					dp[i] = dp[i-1];
				}
			}
		}
		System.out.println(dp[str.length()-1]);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		countDecode(str);
		sc.close();
		
	}

}
