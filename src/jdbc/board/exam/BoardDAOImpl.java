package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board테이블을 액세스하는 기능이 정의된 클래스
public class BoardDAOImpl implements BoardDAO {
	public int Insert(BoardDTO board) {
		System.out.println("dto사용메소드:"+board);
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0; // 메소드 실행결과가 저장될 변수
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			con = DBUtil.getConnect(); // DBMS 연결
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, board.getId());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getContent());
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 Insert 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
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
			con = DBUtil.getConnect(); // DBMS 연결
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 Update 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
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
			System.out.println(result + "개 행 Delete 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	/*public void Search(String title) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "delete tb_board where boardnum = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			int result = ptmt.executeUpdate();
			rs = ptmt.executeQuery(sql);
			System.out.println(result + "개 행 Search 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return result;
	}*/
	
	public void Select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board";

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			int result = ptmt.executeUpdate();
			rs = ptmt.executeQuery(sql);
			while (rs.next()) { // 레코드를 조회하기 위해서는 레코드가 한 개라도 반드시 커서를 이동시켜야 한다.
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString("content") + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.println(rs.getInt(6) + "\t");
			}

			System.out.println(result + "개 행 Select 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
	}
	
	public int Insert(String id, String title, String content) {
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0; // 메소드 실행결과가 저장될 변수
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			con = DBUtil.getConnect(); // DBMS 연결
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 Insert 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
}
