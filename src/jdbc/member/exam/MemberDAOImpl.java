package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.board.exam.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	public int insert(MemberDTO member) {
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into member values(?, ?, ?, ?, ?, sysdate, 1000)";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, member.getId());
			ptmt.setString(2, member.getPass());
			ptmt.setString(3, member.getName());
			ptmt.setString(4, member.getAddr());
			ptmt.setString(5, member.getDeptno());
			result = ptmt.executeUpdate();
			System.out.println(result+"俺 青 Insert 己傍! ");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int update(String addr, String id) {
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update member set Addr = ? where id = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"俺 青 update 己傍! ");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return result;
	}
	
	public int delete(String id) {
		PreparedStatement ptmt = null;
		Connection con = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "delete member where id = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"俺 青 delete 己傍! ");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return result;
	}
	
}
