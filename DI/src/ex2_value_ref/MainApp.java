package ex2_value_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex2_value_ref/applicationContext.xml");
	
		// MemberBean.class을 통해 MemberBean 타입으로 형변환
//		MemberBean mb = context.getBean("member", MemberBean.class);
//		MemberBean mb2 = context.getBean("member2", MemberBean.class);
		
		// old version
//		mb.setName("홍");
//		mb.setAge(20);
//		mb.setMessage("하이");
		
//		mb.output();
//		mb.output();
//		mb2.output();
	
		MemberDAO dao = context.getBean("dao", MemberDAO.class);
		dao.insert();

		MemberDAO dao2 = context.getBean("dao2", MemberDAO.class);
		dao2.insert();
	}
}
