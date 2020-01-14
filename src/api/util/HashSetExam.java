package api.util;

import java.util.HashSet;

public class HashSetExam {
	public static void main(String[] args) {
		//set1 -> 1부터 10까지의 정수
		//set2 -> 5부터 15까지의 정수
		HashSet<Integer> set1 = new HashSet<Integer>();
		for(int i=1; i<=10; i++) {
			set1.add(i);
		}
		//set과1 set2 합집합 출력하기
		HashSet<Integer> set2 = new HashSet<Integer>(set1);
		for(int i=5; i<=15; i++) {
			set2.add(i);
		}
		print(set2, "합집합 set2 에 출력된 요소");
		System.out.println("=======================");
		//set1과 set2교집합 출력하기
		HashSet<Integer> set3 = new HashSet<Integer>();
		for(int i=5;i<=15;i++) {
			set3.add(i);
		}
		set1.retainAll(set3);
		print(set1, "교집합에 출력된 요소");
	}
	public static void print(HashSet<Integer> set, String setName) {
		System.out.println("사이즈=>"+set.size());
		for (Integer data : set) {
			System.out.println(setName+"에 저장된 요소=>"+data);
		}
		System.out.println("=========================================");
	}
}
