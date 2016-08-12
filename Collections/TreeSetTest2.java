package lsylvanus.collection_map.collection.p2_set.u1;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add(2);
		set.add(1);
		set.add(3);
		set.add(0);
		System.out.println(set); // [0, 1, 2, 3] ��������

		// ����һ���Ƚ���.
		TreeSet set2 = new TreeSet(new MyComparator());
		set2.add(2);
		set2.add(3);
		set2.add(1);
		set2.add(0);
		System.out.println(set2); //
	}

	static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// return 0;//��һ��Ԫ���Ժ������Ԫ�ض����ᱻ����.
			// return o1-o2; //��������
			return o2 - o1; // ��������
		}

	}

}
