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

		// 可预知迭代顺序的 Set 接口的哈希表和链接列表实现. 底层有LinedHashMap实现
		// 按照将元素插入到 set 中的顺序（插入顺序）进行迭代。
		LinkedHashSet set2 = new LinkedHashSet();
		set2.add("abc");
		set2.add(123);
		set2.add("abc");// 被排除
		set2.add(new Date());
		System.out.println(set2);
	}
}
