package ex1_xml1;

public class MessageBeanEnImpl implements MessageBean {
	public MessageBeanEnImpl() {
		System.out.println("en");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hey " + name + " eat well ^^");
	}
}
