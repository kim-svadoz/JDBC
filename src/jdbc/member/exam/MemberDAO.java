package jdbc.member.exam;

import jdbc.board.exam.MemberDTO;

public interface MemberDAO {
	int insert(MemberDTO member);
	int update(String addr, String id);
	int delete(String id);
}
