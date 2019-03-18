package test_stu;

import org.junit.jupiter.api.Test;
import com.hanweb.common.util.JsonUtil;

// 冒泡排序（优化）
public class BubbleSort2 {
	
	@Test
	public void bubbleSort() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		if (arr == null || arr.length < 2) {
			System.out.println("arr=" + JsonUtil.objectToString(arr));
		}
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					flag = false;
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
			// 一趟下来是否发生位置交换
			if (flag) {
				break;
			}
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}
}
