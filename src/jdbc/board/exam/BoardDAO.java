package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	int Insert(BoardDTO board); // �Խñ� ��� -C
	int Insert(String id, String title, String content); // �Խñ� ���
	int Update(String id, int boardnum); // �Խñ� ���� -U
	int Delete(int boardnum); // �Խñ� ���� -D
	ArrayList<BoardDTO> Select(); // ��ü �Խñ� ��ȸ -L
	ArrayList<BoardDTO> findByTitle(String title); // �Խñ� �˻� - L // �̷��ܾ ���ִ��� �˻�
	BoardDTO read(int boardnum); // �Խñ� ��ȸ -R //PK���� �˻�
}
/* CLRUD
U - Update
D - Delete
L - List => DTO�� ����ִ� ArrayList
R - Read
C - 
*/