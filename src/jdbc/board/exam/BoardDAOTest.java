package jdbc.board.exam;

import java.util.Scanner;

public class BoardDAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		BoardDAOImpl dao = new BoardDAOImpl();
		System.out.println("**********�Խñ� ���**********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("����:");
		String title = key.next();
		System.out.print("����:");
		String content = key.next();
		dao.Insert(id, title, content);
		
		dao.Update("JIM", 26);
		dao.Delete(33);
		dao.Select();
	}
}
