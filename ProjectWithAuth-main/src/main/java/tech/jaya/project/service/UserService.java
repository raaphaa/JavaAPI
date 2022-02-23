package tech.jaya.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.jaya.project.domain.User;
import tech.jaya.project.dto.UserResgisterDTO;
import tech.jaya.project.exception.NotFoundException;
import tech.jaya.project.repository.UserRepository;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	public UserResgisterDTO createUser(UserResgisterDTO userDTO) throws NotFoundException {
	
		if (userDTO == null) {
			
			logger.error("A Not Found error occurs for userDTO.");
			throw new NotFoundException("Cannot register an empty user.");

		} else {
			
			User userCreated = new User();
			userCreated.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
			userCreated.setLogin(userDTO.getLogin());
			userCreated.setName(userDTO.getName());
			userCreated.setEmail(userDTO.getEmail());
			repository.save(userCreated);
			
			logger.info("Request for user was successful.");
			
			return null ;	
		}
	}
}