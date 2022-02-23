package tech.jaya.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.jaya.project.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByLogin(String login);
    
    public User deleteById(Long id);

	public List<User> findById(Long id);

}