package lsylvanus.collection_map.collection.p1_list;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		// LinkedList,底层是一个链,双向链表 . 所以有元素有顺序,并且可以重复.
		// 链接列表可以当做堆栈、队列或双端队列来使用,所以LinkedList中提供了很多相关的方法。

		LinkedList list = new LinkedList();
		list.add(1);
		list.add("String");

		HashSet set = new HashSet();
		set.add(1);
		set.add(1); // 被排除
		set.add(3);
		list.addAll(set);
		System.out.println(list);

		// 堆栈模拟
		list.clear();
		list.push("a"); // 压栈
		list.push("b");
		System.out.println(list);
		System.out.println(list.pop());
		System.out.println(list);

		list.clear();
		// 队列模拟
		list.add("a");
		list.add("b");
		list.add("c"); // [a,b,c]
		System.out.println(list);
		System.out.println(list.poll()); // a
		System.out.println(list);// [b,c]
	}

}
