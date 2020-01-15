package api.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		//FileTest01.java ������ copy�ϱ�
		//1. FileReader�� �а� FileWriter�� ����ϱ�
		//2. src/data/copy_result.txt�� �����ϱ�
		//3. �ַܼε� ��µǵ��� �ۼ�
		FileReader fr = new FileReader("src/api/io/FileTest01.java");
		FileWriter fw = new FileWriter("src/data/copy_result.txt", true);
		
		while(true) {
			int my = fr.read();
			fw.write(my);
			
			System.out.print((char)my);
			if(my == -1) {
				break;
			}
		}
		
		if(fr!=null) {
			fr.close();
		}
		if(fw!=null) {
			fw.close();
		}
	}
}
