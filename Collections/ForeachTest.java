package lsylvanus.collection_map.collection.p3_iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class ForeachTest {

	public static void main(String[] args) {
		/*
		 * foreach语句: 增强型for循环. jdk5.0推出的新特性. 可用来遍历: array , list , set
		 * 
		 * 普通for循环的格式: for( ; ; ){
		 * 
		 * }
		 * 
		 * foreach语法格式: for( : ){
		 * 
		 * } 说明:冒号左边是变量声明区(声明的变量用于每次循环时存储从array,list,set中获取的一个对象|值),
		 * 冒号右边是被遍历的对象(array,list,set) foreach语句用来遍历array,list,set中的每一个对象|值.
		 */
		int[] arr = new int[] { 2, 5, 5, 6, 7, 12, 20, 14 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\n------------------");

		for (int i : arr) {// 和plsql中使用forloop遍历游标的语法很像 for er in emp_cursor
							// loop ... end loop;
			System.out.print(i + " ");
		}

		System.out.println("\n------------------\n");

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(2);
		arrayList.add(6);
		arrayList.add(5);
		System.out.println(arrayList);

		for (Integer integer : arrayList) {
			System.out.print(integer + " ");
		}

		System.out.println();
		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(122);
		hashSet.add('b');
		hashSet.add("lsylvanus");
		hashSet.add(new Date());
		for (Object object : hashSet) {
			System.out.print(object + ",");
		}

		System.out.println();
		for (Iterator iterator = hashSet.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object + ",");
		}

		// list,set通过foreach语句遍历, 底层的代码依然是普通for循环 + 迭代器来实现的.
		/*
		 * for( Object o : list){
		 * 	System.out.println(o);
		 * } 
		 * 编译后的代码: 
		 * Object o; 
		 * for(Iterator iterator = list.iterator(); iterator.hasNext();
		 * System.out.println(o)) o = iterator.next();
		 */
	}
}
