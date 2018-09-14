package ua.strychak.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.strychak.domain.AuthorDTO;

public interface AuthorService {
	
	void save(AuthorDTO authorDTO);
	
	AuthorDTO findAuthorById(Long id);
	
	List<AuthorDTO> getAllAuthors();
	
	void update(AuthorDTO author);
	
	void uploadImage(MultipartFile file, Long id);
	
	boolean existsByEmail(String email);

	


	

}
