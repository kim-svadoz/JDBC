package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
ScoreTest.java�ۼ�
-BufferedReader�� ���
-������ �о �Ʒ��� ���� �������� ���
-�׻� �� �÷����� ����
-ȭ������ ����ϱ�
[�������]
�̹�ȣ�� ������ 100��
������ ������ 98��
������� ������ 99��
����:____
���:____
*/
public class ScoreTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br= null;
		br = new BufferedReader(new FileReader("src/data/score.txt"));
		int sum =0;
		int count = 0;
		while(true) {
			String data = br.readLine();
			if(data==null) {
				break;
			}
			String[] my = data.split(", ");
			System.out.println(my[0]+"�� ������"+my[1]);
			count ++;
			sum = sum + Integer.parseInt(my[1]); 
		}
		System.out.println("����:"+sum);
		System.out.println("���:"+(double)(sum/count));
		if(br!=null) {
			br.close();
		}
	}
}
