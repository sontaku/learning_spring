package aop1_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop1_xml/applicationContext.xml");
		MessageBean mb = (MessageBean) context.getBean("targetBean");
		mb.sayHello();
		System.out.println("-------------------------------");
		mb.engSayHello();
		System.out.println("-------------------------------");
		
		mb.test();
	}
}
