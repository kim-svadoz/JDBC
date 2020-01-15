package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//BufferedReader로 한 문장씩 읽기
public class BufferedReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			//fr = new FileReader("src/data/test.txt"); // 기본 스트림
			//br = new BufferedReader(fr); // 보조 스트림 - 기본 스트림과 연결하는 작업
			//BufferedReader
			br = new BufferedReader(new FileReader("src/api/io/FileTest01.java"));
			int count = 0; //실행횟수를 저장할 변수
			long start = System.nanoTime();
			while(true) {
				String data = br.readLine();
				if(data==null) {
					break;
				}
				count++;
				System.out.println(data);
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
				if(br!=null)
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
