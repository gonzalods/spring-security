package org.gms.springsecurity.xml.inmemory;

import org.gms.springsecurity.xml.Login;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppInMemoryXml {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-inmemory-xml.xml");
		
		Login login = ctx.getBean(Login.class);
		login.login();

		((ClassPathXmlApplicationContext)ctx).close();
	}

}
