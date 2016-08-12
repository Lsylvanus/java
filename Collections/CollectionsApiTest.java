package lsylvanus.collection_map.collection.p4_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsApiTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add(3);
		list.add(4);

		// һ�����򼯺�����Ӷ��Ԫ��: ...args ��ʾ�ɱ䳤�Ȳ���,
		Collections.addAll(list, 4, 2, new Object(), 6, 1, "abc", 3, 2);
		System.out.println(list);

		list.clear();

		Collections.addAll(list, 1, 2, 5, 4, 7, 9, 2, 3, 6, 0, 8, 4);
		System.out.println(list);

		// ���ֲ���, binarySearch. ע��,���ֲ���ǰ����������һ�²��ܱ�֤��ȷ�Ĳ���
		int index = Collections.binarySearch(list, 7);// ���ظ�����ʾû���ҵ�.
		System.out.println(index);
		Collections.sort(list);
		System.out.println(list);
		index = Collections.binarySearch(list, 7);
		System.out.println(index);
	}
}
