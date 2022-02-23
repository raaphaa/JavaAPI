package tech.jaya.project.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserResgisterDTO {
	
	@ApiModelProperty(value = "The Login", name = "login", required = true, position = 0)
	@NotBlank
	private String login;
		
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(value = "The user Password", name = "password", required = true,example = "123456", position = 3)
	@NotBlank
	private String password;
		
	@ApiModelProperty(value = "The user email", name = "email", required = true,example = "JaneDoe@gmail.com", position = 2)
	@NotBlank
	private String email;
	
	@ApiModelProperty(value = "The username ", name = "name", required = true, example = "Jane Doe",position = 1)
	@NotBlank
	private String name;

	public UserResgisterDTO() {
		super();
	}

	public UserResgisterDTO( String login, String password, String email, String name) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, login, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResgisterDTO other = (UserResgisterDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UserCadastroDTO: "
				+ "\nLogin: " + login 
				+ "\nEmail: " + email
				+ "\nNome: " + name;
	}
}