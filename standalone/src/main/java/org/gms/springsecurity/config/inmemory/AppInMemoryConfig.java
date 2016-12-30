package org.gms.springsecurity.config.inmemory;


import org.gms.springsecurity.config.Login;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInMemoryConfig {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Login login = ctx.getBean(Login.class);
		login.login();

		((AnnotationConfigApplicationContext)ctx).close();

	}

}
