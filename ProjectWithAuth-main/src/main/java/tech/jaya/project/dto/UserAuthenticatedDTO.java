package tech.jaya.project.dto;

import tech.jaya.project.domain.User;
import tech.jaya.project.security.JWTAuthFilter;

public class UserAuthenticatedDTO {
	
	private Long id;
	
	private String name;
	
	private String login;
	
	private String email;
	
	private String token;
	
	public UserAuthenticatedDTO() {
	}

	public UserAuthenticatedDTO(Long id, String name, String login, String email, String token) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.email = email;
		this.token = token;
	}
	
	public static UserAuthenticatedDTO toDTO(User user, JWTAuthFilter token) {
		return new UserAuthenticatedDTO(user.getId(), user.getEmail(), user.getName(),user.getLogin(), token.getToken());
		
	}
	
	public UserAuthenticatedDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.name = user.getLogin();
		this.email = user.getEmail();
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
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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