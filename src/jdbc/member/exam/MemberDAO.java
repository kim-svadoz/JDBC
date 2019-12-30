package jdbc.member.exam;

import java.util.ArrayList;

public interface MemberDAO {
	int insert(MemberDTO member); // ������ 
	int update(String addr, String id); // �����������
	int delete(String id); // ���Ż��
	ArrayList<MemberDTO> memberList(); // ��ü ������ ��ȸ
	ArrayList<MemberDTO> findByAddr(String addr); // �ּҷ� ��� �˻��ϱ�
	MemberDTO login(String id, String pass); //�α���
}
