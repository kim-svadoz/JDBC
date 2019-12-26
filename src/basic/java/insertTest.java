package basic.java;

import java.sql.*;

public class insertTest {
	public static void main(String[] args) {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "scott";
			String password = "tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e.getMessage());
		}
		catch(SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
		}
		
	}
}