package ex1_xml1;

public class MessageBeanKoImpl implements MessageBean {
	public MessageBeanKoImpl() {
		System.out.println("ko");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name + "님 맛점~^^");
	}
}
