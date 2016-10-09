package com.lsylvanus.util;

import java.util.ArrayList;
import java.util.List;

public class ExcludeUtil {

	/**
	 * ��̬����exclude
	 * @return	List<>
	 */
	public static List<Integer> exclude(List<Integer> list) {
		Integer[] arr = (Integer[]) list.toArray();
		List<Integer> newList = new ArrayList<>();
		// ��v����Ĕ��Marr
		for (int i = 0; i < arr.length; i++) {
			//������� newList ��������ǰ������Ӹ��������
			if (!newList.contains(arr[i])) {
				newList.add(arr[i]);
			}
		}
		return newList;
	}
}
