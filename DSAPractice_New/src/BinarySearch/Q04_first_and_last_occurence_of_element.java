package BinarySearch;

import java.util.*;

public class Q04_first_and_last_occurence_of_element {
	// RETURN INDEX OF FIRST AND LAST OCCURENCE OF TARGET ELEMENT IN SORTED ARRAY

	static int[] searchOccurence(int[] arr, int target) {
		int[] finalAns = new int[2];
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
		finalAns[0] = idx1;
		finalAns[1] = idx2;
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
		int[] ans = searchOccurence(arr, target);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		sc.close();

	}

}
