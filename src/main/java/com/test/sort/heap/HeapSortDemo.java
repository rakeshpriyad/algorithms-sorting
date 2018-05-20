package com.test.sort.heap;

import java.util.Arrays;

public class HeapSortDemo {

	public static void heapify(int arr[], int parentIndex, int size) {
		int leftChild = 2 * parentIndex + 1;
		int rightChild = 2 * parentIndex + 2;
		int max;
		if (leftChild <= size && arr[leftChild] > arr[parentIndex]) {
			max = leftChild;
		} else {
			max = parentIndex;
		}

		if (rightChild <= size && arr[rightChild] > arr[max]) {
			max = rightChild;
		}
		if (max != parentIndex) {
			swap(arr, parentIndex, max);
			heapify(arr, max, size);
		}
	}
	
	public static void buildheap(int arr[]) {
		int n = arr.length -1;
		for(int i = n/2; i>=0; i--) {
			heapify(arr, i, n);
		}
	}

	private static void swap(int[] arr, int parentIndex, int max) {
		int t = arr[max];
		arr[max] = arr[parentIndex];
		arr[parentIndex] = t;
	}
	
	public static int[] heapSort(int arr[]) {
		buildheap(arr);
		int heapSize = arr.length -1;
		for(int i = heapSize; i > 0; i--) {
			swap(arr,0, i);
			heapSize = heapSize -1;
			heapify(arr, 0, heapSize);
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 10, 16, 19, 3, 5 };
		System.out.println("Before Heap Sort : ");
		System.out.println(Arrays.toString(arr));
		arr = heapSort(arr);
		System.out.println("=====================");
		System.out.println("After Heap Sort : ");
		System.out.println(Arrays.toString(arr));
	}
}
