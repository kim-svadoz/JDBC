package api.util;

import java.util.HashSet;

public class HashSetExam {
	public static void main(String[] args) {
		//set1 -> 1���� 10������ ����
		//set2 -> 5���� 15������ ����
		HashSet<Integer> set1 = new HashSet<Integer>();
		for(int i=1; i<=10; i++) {
			set1.add(i);
		}
		//set��1 set2 ������ ����ϱ�
		HashSet<Integer> set2 = new HashSet<Integer>(set1);
		for(int i=5; i<=15; i++) {
			set2.add(i);
		}
		print(set2, "������ set2 �� ��µ� ���");
		System.out.println("=======================");
		//set1�� set2������ ����ϱ�
		HashSet<Integer> set3 = new HashSet<Integer>();
		for(int i=5;i<=15;i++) {
			set3.add(i);
		}
		set1.retainAll(set3);
		print(set1, "�����տ� ��µ� ���");
	}
	public static void print(HashSet<Integer> set, String setName) {
		System.out.println("������=>"+set.size());
		for (Integer data : set) {
			System.out.println(setName+"�� ����� ���=>"+data);
		}
		System.out.println("=========================================");
	}
}
