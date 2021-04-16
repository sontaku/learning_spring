package ex2_value_ref;

public class MemberDAO {
	private MemberBean memberBean;
	
	// 생성자
	public MemberDAO() {
	}
	public MemberDAO(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	// setter
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	public void insert() {
		System.out.println(memberBean.getName() + "님의 메세지 : " + memberBean.getMessage());
	}
}
