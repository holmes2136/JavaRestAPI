package sherlock.holmes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringAOPDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans-config.xml");
		
		IHello helloProxy = (IHello)context.getBean("helloProxy");
		
		helloProxy.hello("Holmes");
		
	}
}
