package lsylvanus.collection_map.collection.p1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ArrayListTest {
	public static void main(String[] args) {
		// ArrayList,�ײ���һ������,������Ԫ����˳��,���ҿ����ظ�.
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
		list1.remove(Integer.valueOf(2));// ɾ����arrayList���״γ��ֵ�Ԫ��
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
		System.out.println(list2.get(4)); // ͨ���±��ȡ
		System.out.println(list2.indexOf(null)); // �״γ��ֵ�Ԫ�����ڵ��±�
		System.out.println(list2.lastIndexOf(null)); // �����ֵ�Ԫ�����ڵ��±�
		list2.set(0, -234);
		System.out.println("list2: " + list2);

		Object[] objs = list2.toArray();
		System.out.println("array: " + (Arrays.toString(objs)));
		//list2.clear();
		System.out.println("list2: " + list2);

		// ��size(), ��index,�Ϳ���ͨ��forѭ������
		/*
		 * System.out.print("array��["); for (int i = 0; i < objs.length; i++) {
		 * System.out.print(objs[i] + ","); } System.out.print("]");
		 */

		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+",");
		}
		
		list2.clear();
	}
}
