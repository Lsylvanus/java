package lsylvanus.collection_map.collection.p3_iterator;

import java.util.ArrayList;
import java.util.HashSet;

public class ATeset {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(2);
		arrayList.add(6);
		arrayList.add(5);
		System.out.println(arrayList);
		System.out.println(arrayList.size());
		System.out.println(arrayList.get(5));

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i));
		}

		HashSet hashSet = new HashSet();
		hashSet.size();
		// hashSet.get(index);//Set本身没有下标的概念,不能通过get获取特定的某个元素. 所以不能直接for循环遍历

		//转换容器后,就可以通过loop获取出原set中的元素.
		arrayList = new ArrayList<>(hashSet);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i));
		}
		//set里的元素也可以通过迭代器获取.>>>>>>>>
	}
}
