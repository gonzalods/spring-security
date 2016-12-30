package org.gms.springsecurity.config;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Login {

	private AuthenticationManager authenticationManager;
	
	@Autowired
	public Login(AuthenticationManager authenticationManager){
		this.authenticationManager = authenticationManager;
	}
	
	public void login(){
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.print("Nombre Usuario:");
			String username = scan.nextLine();
			System.out.print("Contraseña:");
			String contrasena = scan.nextLine();
			try{
				Authentication token = new UsernamePasswordAuthenticationToken(username, contrasena);
				Authentication auth = authenticationManager.authenticate(token);
				SecurityContextHolder.getContext().setAuthentication(auth);
				break;
			} catch (AuthenticationException e) {
				System.out.println("Autentificación erronea. Vuelva a intentarlo.");
			}
		}
		System.out.println("Autentificacion correcta con " + SecurityContextHolder.getContext().getAuthentication());
		scan.close();
	}
}
