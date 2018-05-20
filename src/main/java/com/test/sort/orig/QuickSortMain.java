package com.test.sort.orig;

import java.util.Arrays;

public class QuickSortMain {

	private static int array[];

	public static void sort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		array = arr;
		quickSort(0, array.length - 1);
	}

	private static void quickSort(int leftmarker, int rightmarker) {

		int i = leftmarker;
		int j = rightmarker;
		// take the first element as pivot
		int pivot = array[leftmarker];

		while (i <= j) {
			/**
			 * In each iteration, we will increment left until we find element greater than
			 * pivot We will decrement right until we find element less than pivot
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (leftmarker < j)
			quickSort(leftmarker, j);
		if (i < rightmarker)
			quickSort(i, rightmarker);
	}

	private static void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String a[]) {
		int[] input = { 33, 21, 45, 64, 55, 34, 11, 8, 3, 5, 1 };
		System.out.println("Before Sorting : ");
		System.out.println(Arrays.toString(input));
		sort(input);
		System.out.println("==================");
		System.out.println("After Sorting : ");
		System.out.println(Arrays.toString(array));

	}
}