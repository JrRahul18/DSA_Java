package BinarySearch;

import java.util.*;

public class Q05_count_of_element_in_array {
	//RETURN THE COUNT OF OCCURRENCE OF TARGET ELEMENT IN THE SORTED ARRAY
	static int countOccurenece(int[] arr, int target) {
		int finalAns = 0;
		int idx1 = -1;
		int idx2 = -1;

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				idx1 = mid;
				high = mid - 1;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		low = 0;
		high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				idx2 = mid;
				low = mid + 1;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if(idx1 ==-1 && idx2 == -1) {
			return 0;
		}
		finalAns = idx2-idx1+1;
		return finalAns;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(countOccurenece(arr, target));
		sc.close();

	}

}
