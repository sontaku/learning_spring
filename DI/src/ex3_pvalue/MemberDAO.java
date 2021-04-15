package ex3_pvalue;

public class MemberDAO {
	private MemberBean memBean;
	
	// 생성자
	public MemberDAO() {
	}
	public MemberDAO(MemberBean memBean) {
		this.memBean = memBean;
	}
	
	// setter
	public void setMemBean(MemberBean memBean) {
		this.memBean = memBean;
	}

	
	
	public void insert() {
		System.out.println(memBean.getName() + "님의 메세지 : " + memBean.getMessage());
	}
}
