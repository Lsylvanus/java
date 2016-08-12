package lsylvanus.collection_map.collection.p2_set.u2.v2;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(2); // ���ų�,��Ϊ��Ԫ�غ����Ƚ�֮�󷵻�0.
		System.out.println(set);

		set.clear();
		System.out.println();

		// ʵ����Comparable�ӿڵ���Ķ���ſ��Է���TreeSet��.
		Student s1 = new Student(1, "a", 20);
		// set.add(s1); //ClassCastException: cannot be cast to
		// java.lang.Comparable

		// ҵ�����: ���ֺ�����һ����,�ų���. �Ȱ�����������,�ٰ�����������
		Student2_final s2_1 = new Student2_final(1, "a", 20);
		Student2_final s2_2 = new Student2_final(2, "a", 20); // ���ų�
		Student2_final s2_3 = new Student2_final(3, "b", 19);
		Student2_final s2_4 = new Student2_final(4, "b", 16);
		// ���յĽ��1,4,3
		set.add(s2_1); // ��ֱ�ӵ���Comparable��comparaTo����ʱ������0ֱ���ų���֮���Ԫ�أ���һ��ֱ�ӷ���set.
		set.add(s2_2);
		set.add(s2_3);
		set.add(s2_4);
		System.out.println(set);
		System.out.println(set.size());
	}
}
