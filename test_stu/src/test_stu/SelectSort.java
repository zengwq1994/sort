package test_stu;

import org.junit.jupiter.api.Test;
import com.hanweb.common.util.JsonUtil;

//选择排序（性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序）
public class SelectSort {
	@Test
	public void test() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[min] > arr[j])
					min = j;
			}
			// 交换
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}
}