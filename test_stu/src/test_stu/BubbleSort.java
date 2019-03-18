package test_stu;

import org.junit.jupiter.api.Test;
import com.hanweb.common.util.JsonUtil;

//冒泡排序（性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序）
public class BubbleSort {
	@Test
	public void bubbleSort() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		if (arr == null || arr.length < 2) {
			System.out.println("arr=" + JsonUtil.objectToString(arr));
		}
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}
}
