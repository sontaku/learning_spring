package aop1_xml;

//@Service("targetBean")
public class MessageBeanImpl implements MessageBean {
	@Override
	public void sayHello() {
		System.out.println("sayHello() 호출");
	}
	@Override
	public void engSayHello() {
		System.out.println("engSayHello() 호출");
	}
}
