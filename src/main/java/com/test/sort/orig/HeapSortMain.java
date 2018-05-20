package com.test.sort.orig;

import java.util.*;

public class HeapSortMain {

	public static void buildheap(int[] arr) {

		/*
		 * As last non leaf node will be at (arr.length-1)/2 so we will start from this
		 * location for heapifying the elements
		 */
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
	}

	public static void heapify(int[] arr, int parentIndex, int size) {
		//Index of left child= 2*(index of its parent)+1
		int leftChild = 2 * parentIndex + 1;
		//Index of right child= 2*(index of its parent)+2
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
		// If max is not current node, exchange it with max of left and right child
		if (max != parentIndex) {
			swap(arr, parentIndex, max);
			heapify(arr, max, size);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static int[] heapSort(int[] arr) {

		buildheap(arr);
		int sizeOfHeap = arr.length - 1;
		for (int i = sizeOfHeap; i > 0; i--) {
			swap(arr, 0, i);
			sizeOfHeap = sizeOfHeap - 1;
			heapify(arr, 0, sizeOfHeap);
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