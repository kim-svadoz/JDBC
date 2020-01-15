package api.util;

import java.util.HashMap;
import java.util.Set;

//HashMap�� �����
public class HashMapTest {
	public static void main(String[] args) {
		//1. (key, value) �� ������
		//		- Generic���� ������ Ÿ���� ������ ������ key Ÿ��, value Ÿ�� ���� �����ؾ���
		HashMap<Integer, String> map = new HashMap<>();
		
		//map������ key�� ��Ҹ� �����ϱ� ������ key�� ������ �����.
		map.put(1, "servlet");
		map.put(1, "jsp");
		map.put(1, "spring");
		System.out.println("map�� ����� ����� ����=>"+map.size());
		System.out.println("key�� 1�� ����� value=>"+map.get(1));
		
		//map�� ����� �����͸� ��� ����ϱ�
		//map�� key�� �̿��ؼ� ����� ��ġ�� ����ϱ� ������ ������ ������� ��µ��� �ʴ´�.
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("abc_1", "servlet");
		map2.put("def_2", "jsp");
		map2.put("ddd_3", "spring");
		map2.put("yyy_4", "tiles");
		map2.put("zzz_5", "mybatis");
		
		//1. map���� �۾��� ���� ���� => key����� �����Ѵ�.
		Set<String> keylist = map2.keySet();
		//2. �ݺ����ȿ��� key�� �̿��ؼ� value�� �����Ѵ�.
		for (String key : keylist) {
			String value = map2.get(key);
			System.out.println(key+":"+value);
		}
	}
}