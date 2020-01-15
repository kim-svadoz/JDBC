package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//advancedJava 프로젝트폴더 아래에 저장된 test.txt의 내용을 읽어서 콘솔에 출력하기 
public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//1. 파일 오픈하기
			fr = new FileReader("src/api/io/FileTest01.java");
			//2. 파일 액세스
			int count = 0; //실행횟수를 저장할 변수
			long start = System.nanoTime();
			
			while(true) {
				int data = fr.read();
				if(data==-1) {
					break;
				}
				count++;
				System.out.print((char)data);
			}
			long end = System.nanoTime();
			System.out.println("실행횟수=>"+count);
			System.out.println("실행시간=>"+(end-start));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. 파일 닫기
			try {
				if(fr!=null)
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
