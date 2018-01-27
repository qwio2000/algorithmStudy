package test;

import vo.Array;

public class ArrayTest {
	public static void main(String[] args) {
		Array array = new Array(5);
		System.out.println("Array �ʱ�ȭ\n\t"+array.toString());
		array.add(new String("TEST1"));
		array.add(new String("TEST2"));
		array.add(new String("TEST3"));
		System.out.println("�ε��� ���� Add ����\n\t"+array.toString());
		array.add(new String("add with index"), 1);
		System.out.println("�ε��� Add(Object, 1) ����\n\t"+array.toString());
		array.swap(0, 2);
		System.out.println("SWAP(0,2) ����\n\t"+array.toString());
		array.remove(3);
		System.out.println("REMOVE(3) ����\n\t"+array.toString());
		array.replace("REPLACE STRING", 1);
		System.out.println("REPLACE String(1) ����\n\t"+array.toString());
		array.read(1);
		System.out.println("READ(1) ����\n\t"+array.read(1).toString());
		array.clear();
		System.out.println("CLEAR ����\n\t"+array.toString());
	}
}
