package test_stu;

import org.junit.jupiter.api.Test;
import com.hanweb.common.util.JsonUtil;

//插入排序（性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序）
public class InsertSort {
	@Test
	public void insertSort() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		if (arr == null || arr.length < 2) {
			System.out.println("arr=" + JsonUtil.objectToString(arr));
		}
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int k = i - 1;
			while (k >= 0 && arr[k] > temp) {
				k--;
			}
			// 腾出位置插进去,要插的位置是k+1;
			for (int j = i; j > k + 1; j--) {
				arr[j] = arr[j - 1];
			}
			// 插进去
			arr[k + 1] = temp;
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}
}
