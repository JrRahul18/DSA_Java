package DP;
import java.util.*;

public class paintFence {
	
	//FIND TOTAL WAYS TO PAINT n FENCES WITH c COLOR SUCH THAT NO MORE THAN TWO COLORS OCCUR CONSECUTIVELY.
	static void totalWays(int n, int c) {
		
		long samePaint = c * 1;
		long differentPaint = c * (c-1);
		long total = samePaint + differentPaint;
		for(int i = 2; i<n; i++) {
			samePaint = differentPaint;
			differentPaint = total * (c - 1);
			total = samePaint + differentPaint;
		}
		
		System.out.println(total);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fence = sc.nextInt();
		int clr = sc.nextInt();
		totalWays(fence, clr);
		sc.close();
		
	}

}
