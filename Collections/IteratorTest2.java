package lsylvanus.collection_map.collection.p3_iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest2 {

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

		Iterator itList = arrayList.iterator();
		Iterator itSet = hashSet.iterator();
		
		//注意: 在用foreach遍历集合的时候,不要直接通过集合对象进行删除|插入操作.否则极有可能抛出 ConcurrentModificationException
				//为了保证在遍历集合的时候能删除或者插入元素(只能通过ListIterator),必须调用迭代器对象的remove方法.
		
		System.out.println();
		while (itSet.hasNext()) {
			Object object = (Object) itSet.next();
			hashSet.remove('b');
			System.out.print(object+",");
		}
		
		System.out.println();
		while (itList.hasNext()) {
			Integer object = (Integer) itList.next();
			if (object.equals(3)) {
				arrayList.remove(3);
			}else {
				System.out.println(object);
			}
			
			//if (object.equals(2)) {
				arrayList.remove(2);
			//}
			System.out.println(arrayList);
		}
		
		/**
		在迭代器中删除下标1 调用listIterator类
		 int cursor = index = 1;
         int expectedModCount = ArrayList.this.modCount = 1;
		 so , index = 1 , modCount = 1 ,
		 remove() --- modCount++;
		 so , modCount == 2,
		 next()方法中  → checkForComodification()先判断
		 (expectedModCount = 1) != (modCount = 2)
		 if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
            }
		 */
		
		/*System.out.println();
		while (itSet.hasNext()) {
			String str = (String) itSet.next();
			try {
				if (str.equals("b")) {
					hashSet.remove("b");
				}else {
					System.out.println(str);
				}
			} catch (ConcurrentModificationException e) {
				e.printStackTrace();
			}
			System.out.print(hashSet);
		}*/
		
		System.out.println();
		Iterator iterList=arrayList.iterator();
		while (iterList.hasNext()) {
			Object object = (Object) iterList.next();
			//arrayList.remove(0);//不要通过集合对象操作!!, 删除后,下次循环中的next()时异常
			iterList.remove();//通过迭代器删除当前获取出的对象.----------------OK
		}
		System.out.println(iterList);
	}
}
