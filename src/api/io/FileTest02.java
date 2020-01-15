package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//������ ���θ� Ž��
public class FileTest02 {
	public static void main(String[] args) {
		/*
		1) c:\iot\iotest ������ ���� ���� �� ������ ���
		[�������]
		a ----------- [����]
		b ----------- [����]
		ArrayTest01.java ---------- [���� :(�����ǻ�����)]
		.
		.
		.
		*/
		// ������ ������ ��¥�� �� �� ���� �������� ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		
		File file = new File("c:/iot/iotest");
		File[] myfile = file.listFiles();
		
		for(int i=0; i<file.listFiles().length;i++) {
			if(myfile[i].isDirectory() == true) {
				System.out.println(myfile[i].getName()+"------------[����], "
			+sdf.format(myfile[i].lastModified()));
			}else {
				System.out.println(myfile[i].getName()+"-------------[���� : "
			+myfile[i].length()+"], "+sdf.format(myfile[i].lastModified()));
			}
		}
	}
}
