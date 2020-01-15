package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//폴더의 내부를 탐색
public class FileTest02 {
	public static void main(String[] args) {
		/*
		1) c:\iot\iotest 폴더의 하위 폴더 및 파일을 출력
		[출력형태]
		a ----------- [폴더]
		b ----------- [폴더]
		ArrayTest01.java ---------- [파일 :(파일의사이즈)]
		.
		.
		.
		*/
		// 마지막 접속한 날짜를 년 원 일의 형식으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		File file = new File("c:/iot/iotest");
		File[] myfile = file.listFiles();
		
		for(int i=0; i<file.listFiles().length;i++) {
			if(myfile[i].isDirectory() == true) {
				System.out.println(myfile[i].getName()+"------------[폴더], "
			+sdf.format(myfile[i].lastModified()));
			}else {
				System.out.println(myfile[i].getName()+"-------------[파일 : "
			+myfile[i].length()+"], "+sdf.format(myfile[i].lastModified()));
			}
		}
	}
}
