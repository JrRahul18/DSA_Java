package DP;
import java.util.*;

public class q13_countArrangedBuidings {
	
	// COUNT TOTAL ARRANGEMENTS OF BUILDINGS AND SPACE UNDER n PLOTS SUCH THAT NO 2 BUILDINGS OCCURS CONSECUTIVELY.
	static void arrangeBuildings(long n) {
		int num = (int)n;
		long[] dpSpace = new long[num + 1];
		long[] dpBuilding = new long[num + 1];
		
		dpSpace[1] = 1;
		dpBuilding[1] = 1;
		
		for(int i = 2; i<dpSpace.length; i++) {
			dpBuilding[i] = dpSpace[i-1];
			dpSpace[i] = dpSpace[i-1] + dpBuilding[i-1];
		}
		
		long count = dpSpace[num] + dpBuilding[num];
		count = count * count;
		System.out.println(count);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		arrangeBuildings(n);
		sc.close();
		
	}

}
