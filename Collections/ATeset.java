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
		// hashSet.get(index);//Set����û���±�ĸ���,����ͨ��get��ȡ�ض���ĳ��Ԫ��. ���Բ���ֱ��forѭ������

		//ת��������,�Ϳ���ͨ��loop��ȡ��ԭset�е�Ԫ��.
		arrayList = new ArrayList<>(hashSet);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i));
		}
		//set���Ԫ��Ҳ����ͨ����������ȡ.>>>>>>>>
	}
}
