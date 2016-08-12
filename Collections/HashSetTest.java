package lsylvanus.collection_map.collection.p2_set.u1;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		// HashSet集合内部没有重复元素,并且不保证顺序. 底层是由HashMap实现.
		HashSet set = new HashSet();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(5); // 被排除
		set.add(-5);
		set.add(null);// 被排除
		set.add(null);
		set.add("abc");
		set.add("abc");// 被排除
		set.add(new String("abc")); // 被排除, 利用hashCode和equals进行排除
		System.out.println(set);
		System.out.println(set.size());

		String str1 = "abc"; // 数据块中
		String str2 = new String("abc"); // 新new一个出来，看字符串是否存在于数据块中，若存在直接引用数据块中的字符串
		if (str1.equals(str2)) {
			System.out.println("相等");	//String重写了equals方法，比较的是两个字符串的内容
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

		// Set没有提供下标操作, 不能使用for循环遍历

	}
}
