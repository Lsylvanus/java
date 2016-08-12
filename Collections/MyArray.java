package lsylvanus.collection_map.collection;

import java.util.Arrays;

//用来方便存取多个数据的工具类
public class MyArray {

	// 组合一个数组,用于存放任意类型的数据
	private Object[] objs;

	public MyArray() {
		this(10);
	}

	public MyArray(int initLength) {
		objs = new Object[initLength];
	}

	// 表示当前可用下标
	private int index;

	// 存放数据,并返回存放的下标值
	public int add(Object obj) {
		if (this.index == objs.length) {
			// 扩容
			objs = Arrays.copyOf(objs, objs.length + 5);
		}
		objs[index] = obj;
		return index++;
	}

	// 替换某个下标的元素
	public void set(Object obj, int index) {
		objs[index] = obj;
	}

	// 在指定下标处插入一个元素
	public void insert(Object obj, int index) {
		if (index + 1 == objs.length) {
			// 扩容
			objs = Arrays.copyOf(objs, objs.length + 5);
		}
		// 指定下标以后的元素右移
		for (int i = this.index; i >= index; i--) {
			objs[i] = objs[i - 1];
		}
		this.index++;
		objs[index] = obj;
	}

	// 删除指定下标的元素----
	public void remove(int index) {
		// 1. 从指定下标开始, 把右侧数据诸位左移.
		for (int i = index; i < this.index; i++) {
			objs[i] = objs[i + 1];
		}
		this.index--;
		// 2. index--
	}

	// 翻转现有有效数据----
	public void reverse() {
		objs = Arrays.copyOf(objs, index);
		for (int i = 0, j = objs.length - 1; i < j; i++, j--) {
			Object temp = objs[j];
			objs[j] = objs[i];
			objs[i] = temp;
		}
	}

	// 把内部存储的有效数据,转为一个数组,返回
	public Object[] toArray() {
		return Arrays.copyOf(objs, index);
	}

	@Override
	public String toString() {
		// return Arrays.toString(objs);
		return Arrays.toString(Arrays.copyOf(objs, index));
	}

}
