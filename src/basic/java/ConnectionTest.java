package basic.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//오라클 접속
public class ConnectionTest {
	public static void main(String[] args) {
		// 연결 문자열 > 어떤 DBMS를 쓰느냐에 따라 형식이 달라짐
		// 127.0.0.1 = Local Host(현재 작업중인 내 PC)
		// 원격 실제 DB 서버 IP도 가능!
		// String url = "jdbc:oracle:thin:@70.12.115.65:1521:xe";
		String url = "jdbc:oracle:thin:@70.12.226.157:1521:xe";
		String user = "scott"; // 접속 계정
		String password = "tiger"; // 접속 계정의 패스워드
		try {
			// 1. 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
			// 2. DBMS에 연결하기 - 연결정보 정의하기
			// >> DBMS에 연결하고 연결 정보를 Connection 타입으로 반환
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS 연결 성공! " + con.toString());
			// 3. SQL을 실행하기 위한 객체 Statement 생성
			// - 연결정보와 연결시켜야 함 > Connection 객체를 이용하여 생성
			Statement stmt = con.createStatement();
			System.out.println("SQL 실행하기 위한 객체 정보 : " + stmt);
			// 4. SQL 실행하기 & 5. 결과 처리하기
			String sql = "INSERT INTO tb_board VALUES(board_seq.nextval, 'jang', 'Practice', 'practice', sysdate, 0)";
			int res = stmt.executeUpdate(sql);
			System.out.println("Insert 성공! " + res);
		} catch (ClassNotFoundException e) { // 드라이버 로딩 오류
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) { // DBMS 연결 오류
			e.printStackTrace();
			System.out.println("DBMS 연결 실패" + e.getMessage());
		}
	}
}
