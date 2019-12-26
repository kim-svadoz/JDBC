package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedUpdateTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedUpdateTest obj = new PreparedUpdateTest();
		System.out.print("ID:");
		String id = key.next();
		System.out.print("boardnum:");
		int boardnum = key.nextInt();
		obj.Update(id, boardnum);
	}

	public void Update(String id, int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;
				
		String sql = "update tb_board set ID = ? where boardnum = ?";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setInt(2, boardnum);
			int res = ptmt.executeUpdate();
			System.out.println(res+"�� �� Update ����! ");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����"+ e.getMessage());
			e.printStackTrace();
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
//�޼ҵ� �ۼ�, �ڵ庹��, ����, �ڿ��ݳ�, ��������