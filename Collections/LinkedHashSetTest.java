package lsylvanus.collection_map.collection.p2_set.u1;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {

		HashSet set = new HashSet();
		set.add("abc");
		set.add(123);
		set.add(new Date());
		System.out.println(set);

		// ��Ԥ֪����˳��� Set �ӿڵĹ�ϣ��������б�ʵ��. �ײ���LinedHashMapʵ��
		// ���ս�Ԫ�ز��뵽 set �е�˳�򣨲���˳�򣩽��е�����
		LinkedHashSet set2 = new LinkedHashSet();
		set2.add("abc");
		set2.add(123);
		set2.add("abc");// ���ų�
		set2.add(new Date());
		System.out.println(set2);
	}
}
