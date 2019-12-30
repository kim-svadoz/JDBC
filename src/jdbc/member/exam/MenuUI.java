package jdbc.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	MemberDAO dao = new MemberDAOImpl();
	public void insertMenu(){
		//�Ի����� ���ó�¥ - sysdate, point = 1000�� ���Եǵ���
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		System.out.print("�μ���ȣ:");
		String deptno = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		MemberDTO member = new MemberDTO(id, pass, name, addr, deptno);
		int result = dao.insert(member);
		if(result>0) {
			System.out.println("ȸ����� ����");
		}else {
			System.out.println("ȸ�� ��� ����");
		}
		
	}
	public void updateMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(addr, id);
		if(result>0) {
			System.out.println("ȸ�� ���� ����");
		}else {
			System.out.println("ȸ�� ���� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(id);
		if(result>0) {
			System.out.println("ȸ�� ��� ����");
		}else {
			System.out.println("ȸ�� ���� ����");
		}
	}
	
	public void memberListMenu(){
		ArrayList<MemberDTO> memberlist = dao.memberList();
		int size = memberlist.size();
		for (int i = 0; i < size; i++) {
			MemberDTO member = memberlist.get(i);
			System.out.println(member.getId()+"\t"+member.getName()+"\t"+member.getAddr()
			+"\t"+member.getDeptno());
		}
	}
	public void findByAddrMenu(){
		System.out.println("*******�ּҷλ���˻�********");
		System.out.print("�ּ�:");
		String addr = key.next();
		ArrayList<MemberDTO> memberlist = dao.findByAddr(addr);
		int size = memberlist.size();
		for (int i = 0; i < size; i++) {
			MemberDTO member = memberlist.get(i);
			System.out.println("���̵�:" + member.getId());
			System.out.println("�н�����:" + member.getPass());
			System.out.println("�̸�:" + member.getName());
			System.out.println("�ּ�:" + member.getAddr());
			System.out.println("�μ���ȣ:" + member.getDeptno());
		}
	}
	public void loginMenu() {
		System.out.println("********�α�����ȸ**********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("��й�ȣ:");
		String pass = key.next();
		MemberDTO memberlist = dao.login(id, pass);
		if(memberlist == null) {
			System.out.println("�α��� ����");
		}else {
			System.out.println("�α��� ����");
		}
	}
}





