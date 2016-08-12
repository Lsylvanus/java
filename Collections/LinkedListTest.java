package lsylvanus.collection_map.collection.p1_list;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		// LinkedList,�ײ���һ����,˫������ . ������Ԫ����˳��,���ҿ����ظ�.
		// �����б���Ե�����ջ�����л�˫�˶�����ʹ��,����LinkedList���ṩ�˺ܶ���صķ�����

		LinkedList list = new LinkedList();
		list.add(1);
		list.add("String");

		HashSet set = new HashSet();
		set.add(1);
		set.add(1); // ���ų�
		set.add(3);
		list.addAll(set);
		System.out.println(list);

		// ��ջģ��
		list.clear();
		list.push("a"); // ѹջ
		list.push("b");
		System.out.println(list);
		System.out.println(list.pop());
		System.out.println(list);

		list.clear();
		// ����ģ��
		list.add("a");
		list.add("b");
		list.add("c"); // [a,b,c]
		System.out.println(list);
		System.out.println(list.poll()); // a
		System.out.println(list);// [b,c]
	}

}
