package BinarySearch;

import java.util.*;

public class Q06_rotate_sorted_array {
	//RETURN HOW MANY TIMES THE SORTED ARRAY IS ROTATED
	static int countRotationOfArray(int[] nums) {
		int finalAns = Integer.MAX_VALUE;
		int idx = 0;

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[low] <= nums[high]) {
				finalAns = Math.min(finalAns, nums[low]);
				if (finalAns == nums[low]) {
					idx = low;
				}
				return finalAns;
			}
			if (nums[low] <= nums[mid]) {
				finalAns = Math.min(finalAns, nums[low]);
				if (finalAns == nums[low]) {
					idx = low;
				}
				low = mid + 1;
			} else {
				finalAns = Math.min(finalAns, nums[mid]);
				if (finalAns == nums[mid]) {
					idx = mid;
				}
				high = mid - 1;
			}

		}
		System.out.println(idx);
//		return idx;
		return finalAns;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(countRotationOfArray(arr));

	}

}
