package tech.jaya.project.dto;

import tech.jaya.project.domain.User;
import tech.jaya.project.security.JWTAuthFilter;


public class UserAuthenticatedDTO {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String token;
	
	
	

	public UserAuthenticatedDTO() {
		super();
	}



	public UserAuthenticatedDTO(Long id, String name, String email, String token) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.token = token;
	}
	
	public static UserAuthenticatedDTO toDTO(User user, JWTAuthFilter token) {
		return new UserAuthenticatedDTO(user.getId(), user.getEmail(), user.getName(), token.getToken());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}




	
	
}
