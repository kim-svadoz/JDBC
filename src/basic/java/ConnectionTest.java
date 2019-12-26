package basic.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//����Ŭ ����
public class ConnectionTest {
	public static void main(String[] args) {
		// ���� ���ڿ� > � DBMS�� �����Ŀ� ���� ������ �޶���
		// 127.0.0.1 = Local Host(���� �۾����� �� PC)
		// ���� ���� DB ���� IP�� ����!
		// String url = "jdbc:oracle:thin:@70.12.115.65:1521:xe";
		String url = "jdbc:oracle:thin:@70.12.226.157:1521:xe";
		String user = "scott"; // ���� ����
		String password = "tiger"; // ���� ������ �н�����
		try {
			// 1. ����Ŭ ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����!");
			// 2. DBMS�� �����ϱ� - �������� �����ϱ�
			// >> DBMS�� �����ϰ� ���� ������ Connection Ÿ������ ��ȯ
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS ���� ����! " + con.toString());
			// 3. SQL�� �����ϱ� ���� ��ü Statement ����
			// - ���������� ������Ѿ� �� > Connection ��ü�� �̿��Ͽ� ����
			Statement stmt = con.createStatement();
			System.out.println("SQL �����ϱ� ���� ��ü ���� : " + stmt);
			// 4. SQL �����ϱ� & 5. ��� ó���ϱ�
			String sql = "INSERT INTO tb_board VALUES(board_seq.nextval, 'jang', 'Practice', 'practice', sysdate, 0)";
			int res = stmt.executeUpdate(sql);
			System.out.println("Insert ����! " + res);
		} catch (ClassNotFoundException e) { // ����̹� �ε� ����
			e.printStackTrace();
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) { // DBMS ���� ����
			e.printStackTrace();
			System.out.println("DBMS ���� ����" + e.getMessage());
		}
	}
}
