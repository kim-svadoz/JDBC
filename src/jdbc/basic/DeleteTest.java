package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott"; 
		String password = "tiger"; 
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tb_board  ");
		sql.append("where boardnum=4");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패"+e.getMessage());
		}
	}
}
