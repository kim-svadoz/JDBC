package api.util;

import java.util.ArrayList;

public class ArrayListExam01 {
	public static void main(String[] args) {
		//79,55,100,98,99�� ArrayList�� ��� ������ ����� ����ϼ���
		//[�������]
		//���� : ______
		//��� : ______
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(79);
		list.add(55);
		list.add(100);
		list.add(98);
		list.add(99);
		for(int i=0;i<list.size();i++) {
			sum += list.get(i);
		}
		System.out.println("���� : "+sum);
		System.out.println("��� : "+(double)sum/list.size());
	}
}
