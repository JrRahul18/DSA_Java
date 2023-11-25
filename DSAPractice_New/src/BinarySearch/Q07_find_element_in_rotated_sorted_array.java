package BinarySearch;
import java.util.*;

public class Q07_find_element_in_rotated_sorted_array {
	//FIND THE IINDEX OF TARGET ELEMENT IN THE ROTATED SORTED ARRAY> RETURN -1 IF NOT PRESENT.
	static int findElement(int[] arr, int target) {
		int finalAns = -1;
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid] == target) {
				finalAns = mid;
				return finalAns;
			}
			if(arr[low]<=arr[mid]) {
				if(arr[low]<=target && arr[mid]>= target) {
					high = mid-1;
				}
				else {
					low = mid+1;
				}
			}
			else {
				if(arr[mid]<= target && target<=arr[high]) {
					low = mid+1;
				}
				else {
					high = mid-1;
				}
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
		System.out.println(findElement(arr, target));
		sc.close();
		


	}

}
