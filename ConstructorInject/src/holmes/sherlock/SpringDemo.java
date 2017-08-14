package holmes.sherlock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringDemo {

	
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans-config.xml");
		
		HelloBean hello = (HelloBean)context.getBean("helloBean");
		
		System.out.println("name: ");
		System.out.println(hello.getName());
		System.out.println("world: ");
		System.out.println(hello.getHelloWorld());
	}
}
