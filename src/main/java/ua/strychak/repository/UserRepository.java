package ua.strychak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.strychak.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	boolean existsByUsername(String username);

	User findByUsername(String username);

	User findByEmailVerificationToken(String token);

}
