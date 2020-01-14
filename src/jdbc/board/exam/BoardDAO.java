package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	int Insert(BoardDTO board); // 게시글 등록 -C
	int Insert(String id, String title, String content); // 게시글 등록
	int Update(String id, int boardnum); // 게시글 수정 -U
	int Delete(int boardnum); // 게시글 삭제 -D
	ArrayList<BoardDTO> Select(); // 전체 게시글 조회 -L
	ArrayList<BoardDTO> findByTitle(String title); // 게시글 검색 - L // 이런단어가 들어가있는지 검색
	BoardDTO read(int boardnum); // 게시글 조회 -R //PK에서 검색
}
/* CLRUD
U - Update
D - Delete
L - List => DTO가 담겨있는 ArrayList
R - Read
C - 
*/