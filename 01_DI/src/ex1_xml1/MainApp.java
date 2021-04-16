package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// 0. 기존 자바 방식 POJO
//		MessageBean bean = new MessageBeanKoImpl();
//		bean.sayHello("홍길동");
//		MessageBean bean2 = new MessageBeanEnImpl();
//		bean2.sayHello("mr.Hong");

		// 1. 스프링 방식
		// (1) 스프링 설정파일 연결
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml1/applicationContext.xml");

		// (2) 컨테이너에서 빈 가져오기
		MessageBean beanKo1 = (MessageBean) context.getBean("ko");
		MessageBean beanKo2 = (MessageBean) context.getBean("ko");
		MessageBean beanEn1 = (MessageBean) context.getBean("en");
		MessageBean beanEn2 = (MessageBean) context.getBean("en");
		
		beanKo1.sayHello("홍길동");
		beanKo2.sayHello("임꺽정");
		beanEn1.sayHello("Smith");
		beanEn2.sayHello("Scott");
		
	}
}
