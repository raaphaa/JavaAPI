
package tech.jaya.project.data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tech.jaya.project.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailData implements UserDetails {

	private static final long serialVersionUID = -6839547576911743635L;
	
	private final Optional<User> UserData;

	public UserDetailData(Optional<User> UserData) {
		this.UserData = UserData;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return UserData.orElse(new User()).getPassword();
	}

	@Override
	public String getUsername() {
		return UserData.orElse(new User()).getLogin();
	}
	
	public String getEmail() {
		return UserData.orElse(new User()).getEmail();
	}

	
	public String getName() {
		return UserData.orElse(new User()).getName();
	}

	public Long getId() {
		return UserData.orElse(new User()).getId();
	}

	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
