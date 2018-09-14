package ua.strychak.service.impl;

import static ua.strychak.constants.ErrorMessages.NO_RECORD_FOUND;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import ua.strychak.domain.AuthorDTO;
import ua.strychak.entity.Author;
import ua.strychak.exceptions.AuthorNotFoundException;
import ua.strychak.repository.AuthorRepository;
import ua.strychak.service.AuthorService;
import ua.strychak.service.cloudinary.CloudinaryService;
import ua.strychak.service.utils.ObjectMapperUtils;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private ObjectMapperUtils objectMapper;
	
	@Autowired
	private CloudinaryService cloudinaryService;

	@Override
	public void save(AuthorDTO authorDTO) {
		Author author = objectMapper.map(authorDTO, Author.class);
		authorRepository.save(author);

	}

	@Override
	public AuthorDTO findAuthorById(Long id) {
		Author author = authorRepository.findById(id).get();
		AuthorDTO authorDTO = objectMapper.map(author, AuthorDTO.class);
		return authorDTO;
	}

	@Override
	public List<AuthorDTO> getAllAuthors() {
		List<Author> author = authorRepository.findAll();
		List<AuthorDTO> authorDTOs = objectMapper.mapAll(author, AuthorDTO.class);
		return authorDTOs;
	}

	@Override
	public void update(AuthorDTO author) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uploadImage(MultipartFile file, Long id) {
		String imageUrl = cloudinaryService.uploadFile(file, "authors");
		
		Author author = authorRepository.findById(id).get();
		if(author == null) {
			throw new AuthorNotFoundException(NO_RECORD_FOUND);
		}
		
		author.setImageUrl(imageUrl);
		authorRepository.save(author);
	}

	@Override
	public boolean existsByEmail(String email) {
		return authorRepository.existsByEmail(email);
	}

}
