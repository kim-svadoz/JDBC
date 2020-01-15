package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
ScoreTest.java작성
-BufferedReader를 사용
-파일을 읽어서 아래와 같은 형식으로 출력
-항상 두 컬럼으로 고정
-화면으로 출력하기
[출력형태]
이민호의 점수는 100점
현빈의 점수는 98점
김범룡의 점수는 99점
총점:____
평균:____
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
			System.out.println(my[0]+"의 점수는"+my[1]);
			count ++;
			sum = sum + Integer.parseInt(my[1]); 
		}
		System.out.println("총점:"+sum);
		System.out.println("평균:"+(double)(sum/count));
		if(br!=null) {
			br.close();
		}
	}
}
