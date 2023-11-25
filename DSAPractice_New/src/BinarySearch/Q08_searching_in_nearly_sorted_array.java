package BinarySearch;

import java.util.*;

public class Q08_searching_in_nearly_sorted_array {
	//RETURN THE INDEX OF TARGET IN ARRAY WHICH IS NEARLY SORTED AND ONE ELEMENT IS SWAPPED WITH ITS NEIGHBOUR
	static int searchElement(int[] arr, int target) {
		int finalAns = -1;
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low + high)/2;
			if(arr[mid] == target) {
				return mid;
			}
			if(mid+1<arr.length) {
				if(arr[mid+1]== target) {
					return mid+1;
				}
			}
			if(mid-1>=0) {
				if(arr[mid-1] == target) {
					return mid-1;
				}
			}
			if(target<= arr[mid]) {
				high = mid-2;
			}
			else {
				low = mid+2;
			}
		}
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
		System.out.println(searchElement(arr, target));
		sc.close();

	}

}
