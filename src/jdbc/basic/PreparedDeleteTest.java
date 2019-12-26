package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDeleteTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedDeleteTest obj = new PreparedDeleteTest();
		System.out.print("boardnum:");
		int boardnum = key.nextInt();
		obj.Delete(boardnum);
	}

	public void Delete(int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;

		String sql = "delete tb_board where boardnum = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, boardnum);
			int res = ptmt.executeUpdate();
			System.out.println(res + "개 행 Update 성공! ");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
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
