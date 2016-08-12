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
		
		//����: ׷��,������ʱ����ArrayList; ����,ɾ����ʱ��ʹ��LinedList.
	}
	//׷�Ӳ���,ArrayList��׷��Ч�ʱ�LinkedList��
	static void addTest(){
		time1 = System.currentTimeMillis();
		for(int i=0;i<=10000000;i++){
			arrayList.add("a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList addTest ��ʱ:" + (time2-time1)); //200ms
		
		time1 = System.currentTimeMillis();
		for(int i=0;i<=10000000;i++){
			linkedList.add("a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList addTest ��ʱ:" + (time2-time1)); //10s��
	}
	
	//�������,LinkedList�Ĳ���Ч�ʱ�ArrayList��
	static void insertTest(){
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			linkedList.add(0,"a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList insertTest ��ʱ:" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			arrayList.add(0,"a");
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList insertTest ��ʱ:" + (time2-time1));
	}
	//ɾ������
	static void removeTest(){
		for(int i=0;i<=100000;i++){
			linkedList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=100000-1;i>=0;i--){
			linkedList.remove(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList removeTest ��ʱ:" + (time2-time1));
		
		for(int i=0;i<=100000;i++){
			arrayList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=100000-1;i>=0;i--){
			arrayList.remove(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList removeTest ��ʱ:" + (time2-time1));
	}
	
	//��������, LinkedList�ı���Ч�ʵ���ArrayList
	static void forTest(){
		for(int i=0;i<=100000;i++){
			linkedList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			linkedList.get(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("LinkedList forTest ��ʱ:" + (time2-time1));
		
		for(int i=0;i<=100000;i++){
			arrayList.add(0,"a");
		}
		time1 = System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			arrayList.get(i);
		}
		time2 = System.currentTimeMillis();
		System.out.println("ArrayList forTest ��ʱ:" + (time2-time1));
	}
	
}
