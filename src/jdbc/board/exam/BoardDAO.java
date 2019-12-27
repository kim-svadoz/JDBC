package jdbc.board.exam;

public interface BoardDAO {
	int Insert(BoardDTO board);
	int Insert(String id, String title, String content);
	int Update(String id, int boardnum);
	int Delete(int boardnum);
	//void Search(String title);
	void Select();
}
