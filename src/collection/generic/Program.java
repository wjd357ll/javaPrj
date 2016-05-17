package collection.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import collection.generic.GCollection.Iterator;

public class Program {

	public static void main(String[] args) {
		
		// �������� �ڷ����� ������ �ڷ����� �ϰ�ó���ϰ� ���� �� ����ȯ�� �ؾ��ϴ� ��츦 �����ؾ� �Ѵ�.(����)
		// �پ��� �ڷ����� �ϰ�ó���ϰ� ���� ������ �ƹ� ���̳� �־��൵ �����ϴ�.
		
		/*GCollection list = new GCollection();
		
		for(int i=0; i<100; i++)
			list.add(i+1);*/
		
		

		List<String> list = new ArrayList<>();
	
		list.add("hello");
		list.add("ok");
		list.add("hello");
		list.add("ok");

		/*for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		
		// ���� �������� ���
*/		
		for(String s : list)  
			System.out.println(s);
		// ���� List<String>���� ����߱� ������ String������ �ϳ��� �����´�.
		// String ��� Object �� �ٸ� �������� ���� (�������� ����)
		// ����Ʈ�� �����͸� �־��� �� �� ������ ����Ѵ�.

		System.out.println("------------------<Set>--------------------");
		
		Set<String> sets = new HashSet<>();
		sets.add("hello");
		sets.add("ok");
		sets.add("hello");
		sets.add("ok");
		
		sets.add("23");
		sets.add("5");
		sets.add("12");
		sets.add("7");   // ���� ������ ����. � ���� ���� ��µ� �� �𸥴�.
		
		
		System.out.println(sets); // ��°�� : [hello, ok] 
		/*for(String s : sets)
			System.out.println(s);*/
		
		Set<String> tset = new TreeSet<>();
		tset.add("23");
		tset.add("5");
		tset.add("12"); 
		tset.add("7"); // ���� ���ڰ� ������ ������, 23<5  - �� �������� ���ĵȴ�.

		// set�� ���� ���̸� �ѹ��� ���
		// list�� ���� �����ȴ�. - ������ �������� ���� ����
		// ��� ������ ������� �ʴ´�.
		// Ʈ�� - ��ȸ�� ������ �Ѵ�.
		// �ؽ� - �ĺ������ϵ��� ���� �ߺ��� ������� �ʴ´�.
	
		System.out.println("------------------<Map>--------------------");
		
		//set�� �� ������ ��ü�� �ĺ���(key)�̴�. Ư���� �̾Ƴ��� ��� ���� ���Ÿ� ����
		//map�� ���� �̸��� �ο� - ������ �ƴ϶� key�� ������� ���� �̾Ƴ� �� �ִ�.
		
		Map<String, String> m = new HashMap<>();
		m.put("name", "ȫ�浿");
		m.put("addr", "����� ������");
		m.put("name", "��浿");
		
		System.out.println(m.get("name"));  // Hash�� �ֱ� ������ name �ߺ��ȵ� - ��浿 ���
		
		//print(2,list, 0, 5); //0��°���� 5��°���� ���
		//print(1,list, 5); //5��°���� ������
		
		/*for(int i=0; i<100; i++)
			list.get(i);  // ������ ��ġ�� ��� �帧���� ����
		
		list.clear(); //��ġ �ʱ�ȭ
		while(list.hasNext())
			System.out.println(list.next()); */
		
/*		
		//�ٸ� �帧 : Thread -> run()
		Thread th = new Thread(new Runnable(){

			@Override
			public void run() { //�����帧
				
				print(2,list);
				
			}});
		
		th.start(); // ���� ������ �帧�� start�� ���� ����
		
		print(1,list);
		
		list.add(23);
		list.add("dd");
		list.add(23.5);
		list.add(new Exam());
	}

	private static void print(int key, GCollection list) {
		
		for(int i=0; i<100; i++)
			System.out.printf("key : %d, value : %d\n", key, list.get(i));
		
		
		list.clear(); //��ġ �ʱ�ȭ
		while(list.hasNext())
			System.out.printf("key : %d, value : %d\n", key, list.next());
		
		Iterator it = list.iterator();  // �Լ��� ��ȯ���� Iterator�� ���ο� ��ü
		it.clear(); 
		while(it.hasNext())
			System.out.printf("key : %d, value : %d\n", key, it.next());
	}*/
	}
}
