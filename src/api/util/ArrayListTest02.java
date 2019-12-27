package api.util;

import java.util.ArrayList;
//collection에 저장할 요소의 타입을 generic형태로 정의한다.
//collection클래스<데이터타입>;
public class ArrayListTest02 {
	public static void main(String[] args) {
		//String[] arr = new String[S]
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바"); // arr[0] = "자바";
		list.add("오라클");
		list.add("JDBC");
		list.add("HTMLS");
		list.add("CSs");
		for (int i = 0; i < list.size(); i++) { //arr.legnth
			System.out.println(list.get(i)); //arr[i]
		}
	}
}
