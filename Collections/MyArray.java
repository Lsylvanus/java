package lsylvanus.collection_map.collection;

import java.util.Arrays;

//���������ȡ������ݵĹ�����
public class MyArray {

	// ���һ������,���ڴ���������͵�����
	private Object[] objs;

	public MyArray() {
		this(10);
	}

	public MyArray(int initLength) {
		objs = new Object[initLength];
	}

	// ��ʾ��ǰ�����±�
	private int index;

	// �������,�����ش�ŵ��±�ֵ
	public int add(Object obj) {
		if (this.index == objs.length) {
			// ����
			objs = Arrays.copyOf(objs, objs.length + 5);
		}
		objs[index] = obj;
		return index++;
	}

	// �滻ĳ���±��Ԫ��
	public void set(Object obj, int index) {
		objs[index] = obj;
	}

	// ��ָ���±괦����һ��Ԫ��
	public void insert(Object obj, int index) {
		if (index + 1 == objs.length) {
			// ����
			objs = Arrays.copyOf(objs, objs.length + 5);
		}
		// ָ���±��Ժ��Ԫ������
		for (int i = this.index; i >= index; i--) {
			objs[i] = objs[i - 1];
		}
		this.index++;
		objs[index] = obj;
	}

	// ɾ��ָ���±��Ԫ��----
	public void remove(int index) {
		// 1. ��ָ���±꿪ʼ, ���Ҳ�������λ����.
		for (int i = index; i < this.index; i++) {
			objs[i] = objs[i + 1];
		}
		this.index--;
		// 2. index--
	}

	// ��ת������Ч����----
	public void reverse() {
		objs = Arrays.copyOf(objs, index);
		for (int i = 0, j = objs.length - 1; i < j; i++, j--) {
			Object temp = objs[j];
			objs[j] = objs[i];
			objs[i] = temp;
		}
	}

	// ���ڲ��洢����Ч����,תΪһ������,����
	public Object[] toArray() {
		return Arrays.copyOf(objs, index);
	}

	@Override
	public String toString() {
		// return Arrays.toString(objs);
		return Arrays.toString(Arrays.copyOf(objs, index));
	}

}
