package lsylvanus.collection_map.collection.p2_set.u1;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		// HashSet�����ڲ�û���ظ�Ԫ��,���Ҳ���֤˳��. �ײ�����HashMapʵ��.
		HashSet set = new HashSet();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(5); // ���ų�
		set.add(-5);
		set.add(null);// ���ų�
		set.add(null);
		set.add("abc");
		set.add("abc");// ���ų�
		set.add(new String("abc")); // ���ų�, ����hashCode��equals�����ų�
		System.out.println(set);
		System.out.println(set.size());

		String str1 = "abc"; // ���ݿ���
		String str2 = new String("abc"); // ��newһ�����������ַ����Ƿ���������ݿ��У�������ֱ���������ݿ��е��ַ���
		if (str1.equals(str2)) {
			System.out.println("���");	//String��д��equals�������Ƚϵ��������ַ���������
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

		// Setû���ṩ�±����, ����ʹ��forѭ������

	}
}
