package ex4_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	// 생성된 객체 전달
	@Autowired
	private MemberBean memBean;
	/*
	 * 	injection
	 * 	생성자도 없고, setter 없고 private 상황에서 주입
	 */
	
	public void insert() {
		System.out.println(memBean.getName() + "님의 메세지 : " + memBean.getMessage());
	}
}
