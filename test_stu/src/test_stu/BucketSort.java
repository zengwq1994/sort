package test_stu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import com.hanweb.common.util.JsonUtil;

//桶排序（性质：1、时间复杂度：O(n+k) 2、空间复杂度：O(n+k) 3、稳定排序 4、非原地排序 注：k 表示桶的个数）
public class BucketSort {
	@Test
	public void bucketSort() {
		int[] arr = { 11, 21, 32, 3, 4, 5, 6, 74, 3, 2, 2, 13, 4, 55, 54543, 6, 6, 7, 78, 444, 54, 3, 3, 3 };
		if (arr == null || arr.length < 2) {
			System.out.println("arr=" + JsonUtil.objectToString(arr));
		}
		int n = arr.length;
		int max = arr[0];
		int min = arr[0];
		// 寻找数组的最大值与最小值
		for (int i = 1; i < n; i++) {
			if (min > arr[i])
				min = arr[i];
			if (max < arr[i])
				max = arr[i];
		}
		// 和优化版本的计数排序一样，弄一个大小为min的偏移值
		int d = max - min;
		// 创建d/5+1个桶，第i桶存放5*i~5*i+5-1范围的数
		int bucketNum = d / 5 + 1;
		ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(bucketNum);
		// 初始化桶
		for (int i = 0; i < bucketNum; i++) {
			bucketList.add(new LinkedList<Integer>());
		}
		// 遍历原数组，将每个元素放入桶中
		for (int i = 0; i < n; i++) {
			bucketList.get((arr[i] - min) / d).add(arr[i] - min);
		}
		// 对桶内的元素进行排序，我这里采用系统自带的排序工具
		for (int i = 0; i < bucketNum; i++) {
			Collections.sort(bucketList.get(i));
		}
		// 把每个桶排序好的数据进行合并汇总放回原数组
		int k = 0;
		for (int i = 0; i < bucketNum; i++) {
			for (Integer t : bucketList.get(i)) {
				arr[k++] = t + min;
			}
		}
		System.out.println("arr=" + JsonUtil.objectToString(arr));
	}
}
