package api.util;

import java.util.ArrayList;
//collection�� ������ ����� Ÿ���� generic���·� �����Ѵ�.
//collectionŬ����<������Ÿ��>;
public class ArrayListTest02 {
	public static void main(String[] args) {
		//String[] arr = new String[S]
		ArrayList<String> list = new ArrayList<String>();
		list.add("�ڹ�"); // arr[0] = "�ڹ�";
		list.add("����Ŭ");
		list.add("JDBC");
		list.add("HTMLS");
		list.add("CSs");
		for (int i = 0; i < list.size(); i++) { //arr.legnth
			System.out.println(list.get(i)); //arr[i]
		}
	}
}
