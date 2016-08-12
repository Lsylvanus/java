package lsylvanus.collection_map.collection.p3_iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(2);
		arrayList.add(6);
		arrayList.add(5);
		System.out.println(arrayList);

		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(122);
		hashSet.add('b');
		hashSet.add("lsylvanus");
		hashSet.add(new Date());
		System.out.println(hashSet);

		// list,set可以生成迭代器对象
		Iterator itList = arrayList.iterator();
		Iterator itSet = hashSet.iterator();

		System.out.println();
		// 通过迭代器进行循环遍历
		while (itSet.hasNext()) {
			Object object = (Object) itSet.next();// 该循环的循环体无法进入,因为此时的迭代器里没有next了.
			System.out.print(object + ",");
		}

		System.out.println();
		while (itList.hasNext()) {
			Object object = (Object) itList.next();
			System.out.print(object + ",");
		}
		
		System.out.println();
		// 如果一个迭代器,已经迭代到末尾, 就没有东西可取出了. 除非重新生成迭代器之后再操作
		itList = arrayList.iterator();
		while (itList.hasNext()) {
			Object object = (Object) itList.next();
			System.out.print(object + ",");
		}
	}
}
