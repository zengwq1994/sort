package test_stu;

import org.junit.jupiter.api.Test;

//归并排序（性质：1、时间复杂度：O(nlogn) 2、空间复杂度：O(n) 3、稳定排序 4、非原地排序）
public class MergeSort {
	@Test
	public static int[] mergeSort(int[] arr, int left, int right) {
		// 如果left==right，表示数组只有一个元素，则不用递归排序
		if (left < right) {
			// 把大的数组分隔成两个数组
			int mid = (left + right) / 2;
			// 对左半部分进行排序
			arr = mergeSort(arr, left, mid);
			// 对右半部分进行排序
			arr = mergeSort(arr, mid + 1, right);
			// 进行合并
			merge(arr, left, mid, right);
		}
		return arr;
	}

	// 合并函数，把两个有序的数组合并起来
	// arr[left..mif]表示一个数组，arr[mid+1..right]表示一个数组
	private static void merge(int[] arr, int left, int mid, int right) {
		// 先用一个临时数组把他们合并汇总起来
		int[] a = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				a[k++] = arr[i++];
			} else {
				a[k++] = arr[j++];
			}
		}
		while (i <= mid)
			a[k++] = arr[i++];
		while (j <= right)
			a[k++] = arr[j++];
		// 把临时数组复制到原数组
		for (i = 0; i < k; i++) {
			arr[left++] = a[i];
		}
	}
}
