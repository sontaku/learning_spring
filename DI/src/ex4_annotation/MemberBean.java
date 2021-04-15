package ex4_annotation;

import org.springframework.stereotype.Component;

// bean
@Component
public class MemberBean {
	private String name;
	private int age;
	private String message;
	
	public void output() {
		System.out.println(name + "[" + age + "]" + message);
	}

	// 생성자를 통해 bean 객체 인자 전달받음
//	public MemberBean(String name, int age, String message) {
//		super();
//		this.name = name;
//		this.age = age;
//		this.message = message;
//	}

	// 프로퍼티 활용을 위한 기본 생성자
	public MemberBean() {
		this.name = "X맨";
		this.age = 50;
		this.message = "오늘도즐겁게";
	}
	
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getMessage() {
		return message;
	}

	
	// 프로퍼티를 통해 bean 객체 인자 전달받음
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
