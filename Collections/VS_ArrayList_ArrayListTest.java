package lsylvanus.collection_map.collection.p1_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class VS_ArrayList_ArrayListTest {
	static ArrayList arrayList = new ArrayList();
	static LinkedList linkedList = new LinkedList();
	
	static long time1 ,time2;
	public static void main(String[] args) {
		//addTest();
		//insertTest();
		//removeTest();
		forTest();
		
		//结论: 追加,遍历的时候用ArrayList; 插入,删除的时候使用LinedList.
	}
	//追加测试,ArrayList的追加效率比LinkedList高
	static void addTest(){
		time1 = System.currentTimeMillis();
		for(int i=0;i<=10000000;i++){
			arrayList.add("a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList addTest 耗时:" + (time2-time1)); //200ms
		
		time1 = System.currentTimeMillis();
		for(int i=0;i<=10000000;i++){
			linkedList.add("a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList addTest 耗时:" + (time2-time1)); //10s内
	}
	
	//插入测试,LinkedList的插入效率比ArrayList高
	static void insertTest(){
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			linkedList.add(0,"a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList insertTest 耗时:" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			arrayList.add(0,"a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList insertTest 耗时:" + (time2-time1));
	}
	//删除测试
	static void removeTest(){
		for(int i=0;i<=100000;i++){
			linkedList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=100000-1;i>=0;i--){
			linkedList.remove(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList removeTest 耗时:" + (time2-time1));
		
		for(int i=0;i<=100000;i++){
			arrayList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=100000-1;i>=0;i--){
			arrayList.remove(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList removeTest 耗时:" + (time2-time1));
	}
	
	//遍历测试, LinkedList的遍历效率低于ArrayList
	static void forTest(){
		for(int i=0;i<=100000;i++){
			linkedList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			linkedList.get(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList forTest 耗时:" + (time2-time1));
		
		for(int i=0;i<=100000;i++){
			arrayList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			arrayList.get(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList forTest 耗时:" + (time2-time1));
	}
	
}
