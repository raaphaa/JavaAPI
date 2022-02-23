
package tech.jaya.project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import tech.jaya.project.data.UserDetailData;
import tech.jaya.project.domain.User;
import tech.jaya.project.repository.UserRepository;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	public UserDetailServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByLogin(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User [" + username + "] not found");
		}

		return new UserDetailData(user);
	}

}
