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

		// list,set�������ɵ���������
		Iterator itList = arrayList.iterator();
		Iterator itSet = hashSet.iterator();

		System.out.println();
		// ͨ������������ѭ������
		while (itSet.hasNext()) {
			Object object = (Object) itSet.next();// ��ѭ����ѭ�����޷�����,��Ϊ��ʱ�ĵ�������û��next��.
			System.out.print(object + ",");
		}

		System.out.println();
		while (itList.hasNext()) {
			Object object = (Object) itList.next();
			System.out.print(object + ",");
		}
		
		System.out.println();
		// ���һ��������,�Ѿ�������ĩβ, ��û�ж�����ȡ����. �����������ɵ�����֮���ٲ���
		itList = arrayList.iterator();
		while (itList.hasNext()) {
			Object object = (Object) itList.next();
			System.out.print(object + ",");
		}
	}
}
