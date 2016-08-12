package lsylvanus.collection_map.collection.p1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ArrayListTest {
	public static void main(String[] args) {
		// ArrayList,底层是一个数组,所以有元素有顺序,并且可以重复.
		ArrayList list1 = new ArrayList();
		System.out.println(list1);
		System.out.println(list1.size());

		list1.add(3);
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(null);
		list1.add(null);
		list1.add("abc");
		list1.add(new Date());
		list1.add(new int[] { 1, 2, 3 });
		System.out.println("list1: " + list1);
		list1.add(0, -10000);
		System.out.println("list1: " + list1);
		list1.remove(1);
		System.out.println("list1: " + list1);
		list1.remove(Integer.valueOf(2));// 删除在arrayList中首次出现的元素
		System.out.println("list1: " + list1);
		// remove(Object o)
		// int i =1;
		list1.remove(new Integer(1));
		// list1.remove(i);
		System.out.println("list1: " + list1);

		System.out.println();
		ArrayList list2 = new ArrayList();
		System.out.println("list2: " + list2);
		list2.addAll(list1);
		System.out.println("list2: " + list2);
		list2.addAll(5, list1);
		System.out.println("list2: " + list2);
		System.out.println(list2.get(4)); // 通过下标获取
		System.out.println(list2.indexOf(null)); // 首次出现的元素所在的下标
		System.out.println(list2.lastIndexOf(null)); // 最后出现的元素所在的下标
		list2.set(0, -234);
		System.out.println("list2: " + list2);

		Object[] objs = list2.toArray();
		System.out.println("array: " + (Arrays.toString(objs)));
		//list2.clear();
		System.out.println("list2: " + list2);

		// 有size(), 有index,就可以通过for循环遍历
		/*
		 * System.out.print("array：["); for (int i = 0; i < objs.length; i++) {
		 * System.out.print(objs[i] + ","); } System.out.print("]");
		 */

		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+",");
		}
		
		list2.clear();
	}
}
