package BinarySearch;

import java.util.Scanner;

public class Q02_search_on_reverse_sorted_array {
	// RETURN THE INDEX OF TARGET ELEMENT IN ARRAY WHICH IS REVERSLY SORTED; RETURN -1 if not present
	static int searchTarget(int[] arr, int target) {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(searchTarget(arr, target));
		sc.close();

	}
}
