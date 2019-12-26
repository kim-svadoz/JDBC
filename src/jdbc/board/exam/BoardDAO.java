package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAO {
	
	public void Select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "select * from tb_board";

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			int res = ptmt.executeUpdate();
			ResultSet rs = ptmt.executeQuery(sql);
			while (rs.next()) { // ���ڵ带 ��ȸ�ϱ� ���ؼ��� ���ڵ尡 �� ���� �ݵ�� Ŀ���� �̵����Ѿ� �Ѵ�.
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString("content") + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.println(rs.getInt(6) + "\t");
			}

			System.out.println(res + "�� �� Select ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void Delete(int boardnum) {
		Connection con = null;
		PreparedStatement ptmt = null;

		String sql = "delete tb_board where boardnum = ?";

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, boardnum);
			int res = ptmt.executeUpdate();
			System.out.println(res + "�� �� Delete ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Update(String id, int boardnum) {
		PreparedStatement ptmt = null;
		Connection con = null;
		String sql = "update tb_board set ID = ? where boardnum = ?";
		try {
			con = DBUtil.getConnect(); // DBMS ����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			int res = ptmt.executeUpdate();
			System.out.println(res+"�� �� Update ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(ptmt!= null) ptmt.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Insert(String id, String title, String content) {
		PreparedStatement ptmt = null;
		Connection con = null;
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			con = DBUtil.getConnect(); // DBMS ����
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			int res = ptmt.executeUpdate();
			System.out.println(res+"�� �� Insert ����! ");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����" + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(ptmt!= null) ptmt.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
