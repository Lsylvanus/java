package com.lsylvanus.util;

import java.util.ArrayList;
import java.util.List;

public class ExcludeUtil {

	/**
	 * 静态方法exclude
	 * @return	List<>
	 */
	public static List<Integer> exclude(List<Integer> list) {
		Integer[] arr = (Integer[]) list.toArray();
		List<Integer> newList = new ArrayList<>();
		// 遍歷傳入的數組arr
		for (int i = 0; i < arr.length; i++) {
			//如果数组 newList 不包含当前项，则增加该项到数组中
			if (!newList.contains(arr[i])) {
				newList.add(arr[i]);
			}
		}
		return newList;
	}
}
