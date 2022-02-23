package tech.jaya.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.jaya.project.domain.User;
import tech.jaya.project.dto.UserAuthenticatedDTO;
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
	
	public List<UserAuthenticatedDTO> findAll() throws NotFoundException {
        
        List<UserAuthenticatedDTO> userDTO = new ArrayList<>();
		List<User> user = repository.findAll();

		
		if (user.isEmpty()) {
			
			logger.error("A Not Found error occurs.");
			
			throw new NotFoundException("User not found.");

		} else {

			for (User us : user) {
				UserAuthenticatedDTO dto = new UserAuthenticatedDTO(us);
				userDTO.add(dto);
			}
			logger.info("Request for user " + userDTO + " was successful.");
			
			return userDTO;
		}
    }
	
    public  List<UserAuthenticatedDTO> findById(Long id) throws NotFoundException {
    	
    	List<UserAuthenticatedDTO> userDTO = new ArrayList<>();
 		List<User> user = repository.findById(id);

 		if (user.isEmpty()) {
 			
 			logger.error("A Not Found error occurs.");
 			
 			throw new NotFoundException("User not found.");

 		} else {

 			for (User us : user) {
 				UserAuthenticatedDTO dto = new UserAuthenticatedDTO(us);
 				userDTO.add(dto);
 			}
 			logger.info("Request for user " + userDTO + " was successful.");
 			
 			return userDTO;
 		}
    }
// ************ 
    public List<UserAuthenticatedDTO> update(Long id, UserAuthenticatedDTO dto) throws NotFoundException {
    	
    	List<User> user = repository.findById(id);
    	
    	if (user.isEmpty()) {
			
			logger.error("A Not Found error occurs.");
			
			throw new NotFoundException("User not found.");

		} else {

    	user.get().setName(dto.getName());
    	user.get().setEmail(dto.getEmail());
        user.get().setLogin(dto.getLogin());
        
        logger.info("Update Request was successful.");
		
        return repository.save(user.get());
        
		}
    }

    public User delete(Long id) throws NotFoundException {
    	repository.deleteById(id);
    	return null;
    }
}