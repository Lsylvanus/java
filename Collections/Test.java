package lsylvanus.collection_map.collection;

public class Test {
	public static void main(String[] args) {
		MyArray array = new MyArray();
		System.out.println(array);
		System.out.println(array.add(1)); // 0
		System.out.println(array.add("abc")); // 1
		System.out.println(array);
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(10);
		System.out.println(array);
		array.add(11);
		System.out.println(array);

		array.set(100, 3);
		System.out.println(array);

		array.insert(-100, 1);
		System.out.println(array);

		array.remove(2);
		System.out.println(array);
		
		array.insert("ffff", 1);
		System.out.println(array);

		array.reverse();
		System.out.println(array);

	}
}
