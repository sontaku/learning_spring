package ex5_autowired;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jdk.nashorn.internal.ir.annotations.Reference;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String message;
	
//	@Autowired
//	@Qualifier("op2")
	@Resource(name="op2")
	private Outputer op;
	/*
	 * 	멤버 지정
	 * 		1. 생성자 함수
	 * 		2. setter
	 * 		3. @Autowired
	 */
	
	public void sayHello() {
		System.out.println(name + " : " + message);
		try {
			op.writeMessage(name + "아 " + message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
