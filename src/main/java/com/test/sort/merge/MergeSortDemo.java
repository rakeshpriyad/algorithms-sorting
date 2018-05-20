package com.test.sort.merge;

public class MergeSortDemo {
	static int arr[] = { 100, 20, 15, 30, 5, 75, 40 };

	public static void main(String[] args) {
		System.out.println("Before sorting");
		display(arr);
		mergeSort(0, arr.length - 1);
		System.out.println("After sorting");
		display(arr);
	}

	private static void mergeSort(int start, int end) {
		int mid = (start + end) / 2;
		if (start < end) {
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	private static void merge(int start, int mid, int end) {
		int[] tempArray = new int[arr.length];
		int tempArrayIndex = start;

		int firstArrIndex = start;
		int secondArrIndex = mid + 1;

		//// It will iterate until smaller list reaches to the end
		while (firstArrIndex <= mid && secondArrIndex <= end) {
			if (arr[firstArrIndex] < arr[secondArrIndex]) {
				tempArray[tempArrayIndex++] = arr[firstArrIndex++];
			} else {
				tempArray[tempArrayIndex++] = arr[secondArrIndex++];
			}
		}

		// copy remaing element from first arr
		while (firstArrIndex <= mid) {
			tempArray[tempArrayIndex++] = arr[firstArrIndex++];
		}

		// copy remaing element from second arr
		while (secondArrIndex <= end) {
			tempArray[tempArrayIndex++] = arr[secondArrIndex++];
		}

		// Copy tempArray to actual array after sorting
		for (int i = start; i <= end; i++) {
			arr[i] = tempArray[i];
		}
	}

	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
