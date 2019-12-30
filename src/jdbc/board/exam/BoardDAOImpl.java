package jdbc.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			System.out.println(rs + "개 행 findbytitle 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
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
				// PK로 정의했기 때문에 결과가 하나다. => while로 할 필요없고 if로 할 수 있다.
			}
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return board;
	}
	
	//조회한 결과를 ArrayList로 변환하여 리턴
	public ArrayList<BoardDTO> Select() {
		//전체 게시글을 담을 Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		//조회한 게시글을 담을 객체
		//객체를 생성하지 않고 null로 초기화하는 이유
		//=> 데이터를 조회한는 작업을 하는 곳이 while문 내부이므로 while문에서 조회된 레코드로 객체를 생성
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
			while (rs.next()) { // 레코드를 조회하기 위해서는 레코드가 한 개라도 반드시 커서를 이동시켜야 한다.
				//1. 조회된 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6));
				//2. DTO로 변환된 레코드를 Arraylist 에 추가
				boardlist.add(board);
			}
			System.out.println(result + "개 행 Select 성공! ");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
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
