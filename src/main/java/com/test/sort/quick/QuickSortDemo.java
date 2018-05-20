package com.test.sort.quick;

public class QuickSortDemo {
	public static void quickSort(int arr[]) {
		quickSortHelper(arr, 0, arr.length - 1);
	}

	public static void quickSortHelper(int arr[], int first, int last) {
		if (first < last) {
			int splitpoint = partition(arr, first, last);
			quickSortHelper(arr, first, splitpoint - 1);
			quickSortHelper(arr, splitpoint + 1, last);
		}
	}

	public static int partition(int arr[], int first, int last) {
		int pivotvalue = arr[first];

		int leftmark = first + 1;
		int rightmark = last;

		while (true) {

			while (leftmark <= rightmark && arr[leftmark] <= pivotvalue) {
				leftmark = leftmark + 1;
			}

			while (arr[rightmark] >= pivotvalue && rightmark >= leftmark) {
				rightmark = rightmark - 1;
			}

			if (rightmark < leftmark) {
				break;
			} else {
				int temp = arr[leftmark];
				arr[leftmark] = arr[rightmark];
				arr[rightmark] = temp;
			}

		}
		int temp = arr[first];
		arr[first] = arr[rightmark];
		arr[rightmark] = temp;

		return rightmark;
	}

	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] alist = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
		System.out.println("Before sorting: ");
		display(alist);
		quickSort(alist);
		System.out.println("After quick sorting: ");
		display(alist);

	}

}
