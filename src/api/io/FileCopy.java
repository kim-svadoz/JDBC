package api.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		//FileTest01.java 파일을 copy하기
		//1. FileReader로 읽고 FileWriter로 출력하기
		//2. src/data/copy_result.txt로 생성하기
		//3. 콘솔로도 출력되도록 작성
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
