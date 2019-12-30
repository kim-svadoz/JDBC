package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.BoardDTO;
import jdbc.board.exam.DBUtil;

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
			System.out.println(result+"개 행 Insert 성공! ");
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
			System.out.println(result+"개 행 update 성공! ");
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
			System.out.println(result+"개 행 delete 성공! ");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return result;
	}
	
	public ArrayList<MemberDTO> memberList(){
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery(sql);
			while (rs.next()) { 
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			System.out.println("DBMS 연결 실패" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memberlist;
	}

	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member where addr like ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, addr);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memberlist;
	}

	public MemberDTO login(String id, String pass) {
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ? and pass = ? ";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs = ptmt.executeQuery();
			while(rs.next()) {
			member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return member;
	}
}
