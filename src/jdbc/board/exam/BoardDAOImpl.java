package jdbc.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//tb_board���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAOImpl implements BoardDAO {
	public int Insert(BoardDTO board) {
		System.out.println("dto���޼ҵ�:"+board);
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0; // �޼ҵ� �������� ����� ����
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			con = DBUtil.getConnect(); // DBMS ����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, board.getId());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getContent());
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� Insert ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int Update(String id, int boardnum) {
		PreparedStatement ptmt = null;
		Connection con = null;
		int result = 0;
		String sql = "update tb_board set ID = ? where boardnum = ?";
		try {
			con = DBUtil.getConnect(); // DBMS ����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� Update ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int Delete(int boardnum) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql = "delete tb_board where boardnum = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, boardnum);
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� Delete ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public ArrayList<BoardDTO> findByTitle(String title) {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board where title like ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, "%" + title + "%");
			rs = ptmt.executeQuery();
			while (rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6));
				boardlist.add(board);
			}
			System.out.println(rs + "�� �� findbytitle ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return boardlist;
	}
	
	public BoardDTO read(int boardnum) {
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board where boardnum = ? ";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, boardnum);
			//result = ptmt.executeUpdate();
			rs = ptmt.executeQuery();
			if(rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6)); 
				// PK�� �����߱� ������ ����� �ϳ���. => while�� �� �ʿ���� if�� �� �� �ִ�.
			}
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return board;
	}
	
	//��ȸ�� ����� ArrayList�� ��ȯ�Ͽ� ����
	public ArrayList<BoardDTO> Select() {
		//��ü �Խñ��� ���� Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		//��ȸ�� �Խñ��� ���� ��ü
		//��ü�� �������� �ʰ� null�� �ʱ�ȭ�ϴ� ����
		//=> �����͸� ��ȸ�Ѵ� �۾��� �ϴ� ���� while�� �����̹Ƿ� while������ ��ȸ�� ���ڵ�� ��ü�� ����
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			int result = ptmt.executeUpdate();
			rs = ptmt.executeQuery(sql);
			while (rs.next()) { // ���ڵ带 ��ȸ�ϱ� ���ؼ��� ���ڵ尡 �� ���� �ݵ�� Ŀ���� �̵����Ѿ� �Ѵ�.
				//1. ��ȸ�� ���ڵ��� �÷��� �о DTO�� ��ȯ�ϴ� �۾�
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6));
				//2. DTO�� ��ȯ�� ���ڵ带 Arraylist �� �߰�
				boardlist.add(board);
			}
			System.out.println(result + "�� �� Select ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return boardlist;
	}
	
	public int Insert(String id, String title, String content) {
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0; // �޼ҵ� �������� ����� ����
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			con = DBUtil.getConnect(); // DBMS ����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� Insert ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	
}
