package BinarySearch;
import java.util.*;

public class Q03_order_not_known_search {
	//RETURN INDEX OF TARGET ELEMENT IN ARRAY WHOSE SORT DIRECTION IS NOT KNOWN; RETURN -1 IF NOT PRESENT
	static int ascendingSorted(int[] arr, int target) {
		int finalAns = -1;
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid] == target) {
				return mid;
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
	static int descendingSorted(int[] arr, int target) {
		int finalAns = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				low = mid + 1;

			} else {
				high = mid - 1;
			}

		}
		return finalAns;
	}
	static int solve(int arr[] , int target) {
		int finalAns = -1;
		int start = 0;
		int end = arr.length-1;
		if(arr[start]<=arr[end]) {
			finalAns = ascendingSorted(arr, target);
		}
		else {
			finalAns= descendingSorted(arr, target);
		}
		return finalAns;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(solve(arr, target));
		sc.close();

	}

}
