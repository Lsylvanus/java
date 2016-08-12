package lsylvanus.collection_map.collection.p3_iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class ForeachTest {

	public static void main(String[] args) {
		/*
		 * foreach���: ��ǿ��forѭ��. jdk5.0�Ƴ���������. ����������: array , list , set
		 * 
		 * ��ͨforѭ���ĸ�ʽ: for( ; ; ){
		 * 
		 * }
		 * 
		 * foreach�﷨��ʽ: for( : ){
		 * 
		 * } ˵��:ð������Ǳ���������(�����ı�������ÿ��ѭ��ʱ�洢��array,list,set�л�ȡ��һ������|ֵ),
		 * ð���ұ��Ǳ������Ķ���(array,list,set) foreach�����������array,list,set�е�ÿһ������|ֵ.
		 */
		int[] arr = new int[] { 2, 5, 5, 6, 7, 12, 20, 14 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\n------------------");

		for (int i : arr) {// ��plsql��ʹ��forloop�����α���﷨���� for er in emp_cursor
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

		// list,setͨ��foreach������, �ײ�Ĵ�����Ȼ����ͨforѭ�� + ��������ʵ�ֵ�.
		/*
		 * for( Object o : list){
		 * 	System.out.println(o);
		 * } 
		 * �����Ĵ���: 
		 * Object o; 
		 * for(Iterator iterator = list.iterator(); iterator.hasNext();
		 * System.out.println(o)) o = iterator.next();
		 */
	}
}
