package BinarySearch;
import java.util.*;

public class Q01_BinarySearchImplementation {
	//RETURN TRUE IF TARGET ELEMENT EXIST ON SORTED ARRAY
	static boolean isPresent(int[] arr, int target) {
		boolean finalAns = false;
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid] == target) {
				finalAns = true;
				return finalAns;
			}
			else if(arr[mid]> target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
			
		}
		return finalAns;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(isPresent(arr, target));
		sc.close();
	}

}
