package springwelcome;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

public class ClientLogin {
	
	public static void main(String[] args) {
		Resource res = new ClassPathResource("spconfig.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		
		WelcomeBean wb = (WelcomeBean)factory.getBean("id1");
		
		wb.show();
	}
}
