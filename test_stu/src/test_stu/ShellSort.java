package test_stu;

import org.junit.jupiter.api.Test;
import com.hanweb.common.util.JsonUtil;

//希尔排序（性质：1、时间复杂度：O(nlogn) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序）
public class ShellSort {
	@Test
	public void shellSort() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		if (arr == null || arr.length < 2)
			System.out.println("arr=" + JsonUtil.objectToString(arr));
		int n = arr.length;
		// 对每组间隔为h的分组进行排序，刚开始h=n/2;
		for (int h = n / 2; h > 0; h /= 2) {
			// 对各个局部分组进行插入排序
			for (int i = h; i < n; i++) {
				// 将arr[i]插入到所在分组的正确位置上
				insertI(arr, h, i);
			}
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}

	/**
	 * 将arr[i]插入到所在分组的正确位置上 arr[i]]所在的分组为...arr[i-2*h],arr[i-h],arr[i+h]...
	 */
	private static void insertI(int[] arr, int h, int i) {
		int temp = arr[i];
		int k;
		for (k = i - h; k > 0 && temp < arr[k]; k -= h) {
			arr[k + h] = arr[k];
		}
		arr[k + h] = temp;
	}
}
