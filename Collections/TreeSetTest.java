package lsylvanus.collection_map.collection.p2_set.u2.v2;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(2); // 被排除,因为有元素和他比较之后返回0.
		System.out.println(set);

		set.clear();
		System.out.println();

		// 实现了Comparable接口的类的对象才可以放入TreeSet中.
		Student s1 = new Student(1, "a", 20);
		// set.add(s1); //ClassCastException: cannot be cast to
		// java.lang.Comparable

		// 业务规则: 名字和年龄一样的,排除掉. 先按照名字排序,再按照年龄排序
		Student2_final s2_1 = new Student2_final(1, "a", 20);
		Student2_final s2_2 = new Student2_final(2, "a", 20); // 被排除
		Student2_final s2_3 = new Student2_final(3, "b", 19);
		Student2_final s2_4 = new Student2_final(4, "b", 16);
		// 最终的结果1,4,3
		set.add(s2_1); // 当直接调用Comparable的comparaTo方法时，返回0直接排除掉之后的元素，第一个直接放入set.
		set.add(s2_2);
		set.add(s2_3);
		set.add(s2_4);
		System.out.println(set);
		System.out.println(set.size());
	}
}
