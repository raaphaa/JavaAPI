package tech.jaya.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tech.jaya.project.domain.User;

@SpringBootApplication
@EnableSwagger2
public class Application {

	  @Bean 
	  public PasswordEncoder getPasswordEncoder() { 
		  
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		  
		return encoder; 
	 }
	 
	 
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}