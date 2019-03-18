package test_stu;

import org.junit.jupiter.api.Test;

import com.hanweb.common.util.JsonUtil;

//计数排序（性质：1、时间复杂度：O(n+k) 2、空间复杂度：O(k) 3、稳定排序 4、非原地排序）
public class CountSort {
	@Test
	public void countSort() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		if (arr == null || arr.length < 2) {
			System.out.println("arr=" + JsonUtil.objectToString(arr));
		}
		int n = arr.length;
		int max = arr[0];
		// 寻找数组的最大值
		for (int i = 1; i < n; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		// 创建大小为max的临时数组
		int[] temp = new int[max + 1];
		// 统计元素i出现的次数
		for (int i = 0; i < n; i++) {
			temp[arr[i]]++;
		}
		int k = 0;
		// 把临时数组统计好的数据汇总到原数组
		for (int i = 0; i <= max; i++) {
			for (int j = temp[i]; j > 0; j--) {
				arr[k++] = i;
			}
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}
}
