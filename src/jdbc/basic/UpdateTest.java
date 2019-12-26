package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			String sql = "UPDATE tb_board set ID='kang' where ID = 'jang' and boardnum = 2";
			int res = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패"+e.getMessage());
		}
	}
}