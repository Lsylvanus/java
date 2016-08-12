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
		
		//ע��: ����foreach�������ϵ�ʱ��,��Ҫֱ��ͨ�����϶������ɾ��|�������.�����п����׳� ConcurrentModificationException
				//Ϊ�˱�֤�ڱ������ϵ�ʱ����ɾ�����߲���Ԫ��(ֻ��ͨ��ListIterator),������õ����������remove����.
		
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
		�ڵ�������ɾ���±�1 ����listIterator��
		 int cursor = index = 1;
         int expectedModCount = ArrayList.this.modCount = 1;
		 so , index = 1 , modCount = 1 ,
		 remove() --- modCount++;
		 so , modCount == 2,
		 next()������  �� checkForComodification()���ж�
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
			//arrayList.remove(0);//��Ҫͨ�����϶������!!, ɾ����,�´�ѭ���е�next()ʱ�쳣
			iterList.remove();//ͨ��������ɾ����ǰ��ȡ���Ķ���.----------------OK
		}
		System.out.println(iterList);
	}
}
