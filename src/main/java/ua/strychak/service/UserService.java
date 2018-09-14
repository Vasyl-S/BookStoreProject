package ua.strychak.service;

import java.util.List;

import ua.strychak.domain.UserDTO;

public interface UserService {
	
	void saveUser(UserDTO userDTO);
	
	UserDTO getById(Long id);
	
	List<UserDTO> getAllUsers();
			
	UserDTO findByUserEmail(String email);
	
	UserDTO findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	String signin(String username, String password);

	void verifyEmail(String verifyToken);




}
