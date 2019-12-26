package jdbc.basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedInsertTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("**********게시글 등록**********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("제목:");
		String title = key.next();
		System.out.print("내용:");
		String content = key.next();
		obj.insert(id, title, content);
	}

	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;
		/*String sql = "INSERT INTO tb_board VALUES(board_seq.nextval, '"+id+"','"+title+
				"','" + content + "',sysdate,0)"; // 보안취약해서 안써~ */
				
		String sql = "insert into tb_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			//1. PreparedStatement 생성			
			ptmt = con.prepareStatement(sql);
			//2. ?에 값 전달하기
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			//3. 실행하기
			int res = ptmt.executeUpdate();
			System.out.println(res+"개 행 Insert 성공! ");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+ e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
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
