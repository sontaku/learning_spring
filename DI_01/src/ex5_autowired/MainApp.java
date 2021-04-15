package ex5_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex5_autowired/app.xml");
		
		MessageBean bean = context.getBean("message", MessageBean.class);
		bean.sayHello();
	}
}
