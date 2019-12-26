package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedSelectTest {
	public static void main(String[] args) {
		PreparedSelectTest obj = new PreparedSelectTest();
		obj.Select();
	}

	public void Select() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "select * from tb_board";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
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
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����" + e.getMessage());
			e.printStackTrace();
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
}
